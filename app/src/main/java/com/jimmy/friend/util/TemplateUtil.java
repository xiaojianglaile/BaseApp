package com.jimmy.friend.util;

import android.content.Context;
import android.content.Intent;

import com.jimmy.common.base.param.MapParams;
import com.jimmy.friend.activity.TemplateActivity;

/**
 * Created by Jimmy on 2016/8/26 0026.
 */
public class TemplateUtil {

    public static void startTemplate(Context context, String name, String title) {
        context.startActivity(new Intent(context, TemplateActivity.class)
                .putExtra(TemplateActivity.NAME, name)
                .putExtra(TemplateActivity.TITLE, title));
    }

    public static void startTemplate(Context context, String name, String title, MapParams params) {
        context.startActivity(new Intent(context, TemplateActivity.class)
                .putExtra(TemplateActivity.NAME, name)
                .putExtra(TemplateActivity.TITLE, title)
                .putExtra(TemplateActivity.PARAMS, params));
    }

}