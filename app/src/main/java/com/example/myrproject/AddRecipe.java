package com.example.myrproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddRecipe extends AppCompatActivity {

    FloatingActionButton foodfab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("레시피 추가");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        foodfab = findViewById(R.id.foodfab);
        foodfab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRecipe.this, ThirdActivity.class);
                startActivity(intent);
            }
        });


    }

    public void register(View v){
        EditText et_name =(EditText)findViewById(R.id.name);
        String st_name = et_name.getText().toString();
        EditText explain_recipe =(EditText) findViewById(R.id.edit_explanation);
        String explain = explain_recipe.getText().toString();
        //여기 데이터베이스에 넣는거 코드 추가
        finish();
    }
}
