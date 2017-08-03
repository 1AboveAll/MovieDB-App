package com.example.andro.moviedb.PeopleTap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andro.moviedb.MovieDBClient;
import com.example.andro.moviedb.MovieTap.MovieBackdrop;
import com.example.andro.moviedb.MovieTap.SliderAdapter;
import com.example.andro.moviedb.People.PeopleResults;
import com.example.andro.moviedb.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by andro on 02-08-2017.
 */

public class PeopleTapInfoFragment extends Fragment {


    TextView biography;
    TextView dob;
    TextView pob;
    TextView gender;
    //Slider
    List<MovieBackdrop> peopleImages;
    SliderAdapter sliderAdapter;
    ViewPager peopleSlider;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.people_tap_info_fragment,container,false);
        PeopleResults peopleResults=(PeopleResults)this.getArguments().getSerializable("People");
        biography=v.findViewById(R.id.people_tap_movies_biography);
        dob=v.findViewById(R.id.people_tap_movies_dob);
        pob=v.findViewById(R.id.people_tap_movies_pob);
        gender=v.findViewById(R.id.people_tap_movies_gender);

        peopleImages=new ArrayList<>();
        sliderAdapter=new SliderAdapter(getContext(),peopleImages);
        peopleSlider=(ViewPager)v.findViewById(R.id.people_slider_view_pager);
        peopleSlider.setAdapter(sliderAdapter);


        Retrofit retrofit = MovieDBClient.getClient();
        final PeopleTapInterface peopleTapInterface=retrofit.create(PeopleTapInterface.class);

        Call<PeopleTapResponse> peopleTapResponseCall=peopleTapInterface.getPeopleTapResponse(peopleResults.getId());
        peopleTapResponseCall.enqueue(new Callback<PeopleTapResponse>() {
            @Override
            public void onResponse(Call<PeopleTapResponse> call, Response<PeopleTapResponse> response) {
                PeopleTapResponse peopleTapResponse=response.body();
                peopleImages.addAll(peopleTapResponse.images.getProfiles());
                sliderAdapter.notifyDataSetChanged();
                biography.setText(peopleTapResponse.getBiography());
                pob.setText(peopleTapResponse.getPob());
                if(peopleTapResponse.getGender()==1){
                    gender.setText("Female");
                }else
                if(peopleTapResponse.getGender()==2){
                    gender.setText("Male");
                }
                else
                    gender.setText("N/A");
                String arr[]=peopleTapResponse.getBirthday().split("-");
                dob.setText(arr[2]+"-"+arr[1]+"-"+arr[0]);



            }

            @Override
            public void onFailure(Call<PeopleTapResponse> call, Throwable t) {

            }
        });

        return v;

    }
}
