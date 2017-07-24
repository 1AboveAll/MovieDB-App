package com.example.andro.moviedb.People;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andro on 23-07-2017.
 */

public class PeopleClient {


    public static final String BASE_URL="https://api.themoviedb.org/3/person/";
    public static Retrofit retrofit = null;

    public static Retrofit getPeopleClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
