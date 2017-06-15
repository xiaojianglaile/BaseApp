package com.jimmy.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.jimmy.common.base.app.TemplateActivity;

/**
 * Created by Jimmy on 2016/8/26 0026.
 */
public class TemplateUtils {

    public static void startTemplate(Context context, Class objClass, String title) {
        startTemplate(context, objClass, title, -1);
    }

    public static void startTemplate(Context context, Class objClass, String title, int rightResId) {
        startTemplate(context, objClass, title, -1, rightResId);
    }

    public static void startTemplate(Context context, Class objClass, String title, int leftResId, int rightResId) {
        startTemplate(context, objClass, title, leftResId, rightResId, null);
    }

    public static void startTemplate(Context context, Class objClass, String title, String rightText) {
        startTemplate(context, objClass, title, -1, rightText);
    }

    public static void startTemplate(Context context, Class objClass, String title, int leftResId, String rightText) {
        startTemplate(context, objClass, title, leftResId, rightText, null);
    }

    public static void startTemplate(Context context, Class objClass, String title, Bundle params) {
        startTemplate(context, objClass, title, -1, params);
    }

    public static void startTemplate(Context context, Class objClass, String title, int rightResId, Bundle params) {
        startTemplate(context, objClass, title, -1, rightResId, params);
    }

    public static void startTemplate(Context context, Class objClass, String title, String rightText, Bundle params) {
        startTemplate(context, objClass, title, -1, rightText, params);
    }

    public static void startTemplateForResult(Activity activity, Class objClass, String title, int requestCode) {
        startTemplateForResult(activity, objClass, title, -1, requestCode);
    }

    public static void startTemplateForResult(Activity activity, Class objClass, String title, int rightResId, int requestCode) {
        startTemplateForResult(activity, objClass, title, -1, rightResId, requestCode);
    }

    public static void startTemplateForResult(Activity activity, Class objClass, String title, int leftResId, int rightResId, int requestCode) {
        startTemplateForResult(activity, objClass, title, leftResId, rightResId, null, requestCode);
    }

    public static void startTemplateForResult(Activity activity, Class objClass, String title, String rightText, int requestCode) {
        startTemplateForResult(activity, objClass, title, -1, rightText, requestCode);
    }

    public static void startTemplateForResult(Activity activity, Class objClass, String title, int leftResId, String rightText, int requestCode) {
        startTemplateForResult(activity, objClass, title, leftResId, rightText, null, requestCode);
    }

    public static void startTemplateForResult(Activity activity, Class objClass, String title, Bundle params, int requestCode) {
        startTemplateForResult(activity, objClass, title, -1, params, requestCode);
    }

    public static void startTemplateForResult(Activity activity, Class objClass, String title, int rightResId, Bundle params, int requestCode) {
        startTemplateForResult(activity, objClass, title, -1, rightResId, params, requestCode);
    }

    public static void startTemplateForResult(Activity activity, Class objClass, String title, String rightText, Bundle params, int requestCode) {
        startTemplateForResult(activity, objClass, title, -1, rightText, params, requestCode);
    }

    /**
     * 启动模板Activity
     *
     * @param context
     * @param objClass   模板Activity中Fragment键名
     * @param title      模板Activity的标题
     * @param leftResId  模板Activity左按钮资源Id
     * @param rightResId 模板Activity右按钮资源Id
     * @param params     模板Activity向Fragment传递的参数
     */
    public static void startTemplate(Context context, Class objClass, String title, int leftResId, int rightResId, Bundle params) {
        context.startActivity(new Intent(context, TemplateActivity.class)
                .putExtra(TemplateActivity.NAME, objClass)
                .putExtra(TemplateActivity.TITLE, title)
                .putExtra(TemplateActivity.PARAMS, params)
                .putExtra(TemplateActivity.LEFT_RESOURCE_ID, leftResId)
                .putExtra(TemplateActivity.RIGHT_RESOURCE_ID, rightResId));
    }

    /**
     * 启动模板Activity
     *
     * @param context
     * @param objClass  模板Activity中Fragment键名
     * @param title     模板Activity的标题
     * @param leftResId 模板Activity左按钮资源Id
     * @param rightText 模板Activity右按钮文字
     * @param params    模板Activity向Fragment传递的参数
     */
    public static void startTemplate(Context context, Class objClass, String title, int leftResId, String rightText, Bundle params) {
        context.startActivity(new Intent(context, TemplateActivity.class)
                .putExtra(TemplateActivity.NAME, objClass)
                .putExtra(TemplateActivity.TITLE, title)
                .putExtra(TemplateActivity.PARAMS, params)
                .putExtra(TemplateActivity.LEFT_RESOURCE_ID, leftResId)
                .putExtra(TemplateActivity.RIGHT_RESOURCE_ID, -1)
                .putExtra(TemplateActivity.RIGHT_TEXT, rightText));
    }

    /**
     * 启动模板Activity并对返回数据做处理
     *
     * @param activity
     * @param objClass    模板Activity中Fragment键名
     * @param title       模板Activity的标题
     * @param leftResId   模板Activity左按钮资源Id
     * @param rightResId  模板Activity右按钮资源Id
     * @param params      模板Activity向Fragment传递的参数
     * @param requestCode 模板Activity请求Code
     */
    public static void startTemplateForResult(Activity activity, Class objClass, String title, int leftResId, int rightResId, Bundle params, int requestCode) {
        activity.startActivityForResult(new Intent(activity, TemplateActivity.class)
                .putExtra(TemplateActivity.NAME, objClass)
                .putExtra(TemplateActivity.TITLE, title)
                .putExtra(TemplateActivity.PARAMS, params)
                .putExtra(TemplateActivity.LEFT_RESOURCE_ID, leftResId)
                .putExtra(TemplateActivity.RIGHT_RESOURCE_ID, rightResId), requestCode);
    }

    /**
     * 启动模板Activity并对返回数据做处理
     *
     * @param activity
     * @param objClass    模板Activity中Fragment键名
     * @param title       模板Activity的标题
     * @param leftResId   模板Activity左按钮资源Id
     * @param rightText   模板Activity右按钮文字
     * @param params      模板Activity向Fragment传递的参数
     * @param requestCode 模板Activity请求Code
     */
    public static void startTemplateForResult(Activity activity, Class objClass, String title, int leftResId, String rightText, Bundle params, int requestCode) {
        activity.startActivityForResult(new Intent(activity, TemplateActivity.class)
                .putExtra(TemplateActivity.NAME, objClass)
                .putExtra(TemplateActivity.TITLE, title)
                .putExtra(TemplateActivity.PARAMS, params)
                .putExtra(TemplateActivity.LEFT_RESOURCE_ID, leftResId)
                .putExtra(TemplateActivity.RIGHT_RESOURCE_ID, -1)
                .putExtra(TemplateActivity.RIGHT_TEXT, rightText), requestCode);
    }

    public static void startTemplateWithFlags(Context context, Class objClass, String title, int flags) {
        context.startActivity(new Intent(context, TemplateActivity.class)
                .putExtra(TemplateActivity.NAME, objClass)
                .putExtra(TemplateActivity.TITLE, title)
                .putExtra(TemplateActivity.LEFT_RESOURCE_ID, -1)
                .putExtra(TemplateActivity.RIGHT_RESOURCE_ID, -1)
                .addFlags(flags));
    }

}
