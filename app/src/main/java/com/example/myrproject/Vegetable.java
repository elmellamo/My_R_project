package com.example.myrproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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

    private RecyclerView vegetable_todo;
    private RecyclerView.LayoutManager FruitLayoutManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_vegetable,container,false);

        vegetable_todo = (RecyclerView) rootview.findViewById(R.id.fruit_todo);
        vegetable_todo.setHasFixedSize(true);

        FruitLayoutManager = new LinearLayoutManager(getActivity());
        vegetable_todo.setLayoutManager(FruitLayoutManager);

        String[] textSet = {"배", "사과"};
        int[] imgSet = {R.drawable.fruit, R.drawable.dairy};

        //어댑터 연결하기
        Myadapter mAdapter = new Myadapter(imgSet, textSet);
        vegetable_todo.setAdapter(mAdapter);
        return rootview;
    }


}