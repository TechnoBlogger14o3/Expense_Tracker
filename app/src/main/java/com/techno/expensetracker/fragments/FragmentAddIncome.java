package com.techno.expensetracker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.techno.expensetracker.R;


public class FragmentAddIncome extends CoreFragment {

    private View view;
    private TextView txtSalary;
    private Button btnVerifyAndProceed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_income, container, false);
        hideToolBar();
        showBottomBar();
        initView();
        return view;
    }

    private void initView() {
        txtSalary = view.findViewById(R.id.txtSalary);
        txtSalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentAddIncomeDetail fragmentAddIncomeDetail = new FragmentAddIncomeDetail();
                mActivity.callFragment(fragmentAddIncomeDetail, false);
            }
        });
    }
}


