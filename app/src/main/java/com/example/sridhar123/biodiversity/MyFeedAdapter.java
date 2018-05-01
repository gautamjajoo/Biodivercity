package com.example.sridhar123.biodiversity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.zip.Inflater;

import butterknife.BindView;

public class MyFeedAdapter extends RecyclerView.Adapter<MyFeedAdapter.MyFeedViewHolder> {

    ArrayList<NewPost> a;
    Context c;

    public MyFeedAdapter(ArrayList<NewPost> a, Context c) {
        this.a = a;
        this.c = c;
    }

    @NonNull
    @Override
    public MyFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.feeditem, parent, false);
        MyFeedViewHolder myFeedViewHolder = new MyFeedViewHolder(v);
        return myFeedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyFeedViewHolder holder, int position) {
        final NewPost newPost = a.get(position);
        holder.location.setText(newPost.getLocation());
        holder.description.setText(newPost.getDescription());
        holder.species.setText(newPost.getSpecies());

        Glide.with(c).load(a.get(position).getImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return a.size();
    }

    public class MyFeedViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView location;
        public TextView species;
        public TextView description;

        public MyFeedViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            location = (TextView) itemView.findViewById(R.id.location);
            description = (TextView) itemView.findViewById(R.id.description);
            species = (TextView) itemView.findViewById(R.id.species);
        }
    }
}
