package com.movie.app.movies.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.movie.app.R;
import com.movie.app.common.views.StyledTextView;
import com.movie.app.movies.model.MovieItem;

import java.util.List;

/**
 * Created by sangeetha on 3/11/17.
 */

class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListHolder> {

    private List<MovieItem> mMoviesList;

    public MovieListAdapter(List<MovieItem> movieItems) {
        mMoviesList = movieItems;
    }

    @Override
    public MovieListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MovieListHolder holder, int position) {
        holder.setMovieItem(position);

    }

    @Override
    public int getItemCount() {
        return mMoviesList.size();
    }


    public class MovieListHolder extends RecyclerView.ViewHolder {

        private StyledTextView releaseDate, movieTitle, overView;
        private TextView rating;

        public MovieListHolder(View itemView) {
            super(itemView);
            movieTitle = (StyledTextView) itemView.findViewById(R.id.movie_title);
            releaseDate = (StyledTextView) itemView.findViewById(R.id.release_date);
            overView = (StyledTextView) itemView.findViewById(R.id.overview);
            rating = (TextView) itemView.findViewById(R.id.rating);
        }

        public void setMovieItem(int position) {
            MovieItem item = mMoviesList.get(position);
            movieTitle.setText(item.title);
            releaseDate.setText(item.releaseDate);
            overView.setText(item.overview);
            rating.setText(item.rating);

        }
    }
}
