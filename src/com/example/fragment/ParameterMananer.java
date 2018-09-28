package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class ParameterMananer {
    
	private static final String TAG = "ParameterMananer";
	private Context mContext;
	
	private static final int LIST_TYPE_SATELLITE = 0;
	private static final int LIST_TYPE_TRANSPINDER = 1;
	
	public ParameterMananer(Context context) {
		this.mContext = context;
	}
	
	public List<String> getSatelliteList() {
		List<String> list = new ArrayList<String>();
		//need to add get function, debug as below
		list.add("001 013.OE Ku_HOTBIRD 6");
		list.add("002 013.OE Ku_HOTBIRD 6");
		list.add("003 013.OE Ku_HOTBIRD 6");
		list.add("004 013.OE Ku_HOTBIRD 6");
		list.add("005 013.OE Ku_HOTBIRD 6");
		list.add("006 013.OE Ku_HOTBIRD 6");
		list.add("007 013.OE Ku_HOTBIRD 6");
		return list;
	}
	
	public List<String> getTransponderList() {
		List<String> list = new ArrayList<String>();
		//need to add get function, debug as below
		list.add("001 10723 H 29900008");
		list.add("001 10723 H 29900008");
		list.add("001 10723 H 29900008");
		list.add("001 10723 H 29900008");
		list.add("001 10723 H 29900008");
		list.add("001 10723 H 29900008");
		list.add("001 10723 H 29900008");
		return list;
	}
	
	public List<String> getItemList(int type) {
		if (type == LIST_TYPE_SATELLITE) {
			return getSatelliteList();
		} else if (type == LIST_TYPE_TRANSPINDER) {
			return getTransponderList();
		} else {
			return new ArrayList<String>();
		}
	}
	
	public String getParameterListTitle(int type, int position) {
		String title = null;
		//need to add get function, debug as below
		title = "Ku_HOTBIRO6,7A,8";
		return title;
	}
	
	public List<String> getParameterListType(int type, int position) {
		List<String> list = new ArrayList<String>();
		//need to add get function, debug as below
		list.add("LNB Type");
		list.add("LNB Power");
		list.add("22KHZ");
		list.add("Toneburst");
		list.add("DisEqC1.0");
		list.add("DisEqC1.1");
		list.add("Motor");
		return list;
	}
	
	public List<String> getParameterListValue(int type, int position) {
		List<String> list = new ArrayList<String>();
		//need to add get function, debug as below
		list.add("09750/10600");
		list.add("13/18V");
		list.add("Auto");
		list.add("BurstB");
		list.add("LNB2");
		list.add("LNB6");
		list.add("None");
		return list;
	}
}
