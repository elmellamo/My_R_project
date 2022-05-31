package com.example.myrproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Meat extends Fragment {

    public Meat() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private RecyclerView meat_todo;
    private RecyclerView.LayoutManager FruitLayoutManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_meat,container,false);

        meat_todo = (RecyclerView) rootview.findViewById(R.id.meat_todo);
        meat_todo.setHasFixedSize(true);

        FruitLayoutManager = new LinearLayoutManager(getActivity());
        meat_todo.setLayoutManager(FruitLayoutManager);

        String[] textSet = {"안녕", "호잇"};
        int[] imgSet = {R.drawable.fruit, R.drawable.dairy};

        //어댑터 연결하기
        Myadapter mAdapter = new Myadapter(imgSet, textSet);
        meat_todo.setAdapter(mAdapter);
        return rootview;
    }


}