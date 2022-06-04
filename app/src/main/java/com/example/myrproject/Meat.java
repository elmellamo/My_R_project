package com.example.myrproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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

        String[] textSet = {"소고기", "돼지고기","닭고기","오리고기","양고기","햄","소시지","베이컨","계란"};
        int[] imgSet = {R.drawable.beef, R.drawable.pork,R.drawable.chicken,R.drawable.duck,R.drawable.mutton,R.drawable.ham,R.drawable.sausage,R.drawable.bacon,R.drawable.friedegg};

        //어댑터 연결하기
        Myadapter mAdapter = new Myadapter(imgSet, textSet,getActivity().getApplicationContext());
        todo.setAdapter(mAdapter);
        return rootview;
    }


}