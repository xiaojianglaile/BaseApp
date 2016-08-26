package com.jimmy.common.util;

import android.content.Context;
import android.support.v4.app.Fragment;

import java.util.Properties;

public class FragmentUtil {

    /**
     * 根据配置名获取Fragment
     *
     * @param context
     * @param name
     * @return
     */
    public static Fragment getInstance(Context context, String name) {
        Fragment fragment;
        try {
            Properties p = new Properties();
            p.load(context.getAssets().open("fragment.properties"));
            String packageName = (String) p.get(name);
            fragment = (Fragment) Class.forName(packageName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            fragment = new Fragment();
        }
        return fragment;
    }
}
