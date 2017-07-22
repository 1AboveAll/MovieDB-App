package com.example.andro.moviedb.TvShows;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andro on 21-07-2017.
 */

public class TvResponse {

    @SerializedName("results")
    List<TvResults> tvresults;
}
