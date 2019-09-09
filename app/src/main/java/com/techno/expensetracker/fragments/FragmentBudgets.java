package com.techno.expensetracker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.techno.expensetracker.R;


public class FragmentBudgets extends CoreFragment {

    private View view;
    private TextView txtSkip;
    private Button btnVerifyAndProceed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_budgets, container, false);
        hideToolBar();
        hideBottomBar();
        initView();
        return view;
    }

    private void initView() {

        btnVerifyAndProceed = view.findViewById(R.id.btnVerifyAndProceed);

        btnVerifyAndProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentProfiles fragmentProfiles = new FragmentProfiles();
                mActivity.callFragment(fragmentProfiles, true);
            }
        });
    }
}


