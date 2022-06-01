package com.example.myrproject;

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
import android.content.Intent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class Tab_MyR extends Fragment {

    public Tab_MyR() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    RecyclerView recyclerview;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ExpandableListAdapter.Item> mRItems;
    DBHelper mDBHelper;
    FloatingActionButton fab;
    ExpandableListAdapter mAdapter;

    public void loadRecentDB() {
        // 저장되어있던 DB를 가져온다
        mRItems = mDBHelper.getItem();

            mAdapter = new ExpandableListAdapter(mRItems,getActivity());//context는 자기자신
            //첫번째 리스트는 ArrayList가 되어야 한다 생성자에서 그렇게 만들었으므로 //ctrl + CustomAdapter누르면 그 생성자로 볼수있다
            recyclerview.setHasFixedSize(true);//recycler성능 강화라고 한다
            recyclerview.setAdapter(mAdapter);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_tab__my_r,container,false);
        recyclerview = rootview.findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mLayoutManager);
        mDBHelper = new DBHelper(getActivity());
        loadRecentDB();

        fab = (FloatingActionButton) rootview.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
            }
        });
        return rootview;
    }
}