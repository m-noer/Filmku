package com.example.mnoer.filmku;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<Item> mList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void OnIntemClick (int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;

    }

    public Adapter(Context context, ArrayList<Item> exampleList) {
        mContext = context;
        mList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.movie_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Item currentItem = mList.get(position);

        String imageUrl = currentItem.getmImageUrl();
        String creatorName = currentItem.getmTitle();
        String overview = currentItem.getmOverview();
        String release = currentItem.getmRelease();
        double rate = currentItem.getmRate();

        holder.mTVTitle.setText(creatorName);
        holder.mTVOverview.setText(overview);
        holder.mTVRelease.setText(release);
        holder.mTVRate.setText("Rating: " + rate);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTVTitle;
        public TextView mTVOverview;
        public TextView mTVRelease;
        public TextView mTVRate;
        public ExampleViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_view);
            mTVTitle = itemView.findViewById(R.id.tv_title);
            mTVOverview = itemView.findViewById(R.id.tv_overview);
            mTVRelease = itemView.findViewById(R.id.tv_release);
            mTVRate = itemView.findViewById(R.id.tv_rate);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (mListener !=null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.OnIntemClick(position);
                        }
                    }
                }
            });
        }
    }

}
