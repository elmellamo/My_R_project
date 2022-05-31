package com.example.myrproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {
    Fruit fruit;
    Vegetable vegetable;
    Meat meat;
    Fish fish;
    Dairy dairy;
    Drink drink;
    Sauce sauce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setTitle("식품 추가");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fruit = new Fruit();
        vegetable = new Vegetable();
        meat = new Meat();
        fish = new Fish();
        dairy = new Dairy();
        drink = new Drink();
        sauce = new Sauce();

        ImageButton fruitbtn =  findViewById(R.id.fruit);
        fruitbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, fruit).commit();
            }
        });

        ImageButton vegbtn =  findViewById(R.id.vegetable);
        vegbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, vegetable).commit();
            }
        });

        ImageButton meatbtn =  findViewById(R.id.meat);
        meatbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, meat).commit();
            }
        });

        ImageButton fishbtn =  findViewById(R.id.fish);
        fishbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, fish).commit();
            }
        });

        ImageButton dairybtn =  findViewById(R.id.dairy);
        dairybtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, dairy).commit();
            }
        });

        ImageButton drinkbtn =  findViewById(R.id.drink);
        drinkbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, drink).commit();
            }
        });

        ImageButton saucebtn =  findViewById(R.id.sauce);
        saucebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.listcontainer, sauce).commit();
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
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}