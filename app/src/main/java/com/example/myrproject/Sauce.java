package com.example.myrproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Sauce extends Fragment {

    public Sauce() {
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

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_sauce,container,false);

        todo = (RecyclerView) rootview.findViewById(R.id.sauce_todo);
        todo.setHasFixedSize(true);

        LayoutManager = new GridLayoutManager(getActivity(), 5);
        todo.setLayoutManager(LayoutManager);

        String[] textSet = {"고추장", "고추가루","간장","된장","케찹","식용유","연유","마요네즈","스테이크소스","굴소스","파스타소스","칠리소스","식초","메이플시럽","초콜릿시럽"};
        int[] imgSet = {R.drawable.chillipepper, R.drawable.chilipowder2,R.drawable.soysauce, R.drawable.soybeanpaste, R.drawable.ketchup
                ,R.drawable.oil,R.drawable.evaporatedmilk, R.drawable.mayonnaise, R.drawable.steaksauce, R.drawable.oystersauce, R.drawable.pastasauce, R.drawable.chilisauce, R.drawable.balsamicvinegar, R.drawable.maplesyrup, R.drawable.syrup};

        //어댑터 연결하기
        Myadapter mAdapter = new Myadapter(imgSet, textSet,getActivity().getApplicationContext());
        todo.setAdapter(mAdapter);
        return rootview;
    }


}