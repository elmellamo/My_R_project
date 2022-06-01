package com.example.myrproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

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
    public static String itemtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

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
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, fruit).commit();
                itemtype = "과일";
                fruitbtn.setBackgroundColor(0x2f000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });

        vegbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, vegetable).commit();
                itemtype = "채소";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x2f000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });

        meatbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, meat).commit();
                itemtype = "정육/계란";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x2f000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });

        fishbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, fish).commit();
                itemtype = "수산물";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x2f000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });

        dairybtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, dairy).commit();
                itemtype = "유제품";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x2f000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });

        drinkbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, drink).commit();
                itemtype = "음료";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x2f000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });


        saucebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, sauce).commit();
                itemtype = "장/소스/드레싱";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x2f000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });


        ricebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, rice).commit();
                itemtype = "곡류";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x2f000000);  kimchibtn.setBackgroundColor(0x00000000);
            }
        });


        kimchibtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, kimchi).commit();
                itemtype = "김치/반찬";
                fruitbtn.setBackgroundColor(0x00000000);  vegbtn.setBackgroundColor(0x00000000);  meatbtn.setBackgroundColor(0x00000000);
                fishbtn.setBackgroundColor(0x00000000);  dairybtn.setBackgroundColor(0x00000000);  drinkbtn.setBackgroundColor(0x00000000);
                saucebtn.setBackgroundColor(0x00000000);  ricebtn.setBackgroundColor(0x00000000);  kimchibtn.setBackgroundColor(0x2f000000);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.searchmenu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //searchContact(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //adapter.getFilter().filter(newText);
                //searchContact(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}