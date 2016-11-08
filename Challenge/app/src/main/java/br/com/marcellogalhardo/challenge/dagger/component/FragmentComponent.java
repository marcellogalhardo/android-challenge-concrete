package br.com.marcellogalhardo.challenge.dagger.component;

import br.com.marcellogalhardo.challenge.dagger.module.PresenterModule;
import br.com.marcellogalhardo.challenge.dagger.scope.FragmentScope;
import br.com.marcellogalhardo.challenge.ui.pullrequestlist.PullRequestListFragment;
import br.com.marcellogalhardo.challenge.ui.repositorylist.RepositoryListFragment;
import dagger.Subcomponent;

@FragmentScope @Subcomponent(modules = { PresenterModule.class })
public interface FragmentComponent {

  void inject(RepositoryListFragment fragment);

  void inject(PullRequestListFragment fragment);
}