package com.example.fragment;

import java.util.LinkedList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    private LinkedList<ItemDetail> mData;
    private Context mContext;

    public ItemAdapter(LinkedList<ItemDetail> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    public void reFill(LinkedList<ItemDetail> data) {
    	mData.clear();
    	mData.addAll(data);
        notifyDataSetChanged();
    }
    
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	ViewHolder holder = null;
    	if (convertView == null) {
    		convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
    		holder = new ViewHolder();
    		holder.checkbox1 = (CheckBox) convertView.findViewById(R.id.checkbox_first);
    		holder.textview2 = (TextView) convertView.findViewById(R.id.textview_second);
    		holder.textview3 = (TextView) convertView.findViewById(R.id.textview_third);
    		convertView.setTag(holder);
    	} else{
            holder = (ViewHolder) convertView.getTag();
        }

        int editstatus = mData.get(position).getEditStatus();
        if (editstatus == ItemDetail.NONE_EDIT) {
        	holder.checkbox1.setVisibility(View.INVISIBLE);
        } else {
        	holder.checkbox1.setVisibility(View.VISIBLE);
        	if (editstatus == ItemDetail.SELECT_EDIT) {
        		holder.checkbox1.setSelected(true);
        	} else {
        		holder.checkbox1.setSelected(false);
        	}
        }
        holder.textview2.setText(mData.get(position).getFirstText());
        holder.textview3.setText(mData.get(position).getSecondText());
        return convertView;
    }
    
    public static class ItemDetail {
    	private int mEditStatus = 0;
        private String mFirstText;
        private String mSecondText;

        public static final int NONE_EDIT = 0;
        public static final int SELECT_EDIT = 1;
        public static final int NOT_SELECT_EDIT = 2;
        
        public ItemDetail() {
        }

        public ItemDetail(int editstatus, String first, String second) {
            this.mEditStatus = editstatus;
            this.mFirstText = first;
            this.mSecondText = second;
        }

        public int getEditStatus() {
            return mEditStatus;
        }

        public String getFirstText() {
            return mFirstText;
        }

        public String getSecondText() {
            return mSecondText;
        }

        public void setEditStatus(int editstatus) {
            this.mEditStatus = editstatus;
        }

        public void setFirstText(String first) {
            this.mFirstText = first;
        }

        public void setSecondText(String second) {
            this.mSecondText = second;
        }
    }
    
    public class ViewHolder{
    	CheckBox checkbox1;
        TextView textview2;
        TextView textview3;
    }
}