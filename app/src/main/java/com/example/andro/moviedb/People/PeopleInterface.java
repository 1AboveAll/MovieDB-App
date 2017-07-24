package com.example.andro.moviedb.People;

import com.example.andro.moviedb.MovieDBConstants;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by andro on 23-07-2017.
 */

public interface PeopleInterface {

    @GET("person/popular?api_key="+MovieDBConstants.API_KEY+"&language=en-US&page=1")
    Call<PeopleResponse> getTrending();

}
