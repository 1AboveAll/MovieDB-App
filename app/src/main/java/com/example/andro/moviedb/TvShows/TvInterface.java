package com.example.andro.moviedb.TvShows;

import com.example.andro.moviedb.MovieDBConstants;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by andro on 21-07-2017.
 */

public interface TvInterface {

    @GET("on_the_air?api_key="+ MovieDBConstants.API_KEY+"&language=en-US")
    Call<TvResponse> onTheAir();

    @GET("popular?api_key="+ MovieDBConstants.API_KEY+"&language=en-US")
    Call<TvResponse>popular();

    @GET("top_rated?api_key="+ MovieDBConstants.API_KEY+"&language=en-US")
    Call<TvResponse>topRated();
}