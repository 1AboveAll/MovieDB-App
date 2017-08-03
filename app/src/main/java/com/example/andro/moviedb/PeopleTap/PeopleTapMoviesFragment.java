package com.example.andro.moviedb.PeopleTap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andro.moviedb.MovieDBClient;
import com.example.andro.moviedb.People.PeopleInterface;
import com.example.andro.moviedb.People.PeopleResults;
import com.example.andro.moviedb.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by andro on 31-07-2017.
 */

public class PeopleTapMoviesFragment extends Fragment {


    RecyclerView peopleTapMovies;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.people_tap_movies_fragment,container,false);
        PeopleResults peopleResults=(PeopleResults)this.getArguments().getSerializable("People");



        return v;
    }
}
