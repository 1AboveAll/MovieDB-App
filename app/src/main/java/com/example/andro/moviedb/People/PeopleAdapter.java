package com.example.andro.moviedb.People;

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

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder> {

    public Context mContext;
    public List<PeopleResults> mList;
    public PeopleClickListener mListener;

    public PeopleAdapter(Context context, List<PeopleResults> list,PeopleClickListener listener){
        mContext=context;
        mList=list;
        mListener=listener;
    }


    @Override
    public PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.single_item,parent,false);


        return new PeopleViewHolder(itemView,mListener);
    }

    @Override
    public void onBindViewHolder(PeopleViewHolder holder, int position) {

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

    public interface PeopleClickListener{
        void onPeopleClick(View v, int position);
    }

    public static class PeopleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView singleImageView;
        TextView nameTextView;
        PeopleClickListener peopleClickListener;

        public PeopleViewHolder(View itemView,PeopleClickListener listener) {
            super(itemView);
            peopleClickListener=listener;
            singleImageView=itemView.findViewById(R.id.singleImageView);
            nameTextView=itemView.findViewById(R.id.nameTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            peopleClickListener.onPeopleClick(view,getAdapterPosition());

        }
    }


}
