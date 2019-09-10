package com.techno.expensetracker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.techno.expensetracker.R;


public class FragmentSuccess extends CoreFragment {

    private View view;
    private TextView txtSkip;
    private Button btnGetOTP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_registered, container, false);
        hideToolBar();
        hideBottomBar();
        initView();
        return view;
    }

    private void initView() {

        txtSkip = view.findViewById(R.id.txtSkip);
        btnGetOTP = view.findViewById(R.id.btnGetOTP);

        btnGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentBudgets fragmentBudgets = new FragmentBudgets();
                mActivity.callFragment(fragmentBudgets, false);
            }
        });

        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentSetIncomeOrExpense fragmentSetIncomeOrExpense = new FragmentSetIncomeOrExpense();
                mActivity.callFragment(fragmentSetIncomeOrExpense, false);
            }
        });


    }
}


