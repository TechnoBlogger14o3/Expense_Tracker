package com.techno.expensetracker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.techno.expensetracker.R;


public class FragmentCategories extends CoreFragment {

    private View view;
    private TextView txtTitle;
    private Button btnVerifyAndProceed;
    private FrameLayout frameLayout;
    private RadioGroup radioGroupCategories;
    private RadioButton btn_expense, btn_income;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_categories, container, false);
        hideBottomBar();
        hideToolBar();
        initView();

        FragmentAddExpense fragment1 = new FragmentAddExpense();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameIncomeExpense, fragment1);
        fragmentTransaction.commit();
        txtTitle.setText("Add Expense");
        return view;
    }

    private void initView() {
        frameLayout = view.findViewById(R.id.frameIncomeExpense);
        txtTitle = view.findViewById(R.id.txtTitle);
        radioGroupCategories = view.findViewById(R.id.radioGroupCategories);
        btn_expense = view.findViewById(R.id.btn_expense);
        btn_income = view.findViewById(R.id.btn_income);

        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.onBackPressed();
            }
        });

        radioGroupCategories.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (btn_expense.isChecked()) {
                    FragmentAddExpense fragment1 = new FragmentAddExpense();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameIncomeExpense, fragment1);
                    fragmentTransaction.commit();
                    txtTitle.setText("Add Expense");
                }
                if (btn_income.isChecked()) {
                    FragmentAddIncome fragment1 = new FragmentAddIncome();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameIncomeExpense, fragment1);
                    fragmentTransaction.commit();
                    txtTitle.setText("Add Income");
                }
            }
        });



    }
}


