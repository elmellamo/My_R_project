package com.example.myrproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Tab_which extends Fragment implements lastAdapter.OnListItemLongSelectedInterface, lastAdapter.OnListItemSelectedInterface{
    DBHelper mDBHelper;
    RecipeDB mRecipeDB;
    ArrayList<MyRItem> mReItems;
    ArrayList<String> mCItems;
    lastAdapter mAdapter;
    private RecyclerView recyclerview;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button register;

    public Tab_which() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_tab_which, container, false);
        recyclerview = rootview.findViewById(R.id.recipe_recyclerview);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mLayoutManager);
        register = rootview.findViewById(R.id.lets_go_btn);
        mRecipeDB = new RecipeDB(getActivity());
        loadItem();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Shopping.class);
                startActivity(intent);
            }
        });

        return rootview;
    }


    public void loadRefrigerator() {
        // 저장되어있던 DB를 가져온다
        mReItems = mDBHelper.getNameCnt();
    }

    public void loadItem() {
        mCItems = mRecipeDB.getCookName();
        mAdapter = new lastAdapter(getActivity(), recyclerview, this, this, mCItems);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(mAdapter);
    }

    @Override
    public void onItemSelected(View v, int position) {
        lastAdapter.ViewHolder viewHolder = (lastAdapter.ViewHolder)recyclerview.findViewHolderForAdapterPosition(position);
        //Toast.makeText(getActivity(), viewHolder.recipe_title.getText().toString(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, position + " clicked", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onItemLongSelected(View v, int position) {
        Toast.makeText(getActivity(), position + " long clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadItem();
        mAdapter.notifyDataSetChanged();
    }

}