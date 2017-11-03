package com.movie.app.movies.presenter;

import com.movie.app.common.presenter.BaseContract;
import com.movie.app.movies.model.MovieItem;

import java.util.List;

/**
 * Created by sangeetha on 3/11/17.
 */

public class MoviesContract extends BaseContract {

    public interface MoviesPresenter extends BasePresenter<MovieListView> {

        void getMovieDetails(String category, String apiKey, int pageNum);
    }

    public interface MovieListView {

        void updateMoviesList(List<MovieItem> results);

        void showNetworkError(String errorMsg);
    }
}
