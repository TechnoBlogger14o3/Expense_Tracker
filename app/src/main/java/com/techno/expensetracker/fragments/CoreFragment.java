package com.techno.expensetracker.fragments;


import android.content.Context;

import com.techno.expensetracker.Activities.MainActivity;

import androidx.fragment.app.Fragment;

public class CoreFragment extends Fragment {

    protected Context mContext = null;
    protected MainActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (MainActivity) context;
        this.mContext = mActivity;
    }

    public void showToolBar() {
        if (mActivity != null) {
            mActivity.showToolBar();
        }
    }

    public void hideToolBar() {
        if (mActivity != null) {
            mActivity.hideToolBar();
        }
    }

    public void showBottomBar() {
        if (mActivity != null) {
            mActivity.showBottomBar();
        }
    }

    public void hideBottomBar() {
        if (mActivity != null) {
            mActivity.hideBottomBar();
        }
    }

    public void setDisplayShowTitleEnabled(boolean enable) {
        if (mActivity != null) {
            mActivity.setDisplayShowTitleEnabled(enable);
        }
    }
}
