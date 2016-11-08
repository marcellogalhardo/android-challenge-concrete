package br.com.marcellogalhardo.challenge.ui.repositorylist;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import br.com.marcellogalhardo.challenge.R;
import br.com.marcellogalhardo.challenge.ui.base.BaseActivity;
import br.com.marcellogalhardo.challenge.ui.base.BaseFragment;

public class RepositoryListActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_repository_list);
    bindFragment();
  }

  private void bindFragment() {
    FragmentManager manager = getSupportFragmentManager();
    if (manager.findFragmentByTag(RepositoryListFragment.TAG) == null) {
      BaseFragment fragment = RepositoryListFragment.newInstance();
      manager.beginTransaction()
          .replace(R.id.container_fragment, fragment, RepositoryListFragment.TAG)
          .commit();
    }
  }
}
