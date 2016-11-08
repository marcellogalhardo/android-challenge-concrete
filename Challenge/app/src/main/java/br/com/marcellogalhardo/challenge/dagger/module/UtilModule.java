package br.com.marcellogalhardo.challenge.dagger.module;

import br.com.marcellogalhardo.challenge.util.BrowserUtils;
import br.com.marcellogalhardo.challenge.util.ViewFlipperUtils;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

@Module public class UtilModule {

  @Provides @Reusable ViewFlipperUtils providesViewFlipperUtils() {
    return new ViewFlipperUtils();
  }

  @Provides @Reusable BrowserUtils providesBrowserUtils() {
    return new BrowserUtils();
  }
}
