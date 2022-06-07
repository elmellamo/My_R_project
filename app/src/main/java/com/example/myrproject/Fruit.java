package com.example.myrproject;

import android.content.Context;
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
import android.widget.Toast;

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

        String[] textSet = {"사과", "배","귤","감","키위","토마토","방울토마토","나무토마토","자두"
                ,"살구","복숭아","포도"
                ,"오디","라즈베리","딸기","블루베리","크랜베리","아사이베리","엘더베리","커런트","구스베리"
                ,"대추야자","체리","아세롤라","수박","바나나"
                ,"파인애플","오렌지","무화과"
                ,"로즈애플","자몽"
                ,"레몬","라임","깔라만시","모과","망고","망고스틴","용과","패션후르츠","참외","석류"
                ,"코코넛","파파야","두리안","구아바","타마린드","아보카도","람부탄","스타애플","과라나","올리브","땅콩"
                ,"호두","캐슈넛"};
        int[] imgSet = {R.drawable.apple, R.drawable.pear,R.drawable.tangerine,R.drawable.persimmon
                ,R.drawable.kiwi,R.drawable.tomato,R.drawable.cherrytomato,R.drawable.treetomato
                ,R.drawable.plum,R.drawable.apricot,R.drawable.peach
                ,R.drawable.grape
                ,R.drawable.mulberry,R.drawable.rasberry,R.drawable.strawberry,R.drawable.blueberries
                ,R.drawable.cranberry,R.drawable.acaiberry,R.drawable.elderberry,R.drawable.currant
                ,R.drawable.gooseberry
                ,R.drawable.datepalm
                ,R.drawable.cherry,R.drawable.acerola,R.drawable.watermelon
                ,R.drawable.banana,R.drawable.pineapple,R.drawable.mandarin
                ,R.drawable.fig,R.drawable.roseapple
                ,R.drawable.grapefruit,R.drawable.lemon,R.drawable.lime,R.drawable.calamansi
                ,R.drawable.quince,R.drawable.mango,R.drawable.mangosteen,R.drawable.dragonfruit
                ,R.drawable.passionfruit
                ,R.drawable.koreanmelon,R.drawable.pomegranate,R.drawable.coconut,R.drawable.papaya
                ,R.drawable.durian,R.drawable.guava,R.drawable.tamarind
                ,R.drawable.avocado,R.drawable.rambutan,R.drawable.starapple,R.drawable.guarana,R.drawable.olives
                ,R.drawable.peanut,R.drawable.walnut
                ,R.drawable.cashewnut};

        //어댑터 연결하기
        Myadapter mAdapter = new Myadapter(imgSet, textSet, getActivity().getApplicationContext());
        todo.setAdapter(mAdapter);
        return rootview;
    }
}