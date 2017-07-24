package com.example.andro.moviedb.People;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.andro.moviedb.MovieDBClient;
import com.example.andro.moviedb.Movies.MoviesAdapter;
import com.example.andro.moviedb.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.andro.moviedb.R.id.nowShowing;

/**
 * Created by andro on 23-07-2017.
 */

public class PeopleFragment extends android.support.v4.app.Fragment {

    List<PeopleResults> trendingResultsList;
    PeopleAdapter trendingAdapter;
    RecyclerView trending;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.people_fragment, container, false);


        // Trending Recycler View
        trending = v.findViewById(R.id.trending);
        trendingResultsList = new ArrayList<>();
        trendingAdapter = new PeopleAdapter(getContext(), trendingResultsList, new PeopleAdapter.PeopleClickListener() {
            @Override
            public void onPeopleClick(View view, int position) {

            }
        }

        );
        trending.setAdapter(trendingAdapter);
        trending.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


        Retrofit retrofit = MovieDBClient.getClient();
        PeopleInterface peopleInterface=retrofit.create(PeopleInterface.class);

        Call<PeopleResponse> getTrending=peopleInterface.getTrending();
        getTrending.enqueue(new Callback<PeopleResponse>() {
            @Override
            public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
                PeopleResponse peopleResponse=response.body();
                List<PeopleResults>resultsList=peopleResponse.peopleResultsList;
                trendingResultsList.addAll(resultsList);
                trendingAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(),"People Loaded",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PeopleResponse> call, Throwable t) {
                //Toast.makeText(getContext(),"People Loaded",Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }

}


