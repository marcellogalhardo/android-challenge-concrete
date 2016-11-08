package br.com.marcellogalhardo.challenge.dagger.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

@Module public class SettingModule {

  public static final String BASE_URL = "App.Setting.Url.Github";

  @Provides @Singleton @Named(BASE_URL) String providesServerUrl(Context context) {
    return "https://api.github.com/";
  }
}