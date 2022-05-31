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

public class Fish extends Fragment {

    public Fish() {
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

        String[] textSet = {"고등어", "연어","대구","참치","장어","가자미","새우","게","오징어","낙지","문어","고둥","조개","굴","김","미역","멸치","회"};
        int[] imgSet = {R.drawable.mackerel, R.drawable.salmon,R.drawable.cod,R.drawable.tuna,R.drawable.angler,R.drawable.flounder,R.drawable.shrimp,R.drawable.crab,R.drawable.squid,R.drawable.smalloctopus,R.drawable.octopus,R.drawable.seasnail,R.drawable.clam,R.drawable.oyster,R.drawable.nori,R.drawable.seaweed,R.drawable.anchovy,R.drawable.sashimi};

        //어댑터 연결하기
        Myadapter mAdapter = new Myadapter(imgSet, textSet);
        todo.setAdapter(mAdapter);
        return rootview;
    }
}