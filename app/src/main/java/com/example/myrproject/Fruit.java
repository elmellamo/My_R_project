package com.example.myrproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Fruit extends Fragment {

    public Fruit() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private RecyclerView fruit_todo;
    private RecyclerView.LayoutManager FruitLayoutManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_fruit,container,false);

        fruit_todo = (RecyclerView) rootview.findViewById(R.id.fruit_todo);
        fruit_todo.setHasFixedSize(true);

        FruitLayoutManager = new GridLayoutManager(getActivity(), 5);
        fruit_todo.setLayoutManager(FruitLayoutManager);

        String[] textSet = {"사과", "배"};
        int[] imgSet = {R.drawable.fruit, R.drawable.dairy};

        //어댑터 연결하기
        Myadapter mAdapter = new Myadapter(imgSet, textSet);
        fruit_todo.setAdapter(mAdapter);
        return rootview;
    }


}