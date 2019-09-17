package com.techno.expensetracker.Utils;


import android.content.Context;
import android.content.SharedPreferences;

public class CommonPreferences {

    private static SharedPreferences prefs;

    private static final String PREFS_FILE_NAME = "EXP_TRACK_PREFS";

    public static void setStringPreferences(Context context, String prefName, String Value) {
        try {
            prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(prefName, Value);
            editor.commit();
        } catch (Exception e) {

        }
    }

    public static String getStringPrefrences(Context context, String prefName) {
        prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        if (prefs.contains(prefName))
            return prefs.getString(prefName, null);
        else
            return "";
    }

    public static void setBooleanPrefrences(Context context, String prefName, boolean Value) {
        try {
            prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(prefName, Value);
            editor.commit();
        } catch (Exception e) {
        }
    }

    public static boolean getBooleanPrefrences(Context context, String prefName) {
        prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(prefName, false);
    }

    public static void setIntPrefrences(Context context, String prefName, int Value) {
        try {
            prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt(prefName, Value);
            editor.apply();
        } catch (Exception e) {
        }
    }

    public static int getIntPrefrences(Context context, String prefName) {
        prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        return prefs.getInt(prefName, 0);
    }

    public static void setLongPrefrences(Context context, String prefName, Long Value) {
        try {
            prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putLong(prefName, Value);
            editor.apply();
        } catch (Exception e) {
        }
    }

    public static Long getLongPrefrences(Context context, String prefName) {
        prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        return prefs.getLong(prefName, 0);
    }
}