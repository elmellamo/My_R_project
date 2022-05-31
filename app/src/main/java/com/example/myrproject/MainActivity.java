package com.example.myrproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    Tab_MyR tab_myR;
    Tab_Recipe tab_recipe;
    Tab_which tab_which;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
                if(position == 0)
                    selected = tab_myR;
                else if(position == 1)
                    selected = tab_recipe;
                else if(position == 2)
                    selected = tab_which;
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
}