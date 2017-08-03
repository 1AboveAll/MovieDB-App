package com.example.andro.moviedb.PeopleTap;

import com.example.andro.moviedb.MovieDBConstants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by andro on 31-07-2017.
 */

public interface PeopleTapInterface {

    @GET("person/{id}?api_key="+ MovieDBConstants.API_KEY+"&language=en-US&append_to_response=images")
    Call<PeopleTapResponse> getPeopleTapResponse(@Path("id")int id);
}
