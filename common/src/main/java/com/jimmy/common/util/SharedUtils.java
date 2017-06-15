package com.jimmy.common.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/5/24.
 */

public class SharedUtils {

    private static final String FILE_NAME = "data";

    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void putLong(Context context, String key, long value) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void putFloat(Context context, String key, float value) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key, String dfValue) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getString(key, dfValue);
    }

    public static int getInt(Context context, String key, int dfValue) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getInt(key, dfValue);
    }

    public static long getLong(Context context, String key, long dfValue) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getLong(key, dfValue);
    }

    public static boolean getBoolean(Context context, String key, boolean dfValue) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getBoolean(key, dfValue);
    }

    public static float getFloat(Context context, String key, float dfValue) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getFloat(key, dfValue);
    }

    public static String getString(Context context, String key) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getString(key, null);
    }

    public static int getInt(Context context, String key) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getInt(key, 0);
    }

    public static long getLong(Context context, String key) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getLong(key, 0L);
    }

    public static boolean getBoolean(Context context, String key) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getBoolean(key, false);
    }

    public static float getFloat(Context context, String key) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getFloat(key, 0.0f);
    }

    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }

    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }

}
