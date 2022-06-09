package com.example.myrproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    private ArrayList<MyRItem> mRItems;
    private Context mContext;
    private RecipeDB mRecipeDB;
    //생성자 Alt + insert control+a enter

    public interface OnListItemSelectedInterface {
        void onItemSelected(View v, int position);
    }
    private OnListItemSelectedInterface mListener;
    private SparseBooleanArray mSelectedItems = new SparseBooleanArray(0);

    public CustomAdapter(ArrayList<MyRItem> rItems, Context mContext) {
        this.mRItems = rItems;
        this.mContext = mContext;
        mRecipeDB = new RecipeDB(mContext);
        //this.mListener = listener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_r_list_child,parent,false);
        return new ViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.child_title.setText(mRItems.get(position).getName());
        String cnt = mRItems.get(position).getCnt();
        if((int)Double.parseDouble(cnt)-Double.parseDouble(cnt)==0){
            cnt = Integer.toString((int)Double.parseDouble(cnt));
        }
        holder.child_cnt.setText(cnt);
        holder.child_unit.setText(mRItems.get(position).getUnit());
        holder.itemView.setSelected(isItemSelected(position));
    }

    @Override
    public int getItemCount() {
        return mRItems.size();
    }//recycler view

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView child_title;
        private TextView child_cnt;
        private TextView child_unit;
        private TextView buyend;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            child_title = itemView.findViewById(R.id.child_title);
            child_cnt = itemView.findViewById(R.id.child_cnt);
            child_unit = itemView.findViewById(R.id.child_unit);
            buyend = itemView.findViewById(R.id.buyend);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int currentPos = getAdapterPosition();// 현재 리스트 클릭한 아이템위치
                    MyRItem rItem = mRItems.get(currentPos);//아이템 정보 가져온다
                    //toggleItemSelected(currentPos);
                    //mListener.onItemSelected(view,currentPos);

                    if(MainActivity.tabtype!=2){
                        String[] strChoiceItems = {"수정하기","삭제하기"};
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setTitle("원하는 작업을 선택해주세요");
                        builder.setItems(strChoiceItems, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int position) {//position을 의미
                                if(position == 0) {
                                    // 수정하기
                                    Dialog dialog = new Dialog(mContext, android.R.style.Theme_Material_Light_Dialog);
                                    dialog.setContentView(R.layout.dialog_edit);//뷰가 연결되었으므로 이 레이아웃에서 find view by id사용 가능
                                    //그냥 find가 아니라 dialog.~해야 한다

                                    //커스텀 다이얼로그
                                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                    dialog.setCanceledOnTouchOutside(false);

                                    //다이얼로그 크기 조절하기
                                    WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
                                    params.width = WindowManager.LayoutParams.MATCH_PARENT;
                                    params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                                    dialog.getWindow().setAttributes((WindowManager.LayoutParams) params);


                                    TextView tv_name = dialog.findViewById(R.id.tv_name);
                                    EditText et_cnt = dialog.findViewById(R.id.et_cnt);
                                    EditText et_unit = dialog.findViewById(R.id.et_unit);
                                    Button btn_ok = dialog.findViewById(R.id.btn_ok);

                                    tv_name.setText(rItem.getName());
                                    et_cnt.setText(rItem.getCnt());
                                    et_unit.setText(rItem.getUnit());



                                    btn_ok.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            //수정시나리오
                                            //update table
                                            int id = rItem.getId();
                                            String name = rItem.getName();
                                            String cnt = et_cnt.getText().toString();
                                            String unit = et_unit.getText().toString();
                                            String currentTime = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss").format(new Date());//현재 시간 연월일시분초 받아오기
                                            String beforeTime = rItem.getWriteDate();//이전에 저장된 시간

                                            if(!isStringDouble(cnt)){
                                                Toast.makeText(mContext, "숫자로 입력해주세요", Toast.LENGTH_SHORT).show();
                                            }
                                            else{
                                                mRecipeDB.UpdateCook(id, cnt,unit,currentTime,beforeTime);//입력필드에 적은 값 가져온다
                                                //UpdateTodo ctrl누르면서 클릭하면 그 함수로 이동할 수 있다

                                                //update UI
                                                rItem.setName(name);
                                                rItem.setCnt(cnt);
                                                rItem.setUnit(unit);
                                                rItem.setWriteDate(currentTime);
                                                notifyItemChanged(currentPos, rItem);//클릭한 아이템에 갱신된 아이템을 갱신
                                                dialog.dismiss();//dialog 종료
                                                Toast.makeText(mContext, "목록 수정이 완료 되었습니다.", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                    dialog.show();//필수

                                }else if(position == 1){
                                    // delete table
                                    String beforeTime = rItem.getWriteDate();
                                    mRecipeDB.DeleteCook(beforeTime);

                                    // delete UI
                                    mRItems.remove(currentPos);
                                    notifyItemRemoved(currentPos);
                                    Toast.makeText(mContext, "목록이 제거 되었습니다", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.show();
                    }
                    else{
                        if(itemView.isSelected()==true) {
                            itemView.setSelected(false);
                            child_title.setPaintFlags(0);
                            child_cnt.setPaintFlags(0);
                            child_unit.setPaintFlags(0);
                            buyend.setVisibility(View.INVISIBLE);
                        }
                        else {
                            itemView.setSelected(true);
                            child_title.setPaintFlags(child_title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            child_cnt.setPaintFlags(child_title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            child_unit.setPaintFlags(child_title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            buyend.setVisibility(View.VISIBLE);
                        }
                    }
                }
            });


        }
        public boolean isStringDouble(String s) {
            try {
                Double.parseDouble(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
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
}
