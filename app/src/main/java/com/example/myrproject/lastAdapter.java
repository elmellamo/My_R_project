package com.example.myrproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class lastAdapter extends RecyclerView.Adapter<lastAdapter.ViewHolder>{
    private ArrayList<String> mRItems;
    public ArrayList<MyRItem> mSelected = new ArrayList<>();
    private Context mContext;
    private RecipeDB mRecipeDB;
    RecyclerView recyclerView;//public static String foodname;
    public String foodname;
    private ArrayList<MyRItem> fooditem;
    //생성자 Alt + insert control+a enter

    public interface OnListItemLongSelectedInterface {
        void onItemLongSelected(View v, int position);
    }
    public interface OnListItemSelectedInterface {
        void onItemSelected(View v, int position);
    }
    private OnListItemSelectedInterface mListener;
    private OnListItemLongSelectedInterface mLongListener;
    private SparseBooleanArray mSelectedItems = new SparseBooleanArray(0);

    public lastAdapter(Context mContext, RecyclerView recyclerView,  OnListItemSelectedInterface listener, OnListItemLongSelectedInterface longListener, ArrayList<String> mRItems) {
        this.mContext = mContext;
        mRecipeDB = new RecipeDB(mContext);
        this.mRItems = mRItems;
        this.mListener = listener;
        this.mLongListener = longListener;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list,parent,false);
        return new ViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recipe_title.setText(mRItems.get(position));
        holder.itemView.setSelected(isItemSelected(position));
        if (isItemSelected(position)) {
            //아이템 선택된것
            holder.itemView.setBackgroundColor(Color.BLUE);
        } else {
            //아이템 선택 안된것
            holder.itemView.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return mRItems.size();
    }//recycler view

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView recipe_title;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recipe_title = itemView.findViewById(R.id.recipe_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int currentPos = getAdapterPosition();// 현재 리스트 클릭한 아이템위치
                    recipe_title = view.findViewById(R.id.recipe_title);
                    toggleItemSelected(currentPos);
                    foodname = recipe_title.getText().toString();
                    mListener.onItemSelected(view,currentPos);

                    //mSelected에 터치한 메뉴 재료들 저장
                    fooditem = new ArrayList<MyRItem>();
                    fooditem = mRecipeDB.getCookItemType(mRecipeDB.getCookItem(foodname));
                    if (isItemSelected(currentPos)) {
                        //아이템 선택된것
                        if(!(mRecipeDB.getCookItem(foodname).equals("없어요"))){
                            //없어요가 나올수가 없음
                            for(MyRItem a: fooditem){
                                if(mSelected!=null && mSelected.contains(a)){
                                    int position = mSelected.indexOf(a);
                                    MyRItem item = mSelected.get(position);
                                    item.setCnt(Integer.toString(Integer.parseInt(a.getCnt())+Integer.parseInt(item.getCnt())));
                                    mSelected.set(position,item);
                                }
                                else{
                                    //재료 이름이 없다면
                                    mSelected.add(a);
                                }
                            }
                            Toast.makeText(mContext, "선택됐습니다", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        //아이템 선택 안된것
                        if(!(mRecipeDB.getCookItem(foodname).equals("없어요"))){
                            //없어요가 나올수가 없음
                            for(MyRItem a: fooditem){
                                if(mSelected!=null && mSelected.contains(a)){
                                    int position = mSelected.indexOf(a);
                                    MyRItem item = mSelected.get(position);
                                    if(Integer.parseInt(item.getCnt())-Integer.parseInt(a.getCnt())==0){
                                        mSelected.remove(position);
                                    }
                                    else{
                                        item.setCnt(Integer.toString(Integer.parseInt(item.getCnt())-Integer.parseInt(a.getCnt())));
                                        mSelected.set(position,item);
                                    }
                                }
                                //재료 이름이 없을 수 없다//선택될때 추가 되므로
                            }
                            Toast.makeText(mContext, "선택 취소했습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mLongListener.onItemLongSelected(v, getAdapterPosition());
                    return false;
                }
            });
        }
    }

    private void toggleItemSelected(int position) {
        if (mSelectedItems.get(position, false) == true) {
            mSelectedItems.delete(position);
            notifyItemChanged(position);
        } else {
            mSelectedItems.put(position, true);
            notifyItemChanged(position);
        }
    }

    private boolean isItemSelected(int position) {
        return mSelectedItems.get(position, false);
    }

    public void clearSelectedItem() {
        int position;
        for (int i = 0; i < mSelectedItems.size(); i++) {
            position = mSelectedItems.keyAt(i);
            mSelectedItems.put(position, false);
            notifyItemChanged(position);
        }
        mSelectedItems.clear();
    }


}



