package com.example.myrproject;

import android.content.Context;
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


    public Tab_Recipe() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_tab__recipe,container,false);

        recyclerview = (RecyclerView) rootview.findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mLayoutManager);

//        try {
//            dbHelper= new DBHelper(this);
//            sqlitedb =dbHelper.getReadableDatabase();
//            Cursor cursor =sqlitedb.query("Refrigerator", null, null, null, null, null, null);
//
//            int i=0;
//        } catch ()
        return rootview;
    }
}