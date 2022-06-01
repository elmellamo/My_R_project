package com.example.myrproject;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class Tab_Recipe extends Fragment {

    DBHelper dbHelper;
    SQLiteDatabase sqlitedb;

    private RecyclerView recyclerview;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton fab;


    public Tab_Recipe() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_tab__recipe,container,false);

        fab = (FloatingActionButton) rootview.findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getContext(), android.R.style.Theme_Material_Light_Dialog);
                dialog.setContentView(R.layout.dialog_recipe);

                EditText et_name = dialog.findViewById(R.id.et_name);
                //여기 et_name이 RecipeDB에 들어갈 수 있도록 저장하는 거 필요 >> 일단 좀 있따가
                Button btn_add = dialog.findViewById(R.id.btn_add);

                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        Intent intent = new Intent(getActivity(), AddRecipe.class);
                        startActivity(intent);

                    }
                });



            }
        });
        return rootview;
    }
}