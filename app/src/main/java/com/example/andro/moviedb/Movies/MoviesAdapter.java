package com.example.andro.moviedb.Movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andro.moviedb.MovieDBConstants;
import com.example.andro.moviedb.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by andro on 20-07-2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    public Context mContext;
    public List<MovieResults> mList;
    public MoviesClickListener mListener;


    public interface MoviesClickListener {
        void onMovieClick(View view,int position);
    }

    public MoviesAdapter(Context context, List<MovieResults> list,MoviesClickListener listener){
        mContext=context;
        mList=list;
        mListener=listener;
    }


    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.image_item,parent,false);

        return new MoviesViewHolder(itemView,mListener);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
            MovieResults s = mList.get(position);
            Picasso.with(mContext).load(MovieDBConstants.MOVIE_IMAGE_BASE_URL+s.getPoster_path()).into(holder.contentImageView);
            holder.contentTextView.setText(s.getTitle());
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }


    public static class MoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView contentImageView;
    TextView contentTextView;
    MoviesClickListener moviesClickListener;

    public MoviesViewHolder(View itemView,MoviesClickListener listener) {
        super(itemView);
        moviesClickListener=listener;
        contentImageView=itemView.findViewById(R.id.contentImageView);
        contentTextView=itemView.findViewById(R.id.contentTextView);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}


}
