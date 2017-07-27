package com.example.andro.moviedb.MovieTap.CastFragment;

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
 * Created by andro on 25-07-2017.
 */

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.CrewViewHolder> {

    public Context mContext;
    public List<Crew> mList;
    public CrewAdapter.CrewClickListener mListener;

    public CrewAdapter(Context context, List<Crew> list,CrewAdapter.CrewClickListener listener){
        mContext=context;
        mList=list;
        mListener=listener;
    }


    @Override
    public CrewAdapter.CrewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.single_item,parent,false);


        return new CrewAdapter.CrewViewHolder(itemView,mListener);
    }

    @Override
    public void onBindViewHolder(CrewAdapter.CrewViewHolder holder, int position) {

        Crew s = mList.get(position);
        if(s.getProfile_path()==null){
            Picasso.with(mContext).load(R.drawable.no_image).into(holder.singleImageView);
        }else {
            Picasso.with(mContext).load(MovieDBConstants.MOVIE_IMAGE_BASE_URL + s.getProfile_path()).into(holder.singleImageView);
        }
        holder.yearTextView.setText(s.getJob());
        holder.nameTextView.setText(s.getName());
        holder.yearTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        holder.nameTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        holder.nameTextView.setTextSize(18);
        holder.yearTextView.setTextSize(18);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface CrewClickListener{
        void onCrewClick(View v, int position);
    }

    public static class CrewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView singleImageView;
        TextView nameTextView;
        TextView yearTextView;
        CrewAdapter.CrewClickListener peopleClickListener;

        public CrewViewHolder(View itemView,CrewAdapter.CrewClickListener listener) {
            super(itemView);
            peopleClickListener=listener;
            singleImageView=itemView.findViewById(R.id.singleImageView);
            nameTextView=itemView.findViewById(R.id.nameTextView);
            yearTextView=itemView.findViewById(R.id.yearTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }










}
