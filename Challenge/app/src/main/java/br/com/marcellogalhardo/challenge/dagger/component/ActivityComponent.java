package br.com.marcellogalhardo.challenge.dagger.component;

import br.com.marcellogalhardo.challenge.dagger.module.PresenterModule;
import br.com.marcellogalhardo.challenge.dagger.scope.ActivityScope;
import br.com.marcellogalhardo.challenge.ui.pullrequestlist.PullRequestListActivity;
import br.com.marcellogalhardo.challenge.ui.repositorylist.RepositoryListActivity;
import dagger.Subcomponent;

@ActivityScope @Subcomponent(modules = { PresenterModule.class })
public interface ActivityComponent {

  void inject(RepositoryListActivity activity);

  void inject(PullRequestListActivity activity);
}