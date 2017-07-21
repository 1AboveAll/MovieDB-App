package com.example.andro.moviedb;

import android.graphics.Movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andro on 19-07-2017.
 */

public class MovieResponse {
    @SerializedName("results")
    List<MovieResults> results;


}


  class MovieResults{

     private int id;
     private float vote;
     private String title;
     private String poster_path;
     private String overview;
     private String release_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getVote() {
        return vote;
    }

    public void setVote(float vote) {
        this.vote = vote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}