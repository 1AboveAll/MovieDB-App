package com.example.andro.moviedb.PeopleTap;

/**
 * Created by andro on 02-08-2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andro.moviedb.MovieDBConstants;
import com.example.andro.moviedb.People.PeopleResults;
import com.example.andro.moviedb.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import android.content.Context;
import android.content.pm.LabeledIntent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
 * Created by andro on 23-07-2017.
 */

public class PeopleTapMoviesAdapter extends RecyclerView.Adapter<PeopleTapMoviesAdapter.PeopleTapViewHolder> {

    public Context mContext;
    public List<PeopleResults> mList;
    public PeopleTapClickListener mListener;

    public PeopleTapMoviesAdapter(Context context, List<PeopleResults> list, PeopleTapClickListener listener){
        mContext=context;
        mList=list;
        mListener=listener;
    }


    @Override
    public PeopleTapMoviesAdapter.PeopleTapViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.single_item,parent,false);


        return new PeopleTapMoviesAdapter.PeopleTapViewHolder(itemView,mListener);
    }

    @Override
    public void onBindViewHolder(PeopleTapMoviesAdapter.PeopleTapViewHolder holder, int position) {

        PeopleResults s = mList.get(position);

        Picasso.with(mContext).load(MovieDBConstants.MOVIE_IMAGE_BASE_URL+s.getProfile_path()).into(holder.singleImageView);
        holder.nameTextView.setText(s.getName());
        holder.nameTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        holder.nameTextView.setTextSize(25);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface PeopleTapClickListener{
        void onMovieClick(View v, int position);
    }

    public static class PeopleTapViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView singleImageView;
        TextView nameTextView;
        TextView yearTextView;
        PeopleTapClickListener peopleClickListener;

        public PeopleTapViewHolder(View itemView, PeopleTapClickListener listener) {
            super(itemView);
            peopleClickListener=listener;
            singleImageView=itemView.findViewById(R.id.singleImageView);
            nameTextView=itemView.findViewById(R.id.nameTextView);
            yearTextView=itemView.findViewById(R.id.yearTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            peopleClickListener.onMovieClick(view,getAdapterPosition());

        }
    }


}

