package com.example.myrproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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

public class Detail_Recipe extends AppCompatActivity {
    RecyclerView recyclerview;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<MyRItem> mRItems;
    RecipeDB mRecipeDB;
    CustomAdapter mAdapter;
    TextView detail_cookname;
    TextView detail_explanation;
    String a;
    String b;
    String info;
    public static int cooktype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_recipe);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("상세 레시피");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview = findViewById(R.id.detail_recipe_recyclerview);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(mLayoutManager);
        mRecipeDB = new RecipeDB(this);
        //view 누르면 나오는 이름으로 해야한다
        //view onclick리스너에서 text읽어와서 그 이름 넣어야 한 아래 loadRecipeDBName에
        detail_cookname = findViewById(R.id.detail_cookname);
        detail_explanation = findViewById(R.id.detail_explanation);

        a = this.getIntent().getStringExtra("a");
        b = this.getIntent().getStringExtra("b");
        detail_cookname.setText(a);

        info = mRecipeDB.getCookInfo(a);
        detail_explanation.setText(info);

        loadRecipeDBName(MySecondAdapter.foodname);


    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                if(MySecondAdapter.z==0) {
                    MainActivity.tabtype = 2;
                }
                else{
                    MySecondAdapter.z=0;
                }
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void loadRecipeDBType(String _type) {
        // 저장되어있던 DB를 가져온다
        if(_type.equals("없어요")){
            cooktype = Tab_Recipe.num;
        }
        mRItems = mRecipeDB.getCookItemType(Integer.toString(cooktype));
        mAdapter = new CustomAdapter(mRItems, this);//context는 자기자신
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(mAdapter);
    }

    public void loadRecipeDBName(String food) {
        // 저장되어있던 DB를 가져온다
        int a;
        String x;
        if(mRecipeDB.getCookItem(food).equals("없어요")){
            a = -1;
        }
        else{
            cooktype = Integer.parseInt(mRecipeDB.getCookItem(food));
            a=cooktype;
        }
        if(a==-1){
            x="없어요";
        }
        else{
            x=Integer.toString(a);
        }
        loadRecipeDBType(x);
    }
    @Override
    public void onBackPressed() {
        if(MySecondAdapter.z==0) {
            MainActivity.tabtype = 2;
        }
        else{
            MySecondAdapter.z=0;
        }
        finish();
    }
}
