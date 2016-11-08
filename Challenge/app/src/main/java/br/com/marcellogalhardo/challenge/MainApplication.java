package br.com.marcellogalhardo.challenge;

import android.app.Application;
import br.com.marcellogalhardo.challenge.dagger.component.DaggerMainComponent;
import br.com.marcellogalhardo.challenge.dagger.component.MainComponent;
import br.com.marcellogalhardo.challenge.dagger.module.ApplicationModule;

public class MainApplication extends Application {

  private MainComponent mainComponent;

  @Override public void onCreate() {
    super.onCreate();
    init();
  }

  private void init() {
    initDagger();
  }

  private void initDagger() {
    mainComponent =
        DaggerMainComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  public MainComponent getMainComponent() {
    return mainComponent;
  }
}