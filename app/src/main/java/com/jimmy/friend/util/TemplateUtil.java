package com.jimmy.friend.util;

import android.content.Context;
import android.content.Intent;

import com.jimmy.common.base.param.MapParams;
import com.jimmy.friend.base.TemplateActivity;

import java.util.Map;

/**
 * Created by Jimmy on 2016/8/26 0026.
 */
public class TemplateUtil {

    public static void startTemplate(Context context, String name, String title) {
        context.startActivity(new Intent(context, TemplateActivity.class)
                .putExtra(TemplateActivity.NAME, name)
                .putExtra(TemplateActivity.TITLE, title));
    }

    public static void startTemplate(Context context, String name, String title, Map<String, Object> params) {
        MapParams mapParams = new MapParams();
        mapParams.setParams(params);
        context.startActivity(new Intent(context, TemplateActivity.class)
                .putExtra(TemplateActivity.NAME, name)
                .putExtra(TemplateActivity.TITLE, title)
                .putExtra(TemplateActivity.PARAMS, mapParams));
    }

}
