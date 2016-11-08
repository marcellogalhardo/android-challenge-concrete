package br.com.marcellogalhardo.challenge.ui.pullrequestlist;

import br.com.marcellogalhardo.challenge.model.Repository;
import br.com.marcellogalhardo.challenge.service.GithubService;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PullRequestListPresenter implements PullRequestListContract.Presenter {

  private Repository repository;
  private PullRequestListContract.View view;
  private GithubService githubService;

  @Inject public PullRequestListPresenter(GithubService githubService) {
    this.githubService = githubService;
  }

  @Override public void bindView(PullRequestListContract.View view) {
    this.view = view;
  }

  @Override public void unbindView() {
    this.view = null;
  }

  @Override public void setRepository(Repository repository) {
    this.repository = repository;
  }

  @Override public Repository getRepository() {
    return repository;
  }

  @Override public void updateRepositoryInformation() {
    view.setupOpenedAndClosedInformation(this.repository);
  }

  @Override public void getPullRequests(String userName, String repositoryName) {
    githubService.getPullsByRepository(userName, repositoryName)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(pulls -> {
          view.showContent();
          view.setRepositoryListData(pulls);
        }, throwable -> {
          view.showError();
        });
  }
}
