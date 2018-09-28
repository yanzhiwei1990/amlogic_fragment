package com.example.fragment;

import java.util.LinkedList;

import com.example.fragment.ItemAdapter.ItemDetail;
import com.example.fragment.R.color;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ScanDishSetupFragment extends Fragment {

	private static final String TAG = "ScanDishSetupFragment";
	private ItemAdapter mItemAdapterItem = null;
	private ItemAdapter mItemAdapterOption = null;
	private ListView mListViewItem = null;
	private ListView mListViewOption = null;
	private LinkedList<ItemDetail> mItemDetailItem = new LinkedList<ItemDetail>();
	private LinkedList<ItemDetail> mItemDetailOption = new LinkedList<ItemDetail>();
	
	public static ScanDishSetupFragment newInstance() {
        return new ScanDishSetupFragment();
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_dish_setup, container, false);
		//View headView1 = inflater.inflate(R.layout.list_head, null, false);
		//View headView2 = inflater.inflate(R.layout.list_head, null, false);
		mListViewItem = (ListView) rootView.findViewById(R.id.listview_item);
		mListViewOption = (ListView) rootView.findViewById(R.id.listview_option);
		mItemDetailItem.add(new ItemDetail(1, "test0", null));
		mItemDetailItem.add(new ItemDetail(1, "test1", null));
		mItemDetailItem.add(new ItemDetail(2, "test2", null));
		mItemAdapterItem = new ItemAdapter(mItemDetailItem, getActivity());
		mListViewItem.setAdapter(mItemAdapterItem);
		mListViewItem.setLabelFor(123);
		mListViewItem.setOnItemClickListener(mOnItemClickListener);
		TextView textView1 = (TextView) rootView.findViewById(R.id.listview_item_title);
		textView1.setText("Satellite");

		mListViewItem.requestFocus();
		mListViewItem.setOnFocusChangeListener(mOnFocusChangeListener);
		mListViewItem.setOnItemSelectedListener(mOnItemSelectedListener);
		
		mItemDetailOption.add(new ItemDetail(0, "test3", "test33"));
		mItemDetailOption.add(new ItemDetail(0, "test4", "test44"));
		mItemDetailOption.add(new ItemDetail(0, "test5", "test55"));
		mItemAdapterOption = new ItemAdapter(mItemDetailOption, getActivity());
		mListViewOption.setAdapter(mItemAdapterOption);
		mListViewOption.setLabelFor(456);
		mListViewOption.setOnItemClickListener(mOnItemClickListener);
		TextView textView2 = (TextView) rootView.findViewById(R.id.listview_option_title);
		textView2.setText("Ku_NewSat2");

		mListViewOption.setSelectionAfterHeaderView();
		mListViewOption.setOnFocusChangeListener(mOnFocusChangeListener);
		mListViewOption.setOnItemSelectedListener(mOnItemSelectedListener);
		return rootView;
	}
	
	AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			Log.d(TAG, "onItemClick view = " + view.getLabelFor() + ", position = " + position + ", id = " + id);
		}
		
	};
	
	AdapterView.OnItemSelectedListener mOnItemSelectedListener = new AdapterView.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			Log.d(TAG, "onItemSelected view = " + view.getLabelFor() + ", position = " + position + ", id = " + id + ", " + mListViewItem.getSelectedItemPosition());
			//view.setBackgroundColor(color.common_focus);

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			Log.d(TAG, "onNothingSelected onNothingSelected");
		}
		
	};
	
	OnFocusChangeListener mOnFocusChangeListener = new OnFocusChangeListener() {

		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub
			Log.d(TAG, "onFocusChange view = " + v.getLabelFor() + ", hasFocus = " + hasFocus);
		}
		
	};
	
	/*public boolean dispatchKeyEvent (KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_DPAD_UP:
                    if (selectedPosition == 0)
                        return true;
                    break;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    if (selectedPosition == getAdapter().getCount() - 1)
                        return true;
                    break;
                case KeyEvent.KEYCODE_DPAD_LEFT:
                	if (mListViewItem.requestFocus()) {
                		
                        return true;
                    }
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                	if (mListViewOption.requestFocus())
                        return true;
                    break;
            }

            View selectedView = getSelectedView();
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_DPAD_UP:
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    if ( selectedView != null) {
                        clearChoosed(selectedView);
                    }
                case KeyEvent.KEYCODE_DPAD_LEFT:
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    if ( selectedView != null) {
                        setItemTextColor(selectedView, false);
                    }
                    break;
            }
        }

        return super.dispatchKeyEvent(event);
    }*/
}

