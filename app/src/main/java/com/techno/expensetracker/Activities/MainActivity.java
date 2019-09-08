package com.techno.expensetracker.Activities;


import android.os.Bundle;

import com.techno.expensetracker.Activities.BaseActivity;
import com.techno.expensetracker.R;
import com.techno.expensetracker.fragments.FragmentOTP;
import com.techno.expensetracker.fragments.HomeDashBoardFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDisplayHomeAsUpEnabled(false);
        setHomeButtonEnabled(false);
        FragmentOTP fragmentOTP = new FragmentOTP();
        callFragment(fragmentOTP, true );
    }
}
