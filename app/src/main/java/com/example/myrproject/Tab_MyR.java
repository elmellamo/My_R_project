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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_tab__my_r,container,false);

        recyclerview = (RecyclerView) rootview.findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mLayoutManager);
        List<ExpandableListAdapter.Item> data = new ArrayList<>();  // 데이터를 담을 List

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "과일"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "축구"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "채소"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "국어"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "정육/계란"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "수산물"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "유제품"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "국어"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "음료"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "장/소스/드레싱"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "국어"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "국어"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "곡류"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "국어"));


        ExpandableListAdapter.Item places = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "김치/반찬");
        places.invisibleChildren = new ArrayList<>();
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "카이저"));
        data.add(places);

        recyclerview.setAdapter(new ExpandableListAdapter(data));


        fab = (FloatingActionButton) rootview.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, containermenu).commit();

            }
        });
        return rootview;
    }
}