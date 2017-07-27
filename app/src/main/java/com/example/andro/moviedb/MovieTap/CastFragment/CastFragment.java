package com.example.andro.moviedb.MovieTap.CastFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andro.moviedb.MovieDBClient;
import com.example.andro.moviedb.Movies.MovieResults;
import com.example.andro.moviedb.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by andro on 25-07-2017.
 */

public class CastFragment extends Fragment {


    List<Cast> castList;
    RecyclerView moviesCastCastRecyclerView;
    CastAdapter castAdapter;

    List<Crew> crewList;
    RecyclerView moviesCastCrewRecyclerView;
    CrewAdapter crewAdapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View v=inflater.inflate(R.layout.movies_cast_frament,container,false);
        MovieResults movieResults = (MovieResults)this.getArguments().getSerializable("MovieResults");
        Log.i("Movie_ID",movieResults.getId()+"");
        castList=new ArrayList<>();
        moviesCastCastRecyclerView=v.findViewById(R.id.movie_cast_cast_recycler_view);
        castAdapter=new CastAdapter(getContext(), castList, new CastAdapter.CastClickListener() {
            @Override
            public void onCastClick(View v, int position) {

            }
        });
        moviesCastCastRecyclerView.setAdapter(castAdapter);
        moviesCastCastRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));


        crewList=new ArrayList<>();
        moviesCastCrewRecyclerView=v.findViewById(R.id.movie_cast_crew_recycler_view);
        crewAdapter=new CrewAdapter(getContext(), crewList, new CrewAdapter.CrewClickListener() {
            @Override
            public void onCrewClick(View v, int position) {

            }
        });
        moviesCastCrewRecyclerView.setAdapter(crewAdapter);
        moviesCastCrewRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));



        Retrofit retrofit= MovieDBClient.getClient();
        final CastInterface castInterface = retrofit.create(CastInterface.class);


        Call<CastResponse>castResponse=castInterface.getCredits(movieResults.getId());
        castResponse.enqueue(new Callback<CastResponse>() {
            @Override
            public void onResponse(Call<CastResponse> call, Response<CastResponse> response) {
                CastResponse castR =response.body();
                List<Cast> cList=castR.getCast;
                castList.addAll(cList);
                castAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CastResponse> call, Throwable t) {

            }
        });

        Call<CastResponse>crewResponse=castInterface.getCredits(movieResults.getId());
        crewResponse.enqueue(new Callback<CastResponse>() {
            @Override
            public void onResponse(Call<CastResponse> call, Response<CastResponse> response) {
                CastResponse crewR=response.body();
                List<Crew> crList=crewR.getCrew;
                crewList.addAll(crList);
                crewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CastResponse> call, Throwable t) {

            }
        });





        return v;
    }





}
