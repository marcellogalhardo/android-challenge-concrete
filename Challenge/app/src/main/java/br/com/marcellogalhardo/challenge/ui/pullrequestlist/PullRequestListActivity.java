package br.com.marcellogalhardo.challenge.ui.pullrequestlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import br.com.marcellogalhardo.challenge.R;
import br.com.marcellogalhardo.challenge.model.Repository;
import br.com.marcellogalhardo.challenge.ui.base.BaseActivity;
import br.com.marcellogalhardo.challenge.ui.base.BaseFragment;

public class PullRequestListActivity extends BaseActivity {

  private Repository repository;

  public static void startInstance(Context context, Repository repository) {
    Intent intent = new Intent(context, PullRequestListActivity.class);
    intent.putExtra(Repository.KEY, repository);
    context.startActivity(intent);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pull_request_list);
    loadExtras();
    setupActionBar();
    bindFragment();
  }

  private void setupActionBar() {
    setTitle(repository.name);
    ActionBar bar = getSupportActionBar();
    if (bar != null) {
      bar.setDisplayHomeAsUpEnabled(true);
      bar.setDisplayShowHomeEnabled(true);
    }
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    int itemId = item.getItemId();
    if (itemId == android.R.id.home) {
      finish();
    }
    return super.onOptionsItemSelected(item);
  }

  private void loadExtras() {
    Bundle extras = getIntent().getExtras();
    if (extras != null && extras.containsKey(Repository.KEY)) {
      repository = extras.getParcelable(Repository.KEY);
    }
  }

  private void bindFragment() {
    FragmentManager manager = getSupportFragmentManager();
    if (manager.findFragmentByTag(PullRequestListFragment.TAG) == null) {
      BaseFragment fragment = PullRequestListFragment.newInstance(repository);
      manager.beginTransaction()
          .replace(R.id.container_fragment, fragment, PullRequestListFragment.TAG)
          .commit();
    }
  }
}
