package com.techno.expensetracker.fragments;


import android.content.Context;

import androidx.fragment.app.Fragment;

import com.techno.expensetracker.Activities.MainActivity;

public class CoreFragment extends Fragment {

    protected Context mContext = null;
    protected MainActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) context;
        this.mContext = mActivity;
    }

    @Override
    public void onResume() {
        super.onResume();
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
}
