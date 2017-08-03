package com.example.andro.moviedb.MovieTap.InfoFragment;



import com.example.andro.moviedb.MovieDBConstants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by andro on 29-07-2017.
 */

public interface MovieDetailsInterface {

    @GET("movie/{id}?api_key="+ MovieDBConstants.API_KEY+"&language=en-US")
    Call<MovieDetails>getMovieDetails(@Path("id")int id);
}
