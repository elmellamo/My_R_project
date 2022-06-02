package com.example.myrproject;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class Tab_Recipe extends Fragment {

    DBHelper dbHelper;
    SQLiteDatabase sqlitedb;

    private RecyclerView recyclerview;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton fab;
    public static int num = 0;
    ArrayList<String> mRItems;
    RecipeDB mRecipeDB;
    MySecondAdapter mAdapter;


    public Tab_Recipe() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void loadRecentDB() {
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
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_tab__recipe,container,false);

        fab = (FloatingActionButton) rootview.findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                Intent intent = new Intent(getActivity(), AddRecipe.class);
                startActivity(intent);
            }
        });
        return rootview;
    }
}