package com.example.andro.moviedb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by andro on 20-07-2017.
 */

public interface MoviesInterface {

    @GET("now_playing?api_key="+MovieDBConstants.API_KEY+"&language=en-US")
    Call<MovieResponse> getPlaying();

    @GET("upcoming?api_key="+MovieDBConstants.API_KEY+"&language=en-US&region=US")
    Call<MovieResponse>getUpcoming();



}
