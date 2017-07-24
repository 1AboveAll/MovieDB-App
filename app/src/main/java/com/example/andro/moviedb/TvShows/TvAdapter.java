package com.example.andro.moviedb.TvShows;

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
 * Created by andro on 21-07-2017.
 */

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvShowsViewHolder> {

    public Context mContext;
    public List<TvResults> mList;
    public TvClickListener mListener;

    public TvAdapter(Context context, List<TvResults> list,TvClickListener listener){
        mContext=context;
        mList=list;
        mListener=listener;
    }


    @Override
    public TvShowsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.image_item,parent,false);


        return new TvShowsViewHolder(itemView,mListener);
    }

    @Override
    public void onBindViewHolder(TvShowsViewHolder holder, int position) {

        TvResults s = mList.get(position);
        Picasso.with(mContext).load(MovieDBConstants.MOVIE_IMAGE_BASE_URL+s.getPoster_path()).into(holder.contentImageView);
        holder.contentTextView.setText(s.getName());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface TvClickListener{
        void onTvClick(View v, int position);
    }

    public static class TvShowsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView contentImageView;
        TextView contentTextView;
        TvClickListener tvClickListener;

        public TvShowsViewHolder(View itemView,TvClickListener listener) {
            super(itemView);
            tvClickListener=listener;
            contentImageView=itemView.findViewById(R.id.contentImageView);
            contentTextView=itemView.findViewById(R.id.contentTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }


}
