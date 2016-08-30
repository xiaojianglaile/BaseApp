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
        context.startActivity(new Intent(context, TemplateActivity.class)
                .putExtra(TemplateActivity.NAME, name)
                .putExtra(TemplateActivity.TITLE, title));
    }

    public static void startTemplate(Context context, String name, String title, Bundle params) {
        context.startActivity(new Intent(context, TemplateActivity.class)
                .putExtra(TemplateActivity.NAME, name)
                .putExtra(TemplateActivity.TITLE, title)
                .putExtra(TemplateActivity.PARAMS, params));
    }

}
