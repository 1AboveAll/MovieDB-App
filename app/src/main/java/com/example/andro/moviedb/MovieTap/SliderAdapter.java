package com.example.andro.moviedb.MovieTap;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.andro.moviedb.MovieDBConstants;
import com.example.andro.moviedb.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by andro on 28-07-2017.
 */

public class SliderAdapter extends PagerAdapter {

    private List<MovieBackdrop>imageList;
    private LayoutInflater inflater;
    private Context context;

    public SliderAdapter(Context context,List<MovieBackdrop> imageList) {
        this.context = context;
        this.imageList = imageList;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }
    @Override
    public Object instantiateItem(ViewGroup view, int position){
        View v=inflater.inflate(R.layout.movie_tap_image_slider_layout,view,false);
        ImageView imageView=v.findViewById(R.id.movie_tap_image_slider_layout_image_view);
        Picasso.with(context).load(MovieDBConstants.SLIDER_BASE_URL+imageList.get(position).getFile_path())
                .into(imageView);
        view.addView(v,0);
        return v;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
