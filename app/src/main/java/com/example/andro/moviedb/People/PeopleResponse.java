package com.example.andro.moviedb.People;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andro on 23-07-2017.
 */

public class PeopleResponse {

    @SerializedName("results")
    public List<PeopleResults> peopleResultsList;

}
