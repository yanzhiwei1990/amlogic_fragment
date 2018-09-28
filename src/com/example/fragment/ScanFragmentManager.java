package com.example.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Handler;

public class ScanFragmentManager {
    private static final String TAG = "ScanFragmentManager";
	private static final String FIRST_BACKSTACK_RECORD_NAME = "0";
	private final Activity mActivity;
    private final FragmentManager mFragmentManager;
    private int mFragmentCount;
    private long mShowDurationMillis = 100000;
    private final Handler mHandler = new Handler();
    
    private final Runnable mHideAllRunnable = new Runnable() {
        @Override
        public void run() {
        	hideAll();
        	mActivity.finish();
        }
    };
    
    public void scheduleHideAll() {
        mHandler.removeCallbacks(mHideAllRunnable);
        if (mShowDurationMillis > 0) {
            mHandler.postDelayed(mHideAllRunnable, mShowDurationMillis);
        } else {
            mHandler.removeCallbacks(mHideAllRunnable);
        }
    }
    
    public ScanFragmentManager(Activity activity) {
        mActivity = activity;
        mFragmentManager = mActivity.getFragmentManager();
    }
    
    public void hideAll() {
        if (mFragmentCount == 0) {
            return;
        }

        mFragmentManager.popBackStack(
        		FIRST_BACKSTACK_RECORD_NAME, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        mFragmentCount = 0;

        if (mHideAllRunnable != null) {
        	mHideAllRunnable.run();
        }
    }
    
    public void show(Fragment sideFragment) {
        boolean isFirst = (mFragmentCount == 0);
        FragmentTransaction ft = mFragmentManager.beginTransaction();

        ft.replace(R.id.container, sideFragment)
                .addToBackStack(Integer.toString(mFragmentCount))
                .commit();
        mFragmentCount++;

        scheduleHideAll();
    }

    public void popSideFragment() {
        if (!isActive()) {
            return;
        } else if (mFragmentCount == 1) {
            // Show closing animation with the last fragment.
        	hideAll();
            return;
        }
        mFragmentManager.popBackStack();
        mFragmentCount--;
    }

    public boolean isActive() {
        return mFragmentCount != 0;
    }
}