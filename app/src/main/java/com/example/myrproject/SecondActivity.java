package com.example.myrproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.content.DialogInterface;
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

public class SecondActivity extends AppCompatActivity {
    Fruit fruit;
    Vegetable vegetable;
    Meat meat;
    Fish fish;
    Dairy dairy;
    Drink drink;
    Sauce sauce;
    Rice rice;
    Kimchi kimchi;
    public static String itemtype;

    private DBHelper mDBHelper = new DBHelper(SecondActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("μν μΆκ°");
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
        ImageButton user_append_btn = findViewById(R.id.user_append);

        fruitbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, fruit).commit();
                itemtype = "κ³ΌμΌ";
                fruitbtn.setBackgroundColor(0x2f000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
                user_append_btn.setBackgroundColor(0x00000000);
            }
        });

        vegbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, vegetable).commit();
                itemtype = "μ±μ";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x2f000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
                user_append_btn.setBackgroundColor(0x00000000);
            }
        });

        meatbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, meat).commit();
                itemtype = "μ μ‘/κ³λ";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x2f000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
                user_append_btn.setBackgroundColor(0x00000000);
            }
        });

        fishbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, fish).commit();
                itemtype = "μμ°λ¬Ό";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x2f000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
                user_append_btn.setBackgroundColor(0x00000000);
            }
        });

        dairybtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, dairy).commit();
                itemtype = "μ μ ν";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x2f000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
                user_append_btn.setBackgroundColor(0x00000000);
            }
        });

        drinkbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, drink).commit();
                itemtype = "μλ£";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x2f000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
                user_append_btn.setBackgroundColor(0x00000000);
            }
        });


        saucebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, sauce).commit();
                itemtype = "μ₯/μμ€";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x2f000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
                user_append_btn.setBackgroundColor(0x00000000);
            }
        });


        ricebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, rice).commit();
                itemtype = "κ³‘λ₯";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x2f000000);  kimchibtn.setBackgroundColor(0x00000000);
                user_append_btn.setBackgroundColor(0x00000000);
            }
        });


        kimchibtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, kimchi).commit();
                itemtype = "κΉμΉ/λ°μ°¬";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x2f000000);
                user_append_btn.setBackgroundColor(0x00000000);
            }
        });

        user_append_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                itemtype = "κΈ°ν";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
                user_append_btn.setBackgroundColor(0x2f000000);

                Dialog dialog = new Dialog(SecondActivity.this, android.R.style.Theme_Material_Light_Dialog);
                dialog.setContentView(R.layout.dialog_user_add);
                //μ»€μ€ν λ€μ΄μΌλ‘κ·Έ
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCanceledOnTouchOutside(false);

                //λ€μ΄μΌλ‘κ·Έ ν¬κΈ° μ‘°μ νκΈ°
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


                        if(name.getBytes().length <= 0){//λΉκ°μ΄ λμ΄μ¬λμ μ²λ¦¬
                            AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
                            builder.setTitle("μ¬λ£ λ―Έλ±λ‘");
                            builder.setMessage("μ¬λ£ μ΄λ¦μ λ±λ‘ν΄μ£ΌμΈμ");
                            builder.setPositiveButton("μ",null);
                            builder.create().show();
                        }
                        else if(cnt.getBytes().length <= 0){//λΉκ°μ΄ λμ΄μ¬λμ μ²λ¦¬
                            AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
                            builder.setTitle("μλ λ―Έλ±λ‘");
                            builder.setMessage("μ¬λ£ μλμ λ±λ‘ν΄μ£ΌμΈμ");
                            builder.setPositiveButton("μ",null);
                            builder.create().show();
                        }
                        else if(unit.getBytes().length <= 0){//λΉκ°μ΄ λμ΄μ¬λμ μ²λ¦¬
                            AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
                            builder.setTitle("λ¨μ λ―Έλ±λ‘");
                            builder.setMessage("μ¬λ£ λ¨μλ₯Ό λ±λ‘ν΄μ£ΌμΈμ");
                            builder.setPositiveButton("μ",null);
                            builder.create().show();
                        }
                        else{
                            mDBHelper.InsertItem(itemtype, name, cnt, unit, currentTime);
                            dialog.dismiss();
                            Toast.makeText(SecondActivity.this, name+"κ°(μ΄) μΆκ°λμμ΅λλ€.", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                dialog.show();
            }
        });
   }
}