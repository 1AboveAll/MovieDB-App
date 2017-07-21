package com.example.andro.moviedb.Movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andro.moviedb.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by andro on 19-07-2017.
 */

public class MoviesFragment extends android.support.v4.app.Fragment {

    List<MovieResults> nowShowingResultsList;
    MoviesAdapter nowShowingAdapter;
    RecyclerView nowShowing;

    List<MovieResults> comingSoonResultsList;
    RecyclerView comingSoon;
    MoviesAdapter comingSoonAdapter;

    List<MovieResults>topRatedResultsList;
    RecyclerView topRated;
    MoviesAdapter topRatedMoviesAdapter;


    List<MovieResults> popularMoviesResultsList;
    RecyclerView popularMovies;
    MoviesAdapter popularMoviesAdapter;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.movies_fragment,container,false);


        // Now Showing Recycler View
        nowShowing=v.findViewById(R.id.nowShowing);
        nowShowingResultsList=new ArrayList<>();
        nowShowingAdapter= new MoviesAdapter(getContext(),nowShowingResultsList, new MoviesAdapter.MoviesClickListener() {
            @Override
            public void onMovieClick(View view, int position) {
                //Now Showing Clicks Handled Here
            }
        });
        nowShowing.setAdapter(nowShowingAdapter);
        nowShowing.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        //nowShowing.setLayoutManager(new GridLayoutManager(getContext(),1,GridLayoutManager.HORIZONTAL,false));




        // Now Showing Recycler View
        comingSoon=v.findViewById(R.id.comingSoon);
        comingSoonResultsList=new ArrayList<>();
        comingSoonAdapter= new MoviesAdapter(getContext(), comingSoonResultsList, new MoviesAdapter.MoviesClickListener() {
            @Override
            public void onMovieClick(View view, int position) {
                //Coming Soon Clicks Handled Here

            }
        });
        comingSoon.setAdapter(comingSoonAdapter);
        comingSoon.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        // Top Rated Recycler View
        topRated=v.findViewById(R.id.topRated);
        topRatedResultsList=new ArrayList<>();
        topRatedMoviesAdapter= new MoviesAdapter(getContext(), topRatedResultsList, new MoviesAdapter.MoviesClickListener() {
            @Override
            public void onMovieClick(View view, int position) {
                // Top Rated Clicks Handled Here
            }
        });
        topRated.setAdapter(topRatedMoviesAdapter);
        topRated.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));


        popularMovies=v.findViewById(R.id.popularMovies);
        popularMoviesResultsList=new ArrayList<>();
        popularMoviesAdapter =new MoviesAdapter(getContext(), popularMoviesResultsList, new MoviesAdapter.MoviesClickListener() {
            @Override
            public void onMovieClick(View view, int position) {

            }
        });
        popularMovies.setAdapter(popularMoviesAdapter);
        popularMovies.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));



                Retrofit retrofit = MoviesClient.getMoviesClient();
        MoviesInterface moviesInterface =retrofit.create(MoviesInterface.class);



        //Now Showing
        Call<MovieResponse> getPlaying =moviesInterface.getPlaying();
        getPlaying.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse=response.body();
                List<MovieResults>movieResults=movieResponse.results;
                nowShowingResultsList.addAll(movieResults);

                nowShowingAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });


        //Coming Soon
        Call<MovieResponse> getUpcoming=moviesInterface.getUpcoming();
        getUpcoming.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse=response.body();
                List<MovieResults>movieResults=movieResponse.results;
                comingSoonResultsList.addAll(movieResults);
                comingSoonAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });


        //Top Rated
        final Call<MovieResponse> topRated=moviesInterface.topRated();
        topRated.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse=response.body();
                List<MovieResults>movieResults=movieResponse.results;
                topRatedResultsList.addAll(movieResults);
                topRatedMoviesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });


        //Most Popular Movies
        Call<MovieResponse> getPopular=moviesInterface.getPopular();
        getPopular.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse=response.body();
                List<MovieResults>movieResults=movieResponse.results;
                popularMoviesResultsList.addAll(movieResults);
                popularMoviesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });




        return v;
    }
}
