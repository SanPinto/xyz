package com.movie.app.movies.presenter;

import com.movie.app.common.rest.RestApiResponseCallback;
import com.movie.app.movies.interactor.MovieDetailInteractor;
import com.movie.app.movies.model.Movies;

/**
 * Created by sangeetha on 3/11/17.
 */

public class MoviePresenterImpl implements MoviesContract.MoviesPresenter, RestApiResponseCallback.RestAPICallbackListner {

    private MoviesContract.MovieListView mView;


    @Override
    public void setView(MoviesContract.MovieListView view) {
        mView = view;
    }

    @Override
    public void clearView() {
      mView = null;
    }

    @Override
    public void getMovieDetails(String category, String apiKey, int pageNum) {
        MovieDetailInteractor interactor = new MovieDetailInteractor();
        interactor.downloadMovieDetails(getCategory(category), apiKey, pageNum, this);
    }

    private String getCategory(String category) {
        if(category != null) {
            return category.replaceAll(" ", "_").toLowerCase();
        }
        return null;
    }

    @Override
    public void onResponseError(String errorMsg) {
        mView.showNetworkError(errorMsg);

    }

    @Override
    public <T> void onResponseSuccess(T response) {
        Movies movies = (Movies) response;
        if(movies != null) {
            mView.updateMoviesList(movies.results);
        }
    }
}
