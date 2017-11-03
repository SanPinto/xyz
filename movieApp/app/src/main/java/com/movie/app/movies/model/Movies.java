package com.movie.app.movies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sangeetha on 3/11/17.
 */

public class Movies {

    @SerializedName("total_results")
    public int totalCount;

    @SerializedName("total_pages")
    public int totalPages;

    public List<MovieItem> results;
}
