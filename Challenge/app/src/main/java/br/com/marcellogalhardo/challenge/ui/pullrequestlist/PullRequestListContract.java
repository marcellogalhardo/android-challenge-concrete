package br.com.marcellogalhardo.challenge.ui.pullrequestlist;

import br.com.marcellogalhardo.challenge.model.Pull;
import br.com.marcellogalhardo.challenge.model.Repository;
import java.util.List;

public interface PullRequestListContract {

  interface View {
    void showContent();

    void showLoading();

    void showError();

    void setupOpenedAndClosedInformation(Repository repository);

    void setupPullRequestList();

    void setRepositoryListData(List<Pull> pulls);
  }

  interface Presenter {
    void bindView(PullRequestListContract.View view);

    void unbindView();

    void setRepository(Repository repository);

    Repository getRepository();

    void updateRepositoryInformation();

    void getPullRequests(String userName, String repositoryName);
  }
}
