package com.movie.app.movies.interactor;

import com.movie.app.common.rest.ApiClient;
import com.movie.app.common.rest.ApiInterface;
import com.movie.app.common.rest.RestApiResponseCallback;
import com.movie.app.movies.model.Movies;

import retrofit2.Call;

/**
 * Created by sangeetha on 3/11/17.
 */

public class MovieDetailInteractor {


    public void downloadMovieDetails(String category, String apiKey, int pageNum, RestApiResponseCallback.RestAPICallbackListner listner) {
        ApiInterface apiInterface = ApiClient.getInstance().getApiClient().create(ApiInterface.class);
        Call<Movies> movies = apiInterface.getMovieDetails(category, apiKey, pageNum);
        movies.enqueue(new RestApiResponseCallback<Movies>(listner));
    }
}
