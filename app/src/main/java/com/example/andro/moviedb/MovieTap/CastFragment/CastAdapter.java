package com.example.andro.moviedb.MovieTap.CastFragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andro.moviedb.MovieDBConstants;
import com.example.andro.moviedb.People.PeopleAdapter;
import com.example.andro.moviedb.People.PeopleResults;
import com.example.andro.moviedb.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by andro on 25-07-2017.
 */

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    public Context mContext;
    public List<Cast> mList;
    public CastAdapter.CastClickListener mListener;

    public CastAdapter(Context context, List<Cast> list,CastAdapter.CastClickListener listener){
        mContext=context;
        mList=list;
        mListener=listener;
    }


    @Override
    public CastAdapter.CastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.single_item,parent,false);


        return new CastAdapter.CastViewHolder(itemView,mListener);
    }

    @Override
    public void onBindViewHolder(CastAdapter.CastViewHolder holder, int position) {

        Cast s = mList.get(position);
        Picasso.with(mContext).load(MovieDBConstants.MOVIE_IMAGE_BASE_URL+s.getProfile_path()).into(holder.singleImageView);
        holder.nameTextView.setText(s.getName()+"/"+s.getCharacter());
        holder.nameTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        holder.nameTextView.setTextSize(20);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface CastClickListener{
        void onCastClick(View v, int position);
    }

    public static class CastViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView singleImageView;
        TextView nameTextView;
        CastAdapter.CastClickListener peopleClickListener;

        public CastViewHolder(View itemView,CastAdapter.CastClickListener listener) {
            super(itemView);
            peopleClickListener=listener;
            singleImageView=itemView.findViewById(R.id.singleImageView);
            nameTextView=itemView.findViewById(R.id.nameTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }





}
