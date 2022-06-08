package com.example.myrproject;

import android.app.Dialog;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Tab_Recipe extends Fragment {

    DBHelper dbHelper;
    SQLiteDatabase sqlitedb;
    private TextView emptytxt;
    private RecyclerView recyclerview;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button fab;
    public static int num;
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

    public void loadCookNameDB() {
        // 저장되어있던 DB를 가져온다
        mRItems = mRecipeDB.getCookName();
        mAdapter = new MySecondAdapter(mRItems,getActivity());//context는 자기자신
        //첫번째 리스트는 ArrayList가 되어야 한다 생성자에서 그렇게 만들었으므로 //ctrl + CustomAdapter누르면 그 생성자로 볼수있다
        mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {

            @Override
            public void onChanged() {
                super.onChanged();
                checkEmpty();
            }

            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                checkEmpty();
            }

            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                super.onItemRangeRemoved(positionStart, itemCount);
                checkEmpty();
            }

            void checkEmpty() {
                emptytxt.setVisibility(mAdapter.getItemCount() == 0 ? View.VISIBLE : View.GONE);
            }
        });

        recyclerview.setHasFixedSize(true);//recycler성능 강화라고 한다
        recyclerview.setAdapter(mAdapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_tab__recipe,container,false);

        recyclerview = rootview.findViewById(R.id.recyclerview2);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mLayoutManager);
        mRecipeDB = new RecipeDB(getActivity());
        emptytxt = rootview.findViewById(R.id.emptytxt);
        loadCookNameDB();
        fab = rootview.findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = mRecipeDB.getNum();
                MySecondAdapter.foodname = null;
                Intent intent = new Intent(getActivity(), AddRecipe.class);
                startActivity(intent);
            }
        });
        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadCookNameDB();
        mAdapter.notifyDataSetChanged();
    }
}