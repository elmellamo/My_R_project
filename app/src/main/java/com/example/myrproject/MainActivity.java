package com.example.myrproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements lastAdapter.OnListItemLongSelectedInterface, lastAdapter.OnListItemSelectedInterface {
    TabLayout tabLayout;
    Tab_MyR tab_myR;
    Tab_Recipe tab_recipe;
    Tab_which tab_which;
    private RecyclerView recyclerview;
    private RecyclerView recyclerview2;
    private RecyclerView recyclerview3;
    public static int tabtype = 0;
    RecipeDB mRecipeDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecipeDB = new RecipeDB(this);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("냉장보고");

        tab_myR = new Tab_MyR();
        tab_recipe = new Tab_Recipe();
        tab_which = new Tab_which();

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("내 냉장고"));
        tabLayout.addTab(tabLayout.newTab().setText("레시피"));
        tabLayout.addTab(tabLayout.newTab().setText("뭐 먹지"));

        tabLayout.setTabTextColors(Color.rgb(0,0,0), Color.rgb(12, 77, 162));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        getSupportFragmentManager().beginTransaction().add(R.id.container, tab_myR).commit();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if(position == 0){
                    selected = tab_myR;
                    tabtype = 0;
                }
                else if(position == 1){
                    selected = tab_recipe;
                    tabtype = 1;
                }
                else if(position == 2) {
                    selected = tab_which;
                    tabtype = 2;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("냉장보고 앱을 종료하시겠습니까?");
        builder.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.searchmenu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);


        if(tabtype == 1){
            searchView.setQueryHint("메뉴를 검색합니다.");
        }
        else if(tabtype == 2){
            searchView.setQueryHint("메뉴를 검색합니다.");
        }
        else{
            searchView.setQueryHint("재료를 검색합니다.");
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(tabtype == 1){
                    search2(query);
                }
                else if(tabtype == 2){
                    search3(query);
                }
                else{
                    searchContact(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(tabtype == 1){
                    search2(newText);
                }
                else if(tabtype == 2){
                    search3(newText);
                }
                else{
                    searchContact(newText);
                }

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }



    private void search2(String keyword){
        recyclerview2 = findViewById(R.id.recyclerview2);
        registerForContextMenu(recyclerview2);
        RecipeDB databaseHelper = new RecipeDB(getApplicationContext());
        ArrayList<String> contacts = databaseHelper.search(keyword);
        if (contacts != null) {
            recyclerview2.setAdapter(new MySecondAdapter(contacts, MySecondAdapter.mContext));
        }
    }

    private void search3(String keyword){
        recyclerview3 = findViewById(R.id.recipe_recyclerview);
        registerForContextMenu(recyclerview3);
        RecipeDB databaseHelper = new RecipeDB(getApplicationContext());
        ArrayList<String> contacts = databaseHelper.search(keyword);
        if (contacts != null) {
            recyclerview3.setAdapter(new lastAdapter(lastAdapter.mContext,recyclerview3,this,this,contacts));
        }
    }

    private void searchContact(String keyword) {
        recyclerview = findViewById(R.id.recyclerview);
        registerForContextMenu(recyclerview);
        DBHelper databaseHelper = new DBHelper(getApplicationContext());
        ArrayList<ExpandableListAdapter.Item> contacts = databaseHelper.search(keyword);
        if (contacts != null) {
            recyclerview.setAdapter(new ExpandableListAdapter(contacts, ExpandableListAdapter.mContext));
        }
    }

    @Override
    public void onItemLongSelected(View v, int position) {

    }

    @Override
    public void onItemSelected(View v, int position) {

    }
}