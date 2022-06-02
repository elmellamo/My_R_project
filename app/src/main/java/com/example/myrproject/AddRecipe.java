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

public class AddRecipe extends AppCompatActivity {
    FloatingActionButton foodfab;
    RecyclerView recyclerview;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<MyRItem> mRItems;
    RecipeDB mRecipeDB;
    CustomAdapter mAdapter;
    public static int cooktype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("레시피 추가");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview = findViewById(R.id.recipe_add_recyclerview);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(mLayoutManager);
        mRecipeDB = new RecipeDB(this);
        //view 누르면 나오는 이름으로 해야한다
        //view onclick리스너에서 text읽어와서 그 이름 넣어야 한 아래 loadRecipeDBName에
        loadRecipeDBName(MySecondAdapter.foodname);

        foodfab = findViewById(R.id.foodfab);
        foodfab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRecipe.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                mRecipeDB.DeleteCookName("요리");
                mRItems.clear();
                mAdapter.notifyDataSetChanged();
                finish();
                return true;
            default:
                break;
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

    public void register(View v){
        EditText et_name =(EditText)findViewById(R.id.tv_cookname);
        String st_name = et_name.getText().toString();
        EditText explain_recipe =(EditText) findViewById(R.id.edit_explanation);
        String explain = explain_recipe.getText().toString();

        if(st_name.getBytes().length <= 0){//빈값이 넘어올때의 처리
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("제목");
            builder.setMessage("이름 쳐주세요");
            builder.setPositiveButton("예",null);
            builder.create().show();
        }
        else{
            mRecipeDB.UpdateOk(st_name, explain, Integer.toString(cooktype));
            Tab_Recipe.num = mRecipeDB.getNum();
            finish();
        }
    }


}
