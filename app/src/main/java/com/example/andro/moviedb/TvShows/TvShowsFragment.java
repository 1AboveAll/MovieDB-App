package com.example.andro.moviedb.TvShows;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andro.moviedb.Movies.MovieResponse;
import com.example.andro.moviedb.Movies.MovieResults;
import com.example.andro.moviedb.Movies.MoviesAdapter;
import com.example.andro.moviedb.Movies.MoviesClient;
import com.example.andro.moviedb.Movies.MoviesInterface;
import com.example.andro.moviedb.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by andro on 21-07-2017.
 */

public class TvShowsFragment extends Fragment {

    List<TvResults> onTheAirResultsList;
    TvAdapter onTheAirAdapter;
    RecyclerView onTheAir;

    List<TvResults> popularTvResultsList;
    RecyclerView popularTv;
    TvAdapter popularTvAdapter;

    List<TvResults> topRatedTvResultsList;
    RecyclerView topRatedTv;
    TvAdapter topRatedTvAdapter;


    List<TvResults> airingTodayResultsList;
    RecyclerView airingToday;
    TvAdapter airingTodayAdapter;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tvshows_fragment,container,false);


        // On The Air Recycler View
        onTheAir=v.findViewById(R.id.onTheAir);
        onTheAirResultsList=new ArrayList<>();
       onTheAirAdapter =new TvAdapter(getContext(), onTheAirResultsList, new TvAdapter.TvClickListener() {
           @Override
           public void onTvClick(View v, int position) {

           }
       });
        onTheAir.setAdapter(onTheAirAdapter);
        onTheAir.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        //nowShowing.setLayoutManager(new GridLayoutManager(getContext(),1,GridLayoutManager.HORIZONTAL,false));




//        // Popular Recycler View
        popularTv=v.findViewById(R.id.popularTv);
        popularTvResultsList=new ArrayList<>();
        popularTvAdapter= new TvAdapter(getContext(), popularTvResultsList, new TvAdapter.TvClickListener() {
            @Override
            public void onTvClick(View v, int position) {

            }
        });
        popularTv.setAdapter(popularTvAdapter);
        popularTv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

//        // Top Rated Recycler View
        topRatedTv=v.findViewById(R.id.topRatedTv);
        topRatedTvResultsList=new ArrayList<>();
        topRatedTvAdapter= new TvAdapter(getContext(), topRatedTvResultsList, new TvAdapter.TvClickListener() {
            @Override
            public void onTvClick(View v, int position) {

            }
        });
        topRatedTv.setAdapter(topRatedTvAdapter);
        topRatedTv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));


        airingToday=v.findViewById(R.id.airingToday);
        airingTodayResultsList=new ArrayList<>();
        airingTodayAdapter= new TvAdapter(getContext(), airingTodayResultsList, new TvAdapter.TvClickListener() {
            @Override
            public void onTvClick(View v, int position) {

            }
        });
        airingToday.setAdapter(airingTodayAdapter);
        airingToday.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));


//
        Retrofit tvretrofit = TvClient.getTvClient();
        TvInterface tvInterface =tvretrofit.create(TvInterface.class);
//


        //OnTheAir
        Call<TvResponse> onTheAir =tvInterface.onTheAir();
        onTheAir.enqueue(new Callback<TvResponse>() {
            @Override
            public void onResponse(Call<TvResponse> call, Response<TvResponse> response) {
                TvResponse tvResponse=response.body();
                List<TvResults>tvResults=tvResponse.tvresults;
                onTheAirResultsList.addAll(tvResults);
                onTheAirAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<TvResponse> call, Throwable t) {

            }
        });

//
//        //Coming Soon
        Call<TvResponse> popular =tvInterface.popular();
        popular.enqueue(new Callback<TvResponse>() {
            @Override
            public void onResponse(Call<TvResponse> call, Response<TvResponse> response) {
                TvResponse tvResponse=response.body();
                List<TvResults>tvResults=tvResponse.tvresults;
                popularTvResultsList.addAll(tvResults);
                popularTvAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TvResponse> call, Throwable t) {

            }
        });
//
//
//        //Top Rated
        Call<TvResponse> topRated =tvInterface.topRated();
        topRated.enqueue(new Callback<TvResponse>() {
            @Override
            public void onResponse(Call<TvResponse> call, Response<TvResponse> response) {
                TvResponse tvResponse=response.body();
                List<TvResults>tvResults=tvResponse.tvresults;
                topRatedTvResultsList.addAll(tvResults);
                topRatedTvAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TvResponse> call, Throwable t) {

            }
        });
//
//        //Most Popular Movies
           Call<TvResponse> airingToday =tvInterface.airingToday();
        airingToday.enqueue(new Callback<TvResponse>() {
            @Override
            public void onResponse(Call<TvResponse> call, Response<TvResponse> response) {
                TvResponse tvResponse=response.body();
                List<TvResults>tvResults=tvResponse.tvresults;
                airingTodayResultsList.addAll(tvResults);
                airingTodayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TvResponse> call, Throwable t) {

            }
        });




        return v;
    }



}
