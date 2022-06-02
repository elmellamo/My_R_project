package com.example.myrproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MySecondAdapter extends RecyclerView.Adapter<MySecondAdapter.ViewHolder>{
    private ArrayList<String> mRItems;
    private Context mContext;
    private RecipeDB mRecipeDB;
    public static String foodname;
    //생성자 Alt + insert control+a enter


    public MySecondAdapter(ArrayList<String> rItems, Context mContext) {
        this.mRItems = rItems;
        this.mContext = mContext;
        mRecipeDB = new RecipeDB(mContext);
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
    }

    @Override
    public int getItemCount() {
        return mRItems.size();
    }//recycler view

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView recipe_title;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recipe_title = itemView.findViewById(R.id.recipe_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int currentPos = getAdapterPosition();// 현재 리스트 클릭한 아이템위치
                    String rItem = mRItems.get(currentPos);//아이템 정보 가져온다
                    TextView recipe_title = view.findViewById(R.id.recipe_title);
                    foodname = recipe_title.getText().toString();

                    String[] strChoiceItems = {"수정하기","삭제하기"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("원하는 작업을 선택해주세요");
                    builder.setItems(strChoiceItems, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int position) {//position을 의미
                            if(position == 0) {
                                Intent intent = new Intent(mContext, AddRecipe.class);
                                mContext.startActivity(intent);
                            }else if(position == 1){
                                //삭제하기
                                mRecipeDB.DeleteCookName(foodname);
                                notifyItemRemoved(currentPos);
                                Toast.makeText(mContext, "목록이 제거 되었습니다", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.show();
                }
            });
        }
    }
}


