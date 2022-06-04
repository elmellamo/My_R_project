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

        LayoutManager = new GridLayoutManager(getActivity(), 4);
        todo.setLayoutManager(LayoutManager);

        String[] textSet = {"커피","콜라","요구르트","오렌지주스","과일 주스","두유","식혜"
                ,"콜드브루","라떼","프라푸치노","바나나주스","딸기주스","수박주스","물"
                ,"탄산수","칵테일","위스키","소주","맥주","보드카","와인","막걸리"
                ,"사케","데킬라","럼","샴페인","진","에너지드링크"};
        int[] imgSet = {R.drawable.coffee,R.drawable.cola, R.drawable.yoghurt, R.drawable.orangejuice
                , R.drawable.fruits, R.drawable.soybeanmilk, R.drawable.sikhye,R.drawable.coldbrew
                ,R.drawable.latte,R.drawable.frappuccino,R.drawable.bananajuice,R.drawable.strawberryjuice
                ,R.drawable.watermelonjuice,R.drawable.water,R.drawable.sparklingwater,R.drawable.cocktail
                ,R.drawable.whisky,R.drawable.soju,R.drawable.beer, R.drawable.vodka,R.drawable.wine
                ,R.drawable.ricewine,R.drawable.sake,R.drawable.tequila,R.drawable.rum
                ,R.drawable.champagne,R.drawable.gin,R.drawable.energydrink};

        //어댑터 연결하기
        Myadapter mAdapter = new Myadapter(imgSet, textSet,getActivity().getApplicationContext());
        todo.setAdapter(mAdapter);
        return rootview;
    }


}