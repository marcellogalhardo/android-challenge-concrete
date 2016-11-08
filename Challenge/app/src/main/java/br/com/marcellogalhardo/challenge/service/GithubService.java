package br.com.marcellogalhardo.challenge.service;

import br.com.marcellogalhardo.challenge.model.Pull;
import br.com.marcellogalhardo.challenge.model.RepositoryList;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface GithubService {

  public static final String QUERY_LANGUAGE_JAVA = "language:Java";
  public static final String SORT_STARS = "stars";

    /*
    @GET("search/repositories?q=language:Java&sort=stars")
    Observable<RepositoryList> getJavaRepositoriesByPage(@Query("page") int page);
    */

  @GET("search/repositories") Observable<RepositoryList> getRepositories(@Query("q") String q,
      @Query("sort") String sort, @Query("page") int page);

  @GET("repos/{user}/{repository}/pulls") Observable<List<Pull>> getPullsByRepository(
      @Path("user") String user, @Path("repository") String repository);
}

