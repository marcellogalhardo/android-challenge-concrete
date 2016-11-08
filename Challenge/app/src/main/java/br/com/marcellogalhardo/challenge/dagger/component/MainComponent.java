package br.com.marcellogalhardo.challenge.dagger.component;

import br.com.marcellogalhardo.challenge.dagger.module.ApplicationModule;
import br.com.marcellogalhardo.challenge.dagger.module.NetworkModule;
import br.com.marcellogalhardo.challenge.dagger.module.PreferenceModule;
import br.com.marcellogalhardo.challenge.dagger.module.ServiceModule;
import br.com.marcellogalhardo.challenge.dagger.module.SettingModule;
import br.com.marcellogalhardo.challenge.dagger.module.UtilModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = {
    ApplicationModule.class, NetworkModule.class, PreferenceModule.class, ServiceModule.class,
    SettingModule.class, UtilModule.class
}) public interface MainComponent {

  ActivityComponent activityComponent();

  FragmentComponent fragmentComponent();
}