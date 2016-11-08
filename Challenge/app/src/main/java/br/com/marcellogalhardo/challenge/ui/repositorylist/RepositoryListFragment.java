package br.com.marcellogalhardo.challenge.ui.repositorylist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;
import br.com.marcellogalhardo.challenge.R;
import br.com.marcellogalhardo.challenge.model.Repository;
import br.com.marcellogalhardo.challenge.model.RepositoryList;
import br.com.marcellogalhardo.challenge.ui.base.BaseFragment;
import br.com.marcellogalhardo.challenge.ui.base.EndlessScrollListener;
import br.com.marcellogalhardo.challenge.ui.pullrequestlist.PullRequestListActivity;
import br.com.marcellogalhardo.challenge.util.ViewFlipperUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;
import javax.inject.Inject;

public class RepositoryListFragment extends BaseFragment implements RepositoryListContract.View {

  public static final String TAG = "RepositoryListFragment";

  @BindView(R.id.viewflipper) ViewFlipper viewFlipper;
  @BindView(R.id.content_layout) RelativeLayout contentLayout;
  @BindView(R.id.loading_layout) RelativeLayout loadingLayout;
  @BindView(R.id.error_layout) RelativeLayout errorLayout;
  @BindView(R.id.repository_list) RecyclerView repositoryRecyclerView;

  @Inject RepositoryListContract.Presenter presenter;
  @Inject ViewFlipperUtils viewFlipperUtils;

  private RepositoryListAdapter adapter;
  private EndlessScrollListener scrollListener;

  public static RepositoryListFragment newInstance() {
    return new RepositoryListFragment();
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getFragmentComponent().inject(this);
    setRetainInstance(true);
    init();
  }

  private void init() {
    adapter = new RepositoryListAdapter();
    adapter.setOnClickListener(repository -> {
      PullRequestListActivity.startInstance(getContext(), repository);
    });
    scrollListener = new EndlessScrollListener() {
      @Override public void onLoadMore(int page, int totalItemsCount) {
        presenter.getRepositories(page + 1);
      }
    };
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_repository_list, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
    presenter.bindView(this);
    setupRepositoryList();
    if (savedInstanceState == null) {
      showLoading();
      presenter.getRepositories(1);
    }
  }

  @Override public void onStart() {
    super.onStart();
    presenter.bindView(this);
  }

  @Override public void onStop() {
    super.onStop();
    presenter.unbindView();
  }

  @Override public void showContent() {
    viewFlipperUtils.setDisplayedChild(viewFlipper, contentLayout);
  }

  @Override public void showLoading() {
    viewFlipperUtils.setDisplayedChild(viewFlipper, loadingLayout);
  }

  @Override public void showError() {
    viewFlipperUtils.setDisplayedChild(viewFlipper, errorLayout);
  }

  private void setupRepositoryList() {
    LinearLayoutManager manager = new LinearLayoutManager(getContext());
    repositoryRecyclerView.setLayoutManager(manager);
    scrollListener.setLayoutManager(manager);
    repositoryRecyclerView.addOnScrollListener(scrollListener);
    repositoryRecyclerView.setAdapter(adapter);
  }

  @Override public void addToRepositoryList(RepositoryList repositoryList) {
    List<Repository> repositories = repositoryList.items;
    if (repositories != null && !repositories.isEmpty()) {
      adapter.add(repositories);
    }
  }
}