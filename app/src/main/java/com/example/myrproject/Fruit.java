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

    private RecyclerView todo;
    private RecyclerView.LayoutManager LayoutManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_fruit,container,false);

        todo = (RecyclerView) rootview.findViewById(R.id.fruit_todo);
        todo.setHasFixedSize(true);

        LayoutManager = new GridLayoutManager(getActivity(), 5);
        todo.setLayoutManager(LayoutManager);

        String[] textSet = {"사과", "배","귤","감","키위","토마토","자두","복숭아","포도"
                ,"오디","라즈베리","딸기","블루베리","수박","체리","바나나","파인애플","오렌지","자몽"
                ,"레몬","라임","깔라만시","망고","망고스틴","용과","패션후르츠","참외","석류"
                ,"코코넛","두리안","아보카도","땅콩"
                ,"호두","캐슈넛"};
        int[] imgSet = {R.drawable.apple, R.drawable.pear,R.drawable.tangerine,R.drawable.persimmon
                ,R.drawable.kiwi,R.drawable.tomato,R.drawable.plum,R.drawable.peach,R.drawable.grape
                ,R.drawable.mulberry,R.drawable.rasberry,R.drawable.strawberry,R.drawable.blueberries
                ,R.drawable.watermelon
                ,R.drawable.cherry,R.drawable.banana,R.drawable.pineapple,R.drawable.mandarin
                ,R.drawable.grapefruit,R.drawable.lemon,R.drawable.lime,R.drawable.calamansi
                ,R.drawable.mango,R.drawable.mangosteen,R.drawable.dragonfruit,R.drawable.passionfruit
                ,R.drawable.koreanmelon,R.drawable.pomegranate,R.drawable.coconut,R.drawable.durian
                ,R.drawable.avocado,R.drawable.peanut,R.drawable.walnut
                ,R.drawable.cashewnut};

        //어댑터 연결하기
        Myadapter mAdapter = new Myadapter(imgSet, textSet, getActivity().getApplicationContext());
        todo.setAdapter(mAdapter);
        return rootview;
    }
}