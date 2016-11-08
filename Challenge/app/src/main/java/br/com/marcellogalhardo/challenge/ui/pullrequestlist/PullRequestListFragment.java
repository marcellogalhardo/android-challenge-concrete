package br.com.marcellogalhardo.challenge.ui.pullrequestlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import br.com.marcellogalhardo.challenge.R;
import br.com.marcellogalhardo.challenge.model.Pull;
import br.com.marcellogalhardo.challenge.model.Repository;
import br.com.marcellogalhardo.challenge.ui.base.BaseFragment;
import br.com.marcellogalhardo.challenge.util.BrowserUtils;
import br.com.marcellogalhardo.challenge.util.ViewFlipperUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;
import javax.inject.Inject;

public class PullRequestListFragment extends BaseFragment implements PullRequestListContract.View {

  public static final String TAG = "PullRequestListFragment";

  @BindView(R.id.opened) TextView openedTextView;
  @BindView(R.id.closed) TextView closedTextView;
  @BindView(R.id.viewflipper) ViewFlipper viewFlipper;
  @BindView(R.id.content_layout) RelativeLayout contentLayout;
  @BindView(R.id.loading_layout) RelativeLayout loadingLayout;
  @BindView(R.id.error_layout) RelativeLayout errorLayout;
  @BindView(R.id.repository_list) RecyclerView pullRequestRecyclerView;

  @Inject PullRequestListContract.Presenter presenter;
  @Inject ViewFlipperUtils viewFlipperUtils;
  @Inject BrowserUtils browserUtils;

  private PullRequestListAdapter adapter;

  public static PullRequestListFragment newInstance(Repository repository) {
    Bundle args = new Bundle();
    args.putParcelable(Repository.KEY, repository);
    PullRequestListFragment fragment = new PullRequestListFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getFragmentComponent().inject(this);
    loadArguments();
    setRetainInstance(true);
    init();
  }

  private void init() {
    adapter = new PullRequestListAdapter();
    adapter.setOnClickListener(pull -> {
      browserUtils.open(getContext(), pull.url);
    });
  }

  private void loadArguments() {
    Bundle extras = getArguments();
    if (extras != null && extras.containsKey(Repository.KEY)) {
      Repository repository = extras.getParcelable(Repository.KEY);
      presenter.setRepository(repository);
    }
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_pull_request_list, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
    presenter.bindView(this);
    setupPullRequestList();
    if (savedInstanceState == null) {
      showLoading();
      Repository repository = presenter.getRepository();
      presenter.getPullRequests(repository.owner.login, repository.name);
    }
    presenter.updateRepositoryInformation();
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

  @Override public void setupOpenedAndClosedInformation(Repository repository) {
    openedTextView.setText(getString(R.string.pull_request_list_opened, repository.openIssues));
    closedTextView.setText(getString(R.string.pull_request_list_closed, repository.openIssues));
  }

  @Override public void setupPullRequestList() {
    LinearLayoutManager manager = new LinearLayoutManager(getContext());
    pullRequestRecyclerView.setLayoutManager(manager);
    pullRequestRecyclerView.setAdapter(adapter);
  }

  @Override public void setRepositoryListData(List<Pull> pulls) {
    if (pulls != null && !pulls.isEmpty()) {
      adapter.add(pulls);
    }
  }
}