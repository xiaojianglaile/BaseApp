package com.jimmy.common.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Jimmy on 2016/8/30 0030.
 */
public enum ToastUtils {

    INSTANCE;
    Toast mToast;

    public void showShortToast(Context context, String text) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void showShortToast(Context context, int resId) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void showLongToast(Context context, String text) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        mToast.show();
    }

    public void showLongToast(Context context, int resId) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public void showToast(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

}
