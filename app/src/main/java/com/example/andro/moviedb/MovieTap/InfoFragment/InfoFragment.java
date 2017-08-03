package com.example.andro.moviedb.MovieTap.InfoFragment;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andro.moviedb.MovieDBClient;
import com.example.andro.moviedb.MovieTap.MovieTap;
import com.example.andro.moviedb.Movies.MovieResponse;
import com.example.andro.moviedb.Movies.MovieResults;
import com.example.andro.moviedb.Movies.MoviesAdapter;
import com.example.andro.moviedb.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by andro on 26-07-2017.
 */

public class InfoFragment extends Fragment {


    TextView movieInfoOverview;
    TextView movieInfoReleaseDate;
    TextView movieInfoBudget;
    TextView movieInfoRevenue;


    RecyclerView similarMovies;
    MoviesAdapter similarMoviesAdapter;
    List<MovieResults> similarMoviesResults;


    RecyclerView recommendedMovies;
    MoviesAdapter recommendedMoviesAdapter;
    List<MovieResults>recommendedMoviesResults;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.movie_info_fragment,container,false);
        MovieResults movieResults=(MovieResults)this.getArguments().getSerializable("MovieResults");
        //Setting Overview
        movieInfoOverview=v.findViewById(R.id.movie_info_overview);
        movieInfoOverview.setText(movieResults.getOverview());
        //Setting Release Data
        movieInfoReleaseDate=v.findViewById(R.id.movie_info_release_date);
        String tempDate=movieResults.getRelease_date();
        String tempArr[]=tempDate.split("-");
        String Date=tempArr[2]+"-"+tempArr[1]+"-"+tempArr[0];
        movieInfoReleaseDate.setText(Date);

        //Setting Budget & Revenue
        movieInfoBudget=v.findViewById(R.id.movie_info_budget);
        movieInfoRevenue=v.findViewById(R.id.movie_info_revenue);

        similarMovies=v.findViewById(R.id.movie_info_similar_recycler_view);
        similarMoviesResults=new ArrayList<>();
        similarMoviesAdapter=new MoviesAdapter(getContext(), similarMoviesResults, new MoviesAdapter.MoviesClickListener() {
            @Override
            public void onMovieClick(View view, int position) {
                MovieResults movieResults=similarMoviesResults.get(position);
                Intent i=new Intent(getContext(), MovieTap.class);
                i.putExtra("Movie",movieResults);
                startActivity(i);

            }
        });
        similarMovies.setAdapter(similarMoviesAdapter);
        similarMovies.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));


        recommendedMovies=v.findViewById(R.id.movie_info_recommendations_recycler_view);
        recommendedMoviesResults=new ArrayList<>();
        recommendedMoviesAdapter=new MoviesAdapter(getContext(), recommendedMoviesResults, new MoviesAdapter.MoviesClickListener() {
            @Override
            public void onMovieClick(View view, int position) {
                MovieResults movieResults=recommendedMoviesResults.get(position);
                Intent i=new Intent(getContext(), MovieTap.class);
                i.putExtra("Movie",movieResults);
                startActivity(i);
            }
        });

        recommendedMovies.setAdapter(recommendedMoviesAdapter);
        recommendedMovies.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        Retrofit retrofit= MovieDBClient.getClient();
        InfoInterface infoInterface =retrofit.create(InfoInterface.class);


        Call<MovieResponse> similarMovies = infoInterface.similarMovies(movieResults.getId());
        similarMovies.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                MovieResponse movieResponse=response.body();
                List<MovieResults>movieResult=movieResponse.results;
                similarMoviesResults.addAll(movieResult);
                similarMoviesAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

        Call<MovieResponse> recommended = infoInterface.recommendedMovies(movieResults.getId());
        recommended.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                MovieResponse movieResponse=response.body();
                List<MovieResults>movieResult=movieResponse.results;
                recommendedMoviesResults.addAll(movieResult);
                recommendedMoviesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
        Retrofit retrofit_2= MovieDBClient.getClient();
        MovieDetailsInterface movieDetailsInterface =retrofit_2.create(MovieDetailsInterface.class);


        Call<MovieDetails> movieDetailsCall= movieDetailsInterface.getMovieDetails(movieResults.getId());
        movieDetailsCall.enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                MovieDetails movieDetails=response.body();
                if(movieDetails.getBudget()!=0) {
                    movieInfoBudget.setText("$" + movieDetails.getBudget());
                }
                else
                    movieInfoBudget.setText("N/A");
                if(movieDetails.getRevenue()!=0){
                    movieInfoRevenue.setText("$"+movieDetails.getRevenue());
                }
                else
                    movieInfoRevenue.setText("N/A");

            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {

            }


        });

        return v;
    }


}
