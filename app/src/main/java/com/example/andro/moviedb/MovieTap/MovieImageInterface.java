package com.example.andro.moviedb.MovieTap;

import com.example.andro.moviedb.MovieDBConstants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by andro on 28-07-2017.
 */

public interface MovieImageInterface {

    @GET("movie/{id}/images?api_key="+ MovieDBConstants.API_KEY)
    Call<ImageResponse> getMovieImages(@Path("id")int id);

}
