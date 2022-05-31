package com.example.myrproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Drink extends Fragment {

    public Drink() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private RecyclerView todo;
    private RecyclerView.LayoutManager LayoutManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_drink,container,false);

        todo = (RecyclerView) rootview.findViewById(R.id.drink_todo);
        todo.setHasFixedSize(true);

        LayoutManager = new GridLayoutManager(getActivity(), 5);
        todo.setLayoutManager(LayoutManager);

        String[] textSet = {"안녕","호오오오잇"};
        int[] imgSet = {R.drawable.beef, R.drawable.pork};

        //어댑터 연결하기
        Myadapter mAdapter = new Myadapter(imgSet, textSet);
        todo.setAdapter(mAdapter);
        return rootview;
    }


}