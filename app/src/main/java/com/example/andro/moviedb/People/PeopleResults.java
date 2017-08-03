package com.example.andro.moviedb.People;

import com.example.andro.moviedb.Movies.MovieResults;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by andro on 23-07-2017.
 */

public class PeopleResults implements Serializable {

    private int id;
    private String profile_path;git
    private String name;
    @SerializedName("known_for")
    private List<KnownFor> knownForList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<KnownFor> getKnownForList() {
        return knownForList;
    }

    public void setKnownForList(List<KnownFor> knownForList) {
        this.knownForList = knownForList;
    }
}

