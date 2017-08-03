package com.example.andro.moviedb.MovieTap;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andro on 28-07-2017.
 */

public class ImageResponse {

    private int id;

    @SerializedName("backdrops")
    List<MovieBackdrop>backdropList;
    @SerializedName("posters")


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
