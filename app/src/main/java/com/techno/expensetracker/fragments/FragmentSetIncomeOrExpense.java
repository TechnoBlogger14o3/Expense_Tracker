package com.techno.expensetracker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.techno.expensetracker.R;


public class FragmentSetIncomeOrExpense extends CoreFragment {

    private View view;
    private TextView txtSetIncomeOrExpense;
    private Button btnNext;
    private RadioGroup radioGroupCategories;
    private RadioButton btn_expense, btn_income;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_set_income_or_expense, container, false);
        hideToolBar();
        initView();
        return view;
    }

    private void initView() {
        radioGroupCategories = view.findViewById(R.id.radioGroupCategories);
        txtSetIncomeOrExpense = view.findViewById(R.id.txtSetIncomeOrExpense);
        btnNext = view.findViewById(R.id.btnNext);
        btn_expense = view.findViewById(R.id.btn_expense);
        btn_income = view.findViewById(R.id.btn_income);

        txtSetIncomeOrExpense.setText(getResources().getString(R.string.set_my_income));
        radioGroupCategories.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (btn_expense.isChecked()) {
                    txtSetIncomeOrExpense.setText(getResources().getString(R.string.set_my_expense));
                }
                if (btn_income.isChecked()) {
                    txtSetIncomeOrExpense.setText(getResources().getString(R.string.set_my_income));
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentBudgets fragmentBudgets = new FragmentBudgets();
                mActivity.callFragment(fragmentBudgets, false);
            }
        });

    }
}


