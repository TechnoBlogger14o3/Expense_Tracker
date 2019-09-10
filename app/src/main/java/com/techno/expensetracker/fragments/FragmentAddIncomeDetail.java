package com.techno.expensetracker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.techno.expensetracker.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentAddIncomeDetail extends CoreFragment {

    private View view;
    private TextView txtSkip;
    private Button btnVerifyAndProceed;
    private Spinner spinner1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_income_details, container, false);
        hideToolBar();
        showBottomBar();
        initView();
        return view;
    }

    private void initView() {
        spinner1 = view.findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Salary");
        list.add("Gift");
        list.add("Lottery");
        list.add("Sale");
        list.add("Refund");
        list.add("Other");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mActivity,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }


    public void addListenerOnSpinnerItemSelection() {
        spinner1.setOnItemSelectedListener(new CustomItemSelectedListener());
    }

    // get the selected dropdown list value
}

 class CustomItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}

