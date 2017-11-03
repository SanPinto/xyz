package com.movie.app.movies.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sangeetha on 3/11/17.
 */

public class MovieItem {

    @SerializedName("vote_average")
    public String rating;

    public String title;

    public String overview;

    @SerializedName("release_date")
    public String releaseDate;

}
