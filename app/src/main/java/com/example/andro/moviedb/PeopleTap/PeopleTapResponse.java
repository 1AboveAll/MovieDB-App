package com.example.andro.moviedb.PeopleTap;

import android.graphics.Movie;

import com.example.andro.moviedb.MovieTap.MovieBackdrop;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andro on 31-07-2017.
 */

public class PeopleTapResponse {
    private String birthday;
    private String deathday;
    private String name;
    @SerializedName("images")
    images images;
    private String biography;
    @SerializedName("place_of_birth")
    private String pob;
    private String profile_path;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDeathday() {
        return deathday;
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    private int gender;

}

class images{
    private List<MovieBackdrop> profiles;

    public List<MovieBackdrop> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<MovieBackdrop> profiles) {
        this.profiles = profiles;
    }
}