package com.example.myrproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class Tab_which extends Fragment {

    private RecyclerView recyclerview;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton fab;
    public static int num;
    ArrayList<String> mRItems;
    RecipeDB mRecipeDB;
    MySecondAdapter mAdapter;

    public Tab_which() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void loadCookNameDB() {
        // 저장되어있던 DB를 가져온다
        mRItems = mRecipeDB.getCookName();
        mAdapter = new MySecondAdapter(mRItems,getActivity());//context는 자기자신
        //첫번째 리스트는 ArrayList가 되어야 한다 생성자에서 그렇게 만들었으므로 //ctrl + CustomAdapter누르면 그 생성자로 볼수있다
        recyclerview.setHasFixedSize(true);//recycler성능 강화라고 한다
        recyclerview.setAdapter(mAdapter);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_tab_which,container,false);

        recyclerview = rootview.findViewById(R.id.recipe_recyclerview);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mLayoutManager);
        mRecipeDB = new RecipeDB(getActivity());
        loadCookNameDB();

        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadCookNameDB();
        mAdapter.notifyDataSetChanged();
    }
}
