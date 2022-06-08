package com.example.myrproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Shopping extends AppCompatActivity {
    private ArrayList<MyRItem> mBItems;
    private ArrayList<MyRItem> mRItems;
    private ArrayList<String> mCItems;
    RecyclerView recyclerview1;
    RecyclerView recyclerview2;
    LinearLayoutManager mLayoutManager;
    LinearLayoutManager mLayoutManager2;
    RecipeDB mRecipeDB;
    DBHelper mDBHelper;
    MySecondAdapter mAdapter1;
    CustomAdapter mAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("장보러 가기");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview1 = findViewById(R.id.which_cooking);
        recyclerview2 = findViewById(R.id.lets_shopping);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager2 = new LinearLayoutManager(this);
        recyclerview1.setLayoutManager(mLayoutManager);
        recyclerview2.setLayoutManager(mLayoutManager2);
        mDBHelper = new DBHelper(this);
        mRecipeDB = new RecipeDB(this);
        loadRefrigerator();
        loadBuyItem();
        loadCookNameDB();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void loadBuyItem() {
        //사야할 목록
        mBItems = Tab_which.mBuyItems;
        //mBItems null이면 못 받게 했다
        if(mRItems == null){
            //냉장고 없으면 그냥 mBItems
        }else{
            for(MyRItem a : mRItems){
                if(mBItems.contains(a)){
                    int position = mBItems.indexOf(a);
                    MyRItem item = mBItems.get(position);
                    if(Double.parseDouble(item.getCnt())-Double.parseDouble(a.getCnt())>0){
                        item.setCnt(Double.toString(Double.parseDouble(item.getCnt())-Double.parseDouble(a.getCnt())));
                        mBItems.set(position,item);
                    }
                    else{
                        mBItems.remove(position);
                    }
                }//없다면 아무짓도 안함
            }
        }
        mAdapter2 = new CustomAdapter(mBItems, this);
        recyclerview2.setHasFixedSize(true);
        recyclerview2.setAdapter(mAdapter2);
    }

    public void loadRefrigerator() {
        //냉장고 물품 없으면 null로 받는다
        mRItems = mDBHelper.getNameCnt();
    }

    public void loadCookNameDB() {
        // 저장되어있던 DB를 가져온다
        mCItems = this.getIntent().getStringArrayListExtra("배열");
        mAdapter1 = new MySecondAdapter(mCItems,this);//context는 자기자신
        recyclerview1.setHasFixedSize(true);//recycler성능 강화라고 한다
        recyclerview1.setAdapter(mAdapter1);
    }
}






















