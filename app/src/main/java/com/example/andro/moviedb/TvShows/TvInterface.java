package com.example.andro.moviedb.TvShows;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by andro on 21-07-2017.
 */

public interface TvInterface {

    @GET("on_the_air?api_key=ff84ecf0eb88cbd7e16b4300ac4133df&language=en-US")
    Call<TvResponse> onTheAir();

}
