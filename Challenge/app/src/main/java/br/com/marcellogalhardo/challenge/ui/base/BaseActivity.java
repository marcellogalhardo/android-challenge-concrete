package br.com.marcellogalhardo.challenge.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import br.com.marcellogalhardo.challenge.MainApplication;
import br.com.marcellogalhardo.challenge.dagger.component.ActivityComponent;
import br.com.marcellogalhardo.challenge.dagger.component.MainComponent;

public class BaseActivity extends AppCompatActivity {

  private ActivityComponent activityComponent;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupActivityComponent();
  }

  private void setupActivityComponent() {
    activityComponent = getMainComponent().activityComponent();
  }

  protected MainApplication getMainApplication() {
    return (MainApplication) getApplication();
  }

  protected MainComponent getMainComponent() {
    return getMainApplication().getMainComponent();
  }

  protected ActivityComponent getActivityComponent() {
    return activityComponent;
  }
}
