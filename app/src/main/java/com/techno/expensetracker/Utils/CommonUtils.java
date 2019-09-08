package com.techno.expensetracker.Utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class CommonUtils {

    public static void hideKeyBoard(Context context, View view) {
        try {
            InputMethodManager imm = (InputMethodManager) context
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
        }
    }

    public static void hideKeyBoard(Activity activity) {
        try {
            if (activity.getCurrentFocus() != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) activity
                        .getSystemService(activity.INPUT_METHOD_SERVICE);
                inputMethodManager
                        .hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    public static void showKeyBoard(Context context, View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) context
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInputFromWindow(
                    view.getApplicationWindowToken(),
                    InputMethodManager.SHOW_FORCED,
                    0);
        } catch (Exception e) {
        }
    }

    public static float getHeight(Activity context) {
        float height = 0;
        try {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            context.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            height = displaymetrics.heightPixels
                    / context.getResources().getDisplayMetrics().density;
            String test = "";
        } catch (Exception e) {
        }
        return height;
    }

    public static float getWidth(Activity context) {
        float width = 0;
        try {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            context.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            width = displaymetrics.widthPixels / context.getResources().getDisplayMetrics().density;
            String test = "";
        } catch (Exception e) {
        }
        return width;
    }

}
