package br.com.marcellogalhardo.challenge.ui.repositorylist;

import br.com.marcellogalhardo.challenge.service.GithubService;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RepositoryListPresenter implements RepositoryListContract.Presenter {

  private RepositoryListContract.View view;
  private GithubService githubService;

  @Inject public RepositoryListPresenter(GithubService githubService) {
    this.githubService = githubService;
  }

  @Override public void bindView(RepositoryListContract.View view) {
    this.view = view;
  }

  @Override public void unbindView() {
    this.view = null;
  }

  @Override public void getRepositories(int page) {
    githubService.getRepositories(GithubService.QUERY_LANGUAGE_JAVA, GithubService.SORT_STARS, page)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(repositoryList -> {
          view.showContent();
          view.addToRepositoryList(repositoryList);
        }, throwable -> {
          view.showError();
        });
  }
}
