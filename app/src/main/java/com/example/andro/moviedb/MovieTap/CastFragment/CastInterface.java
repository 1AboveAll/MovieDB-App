package com.example.andro.moviedb.MovieTap.CastFragment;

import com.example.andro.moviedb.MovieDBConstants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by andro on 25-07-2017.
 */

public interface CastInterface {

    @GET("movie/{id}/credits?api_key="+MovieDBConstants.API_KEY)
    Call<CastResponse>getCredits(@Path("id")int id);


}
