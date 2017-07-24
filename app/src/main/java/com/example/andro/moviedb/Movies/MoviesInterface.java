package com.example.andro.moviedb.Movies;

import com.example.andro.moviedb.MovieDBConstants;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by andro on 20-07-2017.
 */

public interface MoviesInterface {

    @GET("movie/now_playing?api_key="+ MovieDBConstants.API_KEY+"&language=en-US")
    Call<MovieResponse> getPlaying();

    @GET("movie/upcoming?api_key="+MovieDBConstants.API_KEY+"&language=en-US&region=US")
    Call<MovieResponse>getUpcoming();

    @GET("movie/popular?api_key="+MovieDBConstants.API_KEY+"&language=en-US&page=1&region=US")
    Call<MovieResponse>getPopular();

    @GET("movie/top_rated?api_key=ff84ecf0eb88cbd7e16b4300ac4133df&language=en-US&page=1")
    Call<MovieResponse>topRated();




}
