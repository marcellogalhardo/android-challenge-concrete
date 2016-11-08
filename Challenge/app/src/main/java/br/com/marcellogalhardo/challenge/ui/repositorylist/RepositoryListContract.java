package br.com.marcellogalhardo.challenge.ui.repositorylist;

import br.com.marcellogalhardo.challenge.model.RepositoryList;

public interface RepositoryListContract {

  interface View {
    void showContent();

    void showLoading();

    void showError();

    void addToRepositoryList(RepositoryList repositoryList);
  }

  interface Presenter {
    void bindView(View view);

    void unbindView();

    void getRepositories(int page);
  }
}
