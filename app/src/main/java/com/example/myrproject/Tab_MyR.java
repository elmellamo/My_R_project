package com.example.myrproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class Tab_MyR extends Fragment {

    public Tab_MyR() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private RecyclerView recyclerview;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_tab__my_r,container,false);

        recyclerview = (RecyclerView) rootview.findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mLayoutManager);
        List<ExpandableListAdapter.Item> data = new ArrayList<>();  // 데이터를 담을 List

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "운동"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "축구"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "농구"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "배구"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "과목"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "국어"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "영어"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "수학"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "과학"));

        recyclerview.setAdapter(new ExpandableListAdapter(data));



        return rootview;
    }
}