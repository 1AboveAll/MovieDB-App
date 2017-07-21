package com.example.andro.moviedb.TvShows;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andro on 21-07-2017.
 */

public class TvClient {

    public static final String BASE_URL="https://api.themoviedb.org/3/tv/";
    public static Retrofit tvretrofit = null;

    public static Retrofit getTvClient(){
        if(tvretrofit==null){
            tvretrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return tvretrofit;
    }


}
