package com.example.myrproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
    public boolean onOptionsItemSelected(MenuItem item ){
        switch(item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(getApplicationContext(), AddRecipe.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

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
        loadRecipeDBName("요리");

        foodfab = findViewById(R.id.foodfab);
        foodfab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRecipe.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }



    public void loadRecipeDBType(String _type) {
        // 저장되어있던 DB를 가져온다
        if(_type.equals("없어요")){
            cooktype = Tab_Recipe.num;
        }
        else {
            mRItems = mRecipeDB.getCookItemType(Integer.toString(cooktype));
            mAdapter = new CustomAdapter(mRItems, this);//context는 자기자신
            recyclerview.setHasFixedSize(true);
            recyclerview.setAdapter(mAdapter);
        }
    }

    public void loadRecipeDBName(String food) {
        // 저장되어있던 DB를 가져온다
        cooktype = Integer.parseInt(mRecipeDB.getCookItem(food));
        loadRecipeDBType(Integer.toString(cooktype));
    }


    public void register(View v){
        //EditText et_name =(EditText)findViewById(R.id.tv_cookname);
        //String st_name = et_name.getText().toString();
        //EditText explain_recipe =(EditText) findViewById(R.id.edit_explanation);
        //String explain = explain_recipe.getText().toString();
        //여기 데이터베이스에 넣는거 코드 추가
        //finish();
    }
}
