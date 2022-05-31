package com.example.myrproject;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder>{

    private String[] textSet;
    private int[] imgSet;

    public Myadapter(int[] imgSet, String[] textSet){
        this.imgSet = imgSet;
        this.textSet = textSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())

                .inflate(R.layout.fruit_item_list, parent, false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.mTitle.setText(this.textSet[i]);
        holder.mImage.setBackgroundResource(this.imgSet[i]);
    }

    @Override
    public int getItemCount() {
        return textSet.length > imgSet.length ? textSet.length : imgSet.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImage;
        public final TextView mTitle;

        public MyViewHolder(View view) {
            super(view);
            this.mImage = (ImageView) view.findViewById(R.id.tv_image);
            this.mTitle = (TextView) view.findViewById(R.id.tv_title);
        }

    }

}
