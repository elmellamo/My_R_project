package com.example.myrproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Test extends Fragment {

    private FloatingActionButton fab;
    RecipeDB mRecipeDB;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_test,container,false);
        mRecipeDB = new RecipeDB(getActivity());
        fab = (FloatingActionButton) rootview.findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tab_Recipe.num = mRecipeDB.getNum();
                MySecondAdapter.foodname = null;
                Intent intent = new Intent(getActivity(), AddRecipe.class);
                startActivity(intent);
            }
        });
        return rootview;
    }
}