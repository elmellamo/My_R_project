package com.example.myrproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
        import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpandableListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int HEADER = 0;
    public static final int CHILD = 1;

    private ArrayList<Item> data;
    public static Context mContext;
    private DBHelper mDBHelper;

    public ExpandableListAdapter(ArrayList<Item> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
        this.mDBHelper = new DBHelper(mContext);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View view = null;
        Context context = parent.getContext();
        switch (type) {
            case HEADER:
                LayoutInflater inflaterHeader = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflaterHeader.inflate(R.layout.my_r_list_header, parent, false);
                ListHeaderViewHolder header = new ListHeaderViewHolder(view);
                return header;
            case CHILD:
                LayoutInflater inflaterChild = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflaterChild.inflate(R.layout.my_r_list_child, parent, false);
                ListChildViewHolder child = new ListChildViewHolder(view);
                return child;

        }
        return null;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Item item = data.get(position);
        switch (item.type) {
            case HEADER:
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder;
                itemController.refferalItem = item;
                itemController.header_title.setText(item.text);
                if (item.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.expand);
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.shrink);
                }
                itemController.btn_expand_toggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.invisibleChildren == null) {
                            item.invisibleChildren = new ArrayList<Item>();
                            int count = 0;
                            int pos = data.indexOf(itemController.refferalItem);
                            while (data.size() > pos + 1 && data.get(pos + 1).type == CHILD) {
                                item.invisibleChildren.add(data.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.expand);
                        } else {
                            int pos = data.indexOf(itemController.refferalItem);
                            int index = pos + 1;
                            for (Item i : item.invisibleChildren) {
                                data.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.shrink);
                            item.invisibleChildren = null;
                        }
                    }
                });
                break;
            case CHILD:
                final ListChildViewHolder itemController1 = (ListChildViewHolder) holder;
                itemController1.refferalItem = item;
                itemController1.child_title.setText(item.text);
                itemController1.child_cnt.setText(item.itemcnt);
                itemController1.child_unit.setText(item.itemunit);

                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }


    @Override
    public int getItemCount() {
            return data.size();
    }

    private class ListHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView header_title;
        public ImageView btn_expand_toggle;
        public Item refferalItem;

        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            header_title = (TextView) itemView.findViewById(R.id.header_title);
            btn_expand_toggle = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
        }
    }
    private class ListChildViewHolder extends RecyclerView.ViewHolder {
        public TextView child_title;
        public TextView child_cnt;
        public TextView child_unit;
        public Item refferalItem;

        public ListChildViewHolder(View itemView) {
            super(itemView);
            child_title = (TextView) itemView.findViewById(R.id.child_title);
            child_cnt = itemView.findViewById(R.id.child_cnt);
            child_unit = itemView.findViewById(R.id.child_unit);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int curPos = getAdapterPosition();
                    Item rItem = data.get(curPos);
                    String[] strChoiceItems = {"????????????", "????????????"};

                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("????????? ????????? ??????????????????");
                    builder.setItems(strChoiceItems, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int position) {
                            if(position == 0) {
                                // ????????????
                                Dialog dialog = new Dialog(mContext, android.R.style.Theme_Material_Light_Dialog);
                                dialog.setContentView(R.layout.dialog_edit);//?????? ????????????????????? ??? ?????????????????? find view by id?????? ??????
                                //?????? find??? ????????? dialog.~?????? ??????

                                //????????? ???????????????
                                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                dialog.setCanceledOnTouchOutside(false);

                                //??????????????? ?????? ????????????
                                WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
                                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                                dialog.getWindow().setAttributes((WindowManager.LayoutParams) params);

                                TextView tv_name = dialog.findViewById(R.id.tv_name);
                                EditText et_cnt = dialog.findViewById(R.id.et_cnt);
                                EditText et_unit = dialog.findViewById(R.id.et_unit);
                                Button btn_ok = dialog.findViewById(R.id.btn_ok);

                                tv_name.setText(rItem.getTtext());
                                et_cnt.setText(rItem.getCcnt());
                                et_unit.setText(rItem.getUunit());

                                btn_ok.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        //??????????????????
                                        //update table
                                        int _id = rItem.getId();
                                        String type = rItem.getIitemtype();
                                        String name = rItem.getTtext();
                                        String cnt = et_cnt.getText().toString();
                                        String unit = et_unit.getText().toString();

                                        String currentTime = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss").format(new Date());//?????? ?????? ?????????????????? ????????????
                                        String beforeTime = rItem.getWritedate();//????????? ????????? ??????
                                        if(!isStringDouble(cnt)){
                                            //?????????
                                            Toast.makeText(mContext, "????????? ??????????????????.", Toast.LENGTH_SHORT).show();
                                        }else if(Double.parseDouble(cnt)<=0){
                                            Toast.makeText(mContext, "????????? ????????? ??????????????????.", Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            mDBHelper.UpdateTodo(_id,cnt,unit, currentTime,beforeTime);//??????????????? ?????? ??? ????????????
                                            //UpdateTodo ctrl???????????? ???????????? ??? ????????? ????????? ??? ??????
                                            //update UI
                                            rItem.setIitemtype(type);
                                            rItem.setTtext(name);
                                            rItem.setCcnt(cnt);
                                            rItem.setUunit(unit);
                                            rItem.setWritedate(currentTime);
                                            notifyItemChanged(curPos, rItem);//????????? ???????????? ????????? ???????????? ??????
                                            dialog.dismiss();//dialog ??????
                                            Toast.makeText(mContext, "?????? ????????? ?????? ???????????????.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                dialog.show();//??????

                            }else if(position == 1){
                                // delete table
                                String beforeTime = rItem.getWritedate();
                                String type = rItem.getIitemtype();
                                for(Item x: data){
                                    if(x.getCcnt().equals("??????")&&x.getIitemtype().equals(type)){
                                        int pos = data.indexOf(x);
                                        String Text = x.getTtext().replaceAll("[^0-9]", "");
                                        x.setTtext(type+"("+Integer.toString(Integer.parseInt(Text)-1)+")");
                                        data.set(pos,x);
                                        notifyItemChanged(pos);
                                    }
                                }
                                mDBHelper.deleteTodo(beforeTime);
                                // delete UI
                                data.remove(curPos);
                                notifyItemRemoved(curPos);
                                Toast.makeText(mContext, "????????? ?????? ???????????????", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.show();
                }
            });
        }
    }

    public boolean isStringDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static class Item {
        public int id;
        public int type;
        public String text;
        public String itemtype;
        public String itemcnt;
        public String itemunit;
        private String writedate;
        public List<Item> invisibleChildren;

        public Item() {
        }

        public Item(int id, int type,String itemtype, String text,String itemcnt, String itemunit,String writedate) {
            this.id = id;
            this.type = type;
            this.itemtype = itemtype;
            this.text = text;
            this.itemcnt = itemcnt;
            this.itemunit = itemunit;
            this.writedate = writedate;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public int getTtype() { return type; }
        public void setTtype(int type) { this.type = type; }

        public String getIitemtype(){return itemtype;}
        public void setIitemtype(String itemtype){this.itemtype = itemtype;}

        public String getTtext(){return text;}
        public void setTtext(String text){this.text = text;}

        public String getCcnt(){return itemcnt;}
        public void setCcnt(String itemcnt){this.itemcnt = itemcnt;}

        public String getUunit(){return itemunit;}
        public void setUunit(String itemunit){this.itemunit = itemunit;}

        public String getWritedate() {
            return writedate;
        }
        public void setWritedate(String writedate) {
            this.writedate = writedate;
        }
    }
}

