package com.example.myrproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Dairy extends Fragment {

    public Dairy() {
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

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_meat,container,false);

        todo = (RecyclerView) rootview.findViewById(R.id.meat_todo);
        todo.setHasFixedSize(true);

        LayoutManager = new GridLayoutManager(getActivity(), 5);
        todo.setLayoutManager(LayoutManager);

        String[] textSet = {"우유","요거트","치즈","버터","휘핑크림"};
        int[] imgSet = {R.drawable.milk, R.drawable.yogurt,R.drawable.cheese,R.drawable.butter,R.drawable.whippingcream};

        //어댑터 연결하기
        Myadapter mAdapter = new Myadapter(imgSet, textSet);
        todo.setAdapter(mAdapter);
        return rootview;
    }


}