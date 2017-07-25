package com.example.andro.moviedb.MovieTap.CastFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andro.moviedb.MovieDBClient;
import com.example.andro.moviedb.R;

import java.util.ArrayList;
import java.util.List;

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

        castList=new ArrayList<>();
        moviesCastCastRecyclerView=v.findViewById(R.id.movie_cast_cast_recycler_view);
        castAdapter=new CastAdapter(getContext(), castList, new CastAdapter.CastClickListener() {
            @Override
            public void onCastClick(View v, int position) {

            }
        });
        moviesCastCastRecyclerView.setAdapter(castAdapter);
        moviesCastCastRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));


        Retrofit retrofit= MovieDBClient.getClient();








        return v;
    }





}
