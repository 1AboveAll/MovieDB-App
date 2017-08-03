package com.example.andro.moviedb.MovieTap;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.andro.moviedb.MovieDBClient;
import com.example.andro.moviedb.MovieTap.CastFragment.CastFragment;
import com.example.andro.moviedb.MovieTap.InfoFragment.InfoFragment;
import com.example.andro.moviedb.Movies.MovieResults;
import com.example.andro.moviedb.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieTap extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    TabLayout mTabLayout;
    MovieResults movieResults;

    CastFragment castFragment;
    InfoFragment infoFragment;


    //Slider
    List<MovieBackdrop> movieImages;
    SliderAdapter sliderAdapter;
    ViewPager movieSlider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_tap);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        Intent i=getIntent();
        movieResults=(MovieResults)i.getSerializableExtra("Movie");
        toolbar.setTitle(movieResults.getTitle());
        //Sending MovieResults Object to the Fragment
        Bundle bundle=new Bundle();
        //bundle.putSerializable("Movie",movieResults);
        castFragment=new CastFragment();
        bundle.putSerializable("MovieResults",movieResults);
        castFragment.setArguments(bundle);

        infoFragment=new InfoFragment();
        infoFragment.setArguments(bundle);

        setSupportActionBar(toolbar);

        //Slider
        movieImages=new ArrayList<>();
        movieSlider=(ViewPager)findViewById(R.id.movie_slider_view_pager);
        sliderAdapter=new SliderAdapter(this,movieImages);
        movieSlider.setAdapter(sliderAdapter);



        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setOffscreenPageLimit(3);
        mTabLayout=(TabLayout)findViewById(R.id.movie_tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        //Retrofit Instance
        Retrofit retrofit = MovieDBClient.getClient();
        MovieImageInterface movieImageInterface=retrofit.create(MovieImageInterface.class);


        final Call<ImageResponse> movieImage=movieImageInterface.getMovieImages(movieResults.getId());
        movieImage.enqueue(new Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                ImageResponse imageResponse=response.body();
                List<MovieBackdrop> backdropList= imageResponse.backdropList;
               // List<MovieBackdrop> posterList =imageResponse.posterList;
//                if(posterList.size()>0) {
//                    movieImages.add(posterList.get(0));
//                }
                if(backdropList.size()>6){
                    movieImages.addAll(backdropList.subList(0,6));
                }
                else if(backdropList.size()!=0){
                    movieImages.addAll(backdropList);
                }
                sliderAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ImageResponse> call, Throwable t) {

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_tap, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_movie_tap, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0){

                return infoFragment;
            }

            if(position==1){
                //CastFragment castFragment=new CastFragment();
//                Bundle bundle=new Bundle();
//                bundle.putSerializable("MovieResults",movieResults);
//                castFragment.setArguments(bundle);

                return castFragment;
            }


            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Details";
                case 1:
                    return "Cast";
            }
            return null;
        }
    }
}
