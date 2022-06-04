package com.example.myrproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Vegetable extends Fragment {

    public Vegetable() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private RecyclerView todo;
    private RecyclerView.LayoutManager FruitLayoutManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_vegetable,container,false);

        todo = (RecyclerView) rootview.findViewById(R.id.vegetable_todo);
        todo.setHasFixedSize(true);

        FruitLayoutManager = new GridLayoutManager(getActivity(), 5);
        todo.setLayoutManager(FruitLayoutManager);

        String[] textSet = {"상추", "깻잎","시금치","오이","호박","가지","옥수수","감자","고구마","당근","연근","양파","마늘","생강","파","버섯","양배추","브로콜리","허브","파프리카","고추","배추","무","콩나물"};
        int[] imgSet = {R.drawable.lettuce, R.drawable.perilla, R.drawable.spinach, R.drawable.cucumber, R.drawable.pumpkin, R.drawable.aubergine, R.drawable.corn, R.drawable.potato, R.drawable.sweetpotato, R.drawable.carrot, R.drawable.lotusroot, R.drawable.onion, R.drawable.garlic, R.drawable.ginger, R.drawable.springonion, R.drawable.mushroom, R.drawable.cabbage, R.drawable.broccoli, R.drawable.herbs, R.drawable.paprika, R.drawable.chillipepper, R.drawable.chinesecabbage, R.drawable.radish, R.drawable.sprouts};

        //어댑터 연결하기
        Myadapter mAdapter = new Myadapter(imgSet, textSet,getActivity().getApplicationContext());
        todo.setAdapter(mAdapter);
        return rootview;
    }}


