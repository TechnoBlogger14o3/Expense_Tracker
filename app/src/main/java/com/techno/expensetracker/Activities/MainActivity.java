package com.techno.expensetracker.Activities;


import android.os.Bundle;

import com.techno.expensetracker.Activities.BaseActivity;
import com.techno.expensetracker.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDisplayHomeAsUpEnabled(false);
        setHomeButtonEnabled(false);
    }
}
