package br.com.marcellogalhardo.challenge.dagger.module;

import br.com.marcellogalhardo.challenge.dagger.scope.FragmentScope;
import br.com.marcellogalhardo.challenge.service.GithubService;
import br.com.marcellogalhardo.challenge.ui.pullrequestlist.PullRequestListContract;
import br.com.marcellogalhardo.challenge.ui.pullrequestlist.PullRequestListPresenter;
import br.com.marcellogalhardo.challenge.ui.repositorylist.RepositoryListContract;
import br.com.marcellogalhardo.challenge.ui.repositorylist.RepositoryListPresenter;
import dagger.Module;
import dagger.Provides;

@Module public class PresenterModule {

  @Provides @FragmentScope RepositoryListContract.Presenter providesRepositoryListPresenter(
      GithubService githubService) {
    return new RepositoryListPresenter(githubService);
  }

  @Provides @FragmentScope PullRequestListContract.Presenter providesPullRequestPresenter(
      GithubService githubService) {
    return new PullRequestListPresenter(githubService);
  }
}
