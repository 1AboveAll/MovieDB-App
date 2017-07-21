package com.example.andro.moviedb.TvShows;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andro on 21-07-2017.
 */

public class TvResults {

    private int id;
    private String name;
    @SerializedName("vote_count")
    private int number_of_votes;
    @SerializedName("vote_average")
    private float votes;
    private String poster_path;
    private String first_air_date;
    private String overview;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_of_votes() {
        return number_of_votes;
    }

    public void setNumber_of_votes(int number_of_votes) {
        this.number_of_votes = number_of_votes;
    }

    public float getVotes() {
        return votes;
    }

    public void setVotes(float votes) {
        this.votes = votes;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
