package com.example.myrproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    Fruit fruit;
    Vegetable vegetable;
    Meat meat;
    Fish fish;
    Dairy dairy;
    Drink drink;
    Sauce sauce;
    Rice rice;
    Kimchi kimchi;
    public static String cooktype;

    private RecipeDB mRecipeDB = new RecipeDB(ThirdActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ImageButton user_append_btn = findViewById(R.id.user_append);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("재료 추가");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fruit = new Fruit();
        vegetable = new Vegetable();
        meat = new Meat();
        fish = new Fish();
        dairy = new Dairy();
        drink = new Drink();
        sauce = new Sauce();
        rice = new Rice();
        kimchi = new Kimchi();

        ImageButton fruitbtn =  findViewById(R.id.fruit);
        ImageButton vegbtn =  findViewById(R.id.vegetable);
        ImageButton meatbtn =  findViewById(R.id.meat);
        ImageButton fishbtn =  findViewById(R.id.fish);
        ImageButton dairybtn =  findViewById(R.id.dairy);
        ImageButton drinkbtn =  findViewById(R.id.drink);
        ImageButton saucebtn =  findViewById(R.id.sauce);
        ImageButton ricebtn =  findViewById(R.id.rice);
        ImageButton kimchibtn =  findViewById(R.id.kimchi);
        fruitbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer2, fruit).commit();
                cooktype = "과일";
                fruitbtn.setBackgroundColor(0x2f000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });

        vegbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer2, vegetable).commit();
                cooktype = "채소";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x2f000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });

        meatbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer2, meat).commit();
                cooktype = "정육/계란";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x2f000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });

        fishbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer2, fish).commit();
                cooktype = "수산물";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x2f000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });

        dairybtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer2, dairy).commit();
                cooktype = "유제품";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x2f000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });

        drinkbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer2, drink).commit();
                cooktype = "음료";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x2f000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });


        saucebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer2, sauce).commit();
                cooktype = "장/소스/드레싱";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x2f000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });


        ricebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer2, rice).commit();
                cooktype = "곡류";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x2f000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });


        kimchibtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer2, kimchi).commit();
                cooktype = "김치/반찬";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x2f000000);
            }
        });

        user_append_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SecondActivity.itemtype = "기타";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
                user_append_btn.setBackgroundColor(0x2f000000);

                Dialog dialog = new Dialog(ThirdActivity.this, android.R.style.Theme_Material_Light_Dialog);
                dialog.setContentView(R.layout.dialog_user_add);
                //커스텀 다이얼로그
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCanceledOnTouchOutside(false);

                //다이얼로그 크기 조절하기
                WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setAttributes((WindowManager.LayoutParams) params);


                EditText whats_name = dialog.findViewById(R.id.whats_name);
                EditText et_cnt = dialog.findViewById(R.id.et_cnt);
                EditText et_unit = dialog.findViewById(R.id.et_unit);
                Button btn_ok = dialog.findViewById(R.id.btn_ok);



                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String currentTime = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss").format(new Date());
                        String name = whats_name.getText().toString();
                        String cnt = et_cnt.getText().toString();
                        String unit = et_unit.getText().toString();


                        if(name.getBytes().length <= 0){//빈값이 넘어올때의 처리
                            AlertDialog.Builder builder = new AlertDialog.Builder(ThirdActivity.this);
                            builder.setTitle("재료 미등록");
                            builder.setMessage("재료 이름을 등록해주세요");
                            builder.setPositiveButton("예",null);
                            builder.create().show();
                        }
                        else if(cnt.getBytes().length <= 0){//빈값이 넘어올때의 처리
                            AlertDialog.Builder builder = new AlertDialog.Builder(ThirdActivity.this);
                            builder.setTitle("수량 미등록");
                            builder.setMessage("재료 수량을 등록해주세요");
                            builder.setPositiveButton("예",null);
                            builder.create().show();
                        }
                        else if(unit.getBytes().length <= 0){//빈값이 넘어올때의 처리
                            AlertDialog.Builder builder = new AlertDialog.Builder(ThirdActivity.this);
                            builder.setTitle("단위 미등록");
                            builder.setMessage("재료 단위를 등록해주세요");
                            builder.setPositiveButton("예",null);
                            builder.create().show();
                        }
                        else{
                            mRecipeDB.InsertCookItem("요리","정보",Integer.toString(AddRecipe.cooktype), name, cnt, unit, currentTime);
                            dialog.dismiss();
                            Toast.makeText(ThirdActivity.this, name+"가(이) 추가되었습니다.", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                Intent it = new Intent(this,AddRecipe.class);
                it.putExtra("a",this.getIntent().getStringExtra("a"));
                it.putExtra("b",this.getIntent().getStringExtra("b"));
                startActivity(it);
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        Intent it = new Intent(this,AddRecipe.class);
        it.putExtra("a",this.getIntent().getStringExtra("a"));
        it.putExtra("b",this.getIntent().getStringExtra("b"));
        startActivity(it);
        finish();
    }
}