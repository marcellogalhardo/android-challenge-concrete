package br.com.marcellogalhardo.challenge.dagger.module;

import br.com.marcellogalhardo.challenge.service.GithubService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;

@Module
public class ServiceModule {

  @Provides @Singleton public GithubService providesGithubService(Retrofit retrofit) {
    return retrofit.create(GithubService.class);
  }

}
