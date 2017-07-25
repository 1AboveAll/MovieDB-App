package com.example.andro.moviedb.MovieTap.CastFragment;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andro on 25-07-2017.
 */

public class CastResponse {

    @SerializedName("cast")
    List<Cast>getCast;
    @SerializedName("crew")
    List<Crew>getCrew;


}
