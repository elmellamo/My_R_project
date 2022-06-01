package com.example.myrproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;
        import java.util.List;

public class ExpandableListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int HEADER = 0;
    public static final int CHILD = 1;

    private ArrayList<Item> data;
    private Context mContext;
    private DBHelper mDBhelper;

    public ExpandableListAdapter(ArrayList<Item> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
        this.mDBhelper = new DBHelper(mContext);
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
                    String[] strChoiceItems = {"수정하기", "삭제하기"};

                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("원하는 작업을 선택해주세요");
                    builder.setItems(strChoiceItems, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();
                }
            });
        }
    }

    public static class Item {
        public int type;
        public String text;
        public String itemtype;
        public String itemcnt;
        public String itemunit;
        public List<Item> invisibleChildren;

        public Item() {
        }

        public Item(int type,String itemtype, String text,String itemcnt, String itemunit) {
            this.type = type;
            this.itemtype = itemtype;
            this.text = text;
            this.itemcnt = itemcnt;
            this.itemunit = itemunit;
        }
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
    }

    public void addItem(Item _item){
        data.add(_item);//역순으로 add된다 최신순으로 위에 들어간다
        //notifyItemInserted(0);//notify들어간건 모두 새로고침이라 보면 된다
    }
}

