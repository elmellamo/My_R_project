package com.example.myrproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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

//recycler view (재활용)

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    private ArrayList<refrigeitem> mrefrigeitem;
    private Context mContext;
    private DBHelper mDBHelper;
    //생성자 Alt + insert control+a enter


    public CustomAdapter(ArrayList<refrigeitem> refrigeitems, Context mContext) {
        this.mrefrigeitem = refrigeitems;
        this.mContext = mContext;
        mDBHelper = new DBHelper(mContext);
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        //item list에 대한 view 하나하나를 연결
        return new ViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        //holder.tv_title.setText(mrefrigeitem.get(position).getLoc());
        //holder.tv_content.setText(mrefrigeitem.get(position).getType());
        //holder.tv_writeDate.setText(mrefrigeitem.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return mrefrigeitem.size();
    }//recycler view

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private TextView tv_content;
        private TextView tv_writeDate;
        private Button edit_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_writeDate = itemView.findViewById(R.id.tv_date);
            edit_btn = itemView.findViewById(R.id.edit_btn);

            edit_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int curPos = getAdapterPosition();// 현재 리스트 클릭한 아이템위치
                    refrigeitem refrigeitems = mrefrigeitem.get(curPos);//아이템 정보 가져온다
                    int id = refrigeitems.getId();
                    Dialog dialog = new Dialog(mContext, android.R.style.Theme_Material_Light_Dialog);
                    dialog.setContentView(R.layout.dialog_edit);//뷰가 연결되었으므로 이 레이아웃에서 find view by id사용 가능
                    EditText et_cnt = dialog.findViewById(R.id.et_cnt);//그냥 find가 아니라 dialog.~해야 한다
                    EditText et_unit = dialog.findViewById(R.id.et_unit);
                    Button btn_ok = dialog.findViewById(R.id.btn_ok);

                    et_cnt.setText(refrigeitems.getCnt());
                    et_unit.setText(refrigeitems.getUnit());

                    btn_ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //수정시나리오
                            //update table

                            int cnt = Integer.parseInt(et_cnt.getText().toString());//int형은 이렇게 바꾼다
                            String unit = et_unit.getText().toString();

                            mDBHelper.UpdateItem(cnt, unit, id);//입력필드에 적은 값 가져온다
                            //UpdateTodo ctrl누르면서 클릭하면 그 함수로 이동할 수 있다

                            //update UI
                            refrigeitems.setCnt(cnt);
                            refrigeitems.setUnit(unit);
                            notifyItemChanged(curPos, refrigeitems);//클릭한 아이템에 갱신된 아이템을 갱신
                            dialog.dismiss();//dialog 종료
                            Toast.makeText(mContext, "목록 수정이 완료 되었습니다.", Toast.LENGTH_SHORT).show();

                        }
                    });
                    dialog.show();//필수
                }
            });
        }
    }
    //액티비티에서 호출되는 함수이며, 현재 어댑터에 새로운 게시글 아이템을 전달받아 추가하는 목적이다.
    public void addItem(refrigeitem _item){
        mrefrigeitem.add(0,_item);//역순으로 add된다 최신순으로 위에 들어간다
        notifyItemInserted(0);//notify들어간건 모두 새로고침이라 보면 된다
    }
}

