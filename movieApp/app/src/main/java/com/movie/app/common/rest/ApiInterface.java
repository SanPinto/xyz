package com.movie.app.common.rest;

import com.movie.app.movies.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sangeetha on 3/11/17.
 */

public interface ApiInterface {

    @GET("movie/{category}")
    Call<Movies> getMovieDetails(@Path("category") String category, @Query("api_key") String apiKey, @Query("page") int pageNum);

}
