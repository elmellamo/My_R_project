package com.example.myrproject;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder>{

    private String[] textSet;
    private int[] imgSet;
    private Context mContext;
    private DBHelper mDBHelper;
    private RecipeDB mRecipeDB;
    private ExpandableListAdapter mAdapter;

    public Myadapter(int[] imgSet, String[] textSet, Context mContext){
        this.imgSet = imgSet;
        this.textSet = textSet;
        this.mContext = mContext;
        mDBHelper = new DBHelper(mContext);
        mRecipeDB = new RecipeDB(mContext);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())

                .inflate(R.layout.item_list, parent, false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.mTitle.setText(this.textSet[i]);
        holder.mImage.setBackgroundResource(this.imgSet[i]);
    }

    @Override
    public int getItemCount() {
        return textSet.length > imgSet.length ? textSet.length : imgSet.length;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImage;
        public final TextView mTitle;



        public MyViewHolder(@NonNull View view) {
            super(view);
            this.mImage = view.findViewById(R.id.tv_image);
            this.mTitle = view.findViewById(R.id.tv_title);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int curPos = getAdapterPosition();
                    String itemname = textSet[curPos];
                    String itemimg = SecondActivity.itemtype;

                    //R.drawable.vegetable  //  imgSet[curPos] (?????? ???????????? ?????????????????? ?????????..)
                    String currentTime = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss").format(new Date());//?????? ?????? ?????????????????? ????????????
                    //????????? ?????????????????? ????????? ????????? ??? ?????? ??????

                    if(MainActivity.tabtype == 0){
                        mDBHelper.InsertItem(itemimg, itemname, "1", "???", currentTime);//??????????????? ?????? ??? ????????????
                        //UpdateTodo ctrl???????????? ???????????? ??? ????????? ????????? ??? ??????
                        Toast.makeText(mContext, itemname+"???(???) ??????????????????", Toast.LENGTH_SHORT).show();
                    }
                    else if(MainActivity.tabtype == 1){
                        mRecipeDB.InsertCookItem("??????","??????",Integer.toString(AddRecipe.cooktype),itemname,"1","???",currentTime);
                        Toast.makeText(mContext, itemname+"???(???) ????????? ??????????????????", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
