package com.techno.expensetracker;

import android.app.Application;

import com.techno.expensetracker.Utils.Constants;

public class ExpTrackerAppController extends Application {

    private static ExpTrackerAppController mSelf;

    public ExpTrackerAppController() {
        mSelf = this;
    }

    public static ExpTrackerAppController getInstance() {
        return mSelf;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Constants.IS_TABLET = getResources().getBoolean(R.bool.isTablet);
    }
}
