package com.example.andro.moviedb.Movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andro on 19-07-2017.
 */

public class MovieResponse {
    @SerializedName("results")
    public List<MovieResults> results;


}


