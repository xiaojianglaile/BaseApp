package com.jimmy.common.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.jimmy.common.base.app.TemplateActivity;

/**
 * Created by Jimmy on 2016/8/26 0026.
 */
public class TemplateUtils {

    public static void startTemplate(Context context, String name, String title) {
        startTemplate(context, name, title, -1);
    }

    public static void startTemplate(Context context, String name, String title, int rightResId) {
        startTemplate(context, name, title, -1, rightResId);
    }

    public static void startTemplate(Context context, String name, String title, int leftResId, int rightResId) {
        startTemplate(context, name, title, leftResId, rightResId, null);
    }

    public static void startTemplate(Context context, String name, String title, String rightText) {
        startTemplate(context, name, title, -1, rightText);
    }

    public static void startTemplate(Context context, String name, String title, int leftResId, String rightText) {
        startTemplate(context, name, title, leftResId, rightText, null);
    }

    public static void startTemplate(Context context, String name, String title, Bundle params) {
        startTemplate(context, name, title, -1, params);
    }

    public static void startTemplate(Context context, String name, String title, int rightResId, Bundle params) {
        startTemplate(context, name, title, -1, rightResId, params);
    }

    public static void startTemplate(Context context, String name, String title, String rightText, Bundle params) {
        startTemplate(context, name, title, -1, rightText, params);
    }

    public static void startTemplate(Context context, String name, String title, int leftResId, int rightResId, Bundle params) {
        context.startActivity(new Intent(context, TemplateActivity.class)
                .putExtra(TemplateActivity.NAME, name)
                .putExtra(TemplateActivity.TITLE, title)
                .putExtra(TemplateActivity.PARAMS, params)
                .putExtra(TemplateActivity.LEFT_RESOURCE_ID, leftResId)
                .putExtra(TemplateActivity.RIGHT_RESOURCE_ID, rightResId));
    }

    public static void startTemplate(Context context, String name, String title, int leftResId, String rightText, Bundle params) {
        context.startActivity(new Intent(context, TemplateActivity.class)
                .putExtra(TemplateActivity.NAME, name)
                .putExtra(TemplateActivity.TITLE, title)
                .putExtra(TemplateActivity.PARAMS, params)
                .putExtra(TemplateActivity.LEFT_RESOURCE_ID, leftResId)
                .putExtra(TemplateActivity.RIGHT_RESOURCE_ID, -1)
                .putExtra(TemplateActivity.RIGHT_TEXT, rightText));
    }

}
