package com.example.andro.moviedb.MovieTap.InfoFragment;

import com.example.andro.moviedb.MovieDBConstants;
import com.example.andro.moviedb.Movies.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by andro on 27-07-2017.
 */

public interface InfoInterface {

    @GET("movie/{id}/similar?api_key="+ MovieDBConstants.API_KEY+"&language=en-US")
    Call<MovieResponse> similarMovies(@Path("id") int id);

    @GET("movie/{movie_id}/recommendations?api_key="+MovieDBConstants.API_KEY+"&language=en-US")
    Call<MovieResponse>recommendedMovies(@Path("movie_id")int movie_id);




}
