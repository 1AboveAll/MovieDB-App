package com.example.andro.moviedb;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andro on 20-07-2017.
 */

public class MoviesClient {

    public static final String BASE_URL="https://api.themoviedb.org/3/movie/";
    public static Retrofit retrofit = null;

    public static Retrofit getMoviesClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
