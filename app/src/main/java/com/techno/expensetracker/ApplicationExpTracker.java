package com.techno.expensetracker;

import android.app.Application;

import com.techno.expensetracker.Utils.Constants;

public class ApplicationExpTracker extends Application {

    private static ApplicationExpTracker mSelf;

    public ApplicationExpTracker() {
        mSelf = this;
    }

    public static ApplicationExpTracker getInstance() {
        return mSelf;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Constants.IS_TABLET = getResources().getBoolean(R.bool.isTablet);
    }
}
