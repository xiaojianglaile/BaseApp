package com.jimmy.common.base.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.jimmy.common.R;
import com.jimmy.common.util.FragmentUtil;

/**
 * Created by Jimmy on 2016/8/26 0026.
 */
public class TemplateActivity extends BaseActivity {

    public static String NAME = "template.fragment.name";
    public static String TITLE = "template.title";
    public static String PARAMS = "template.fragment.params";

    @Override
    protected void bindView() {
        setContentView(R.layout.activity_template);
        initToolBar();
        initFragment();
    }

    private void initFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.flTemplateContainer);
        if (fragment == null) {
            fragment = FragmentUtil.getInstance(this, getIntent().getStringExtra(NAME));
            Bundle params = getIntent().getBundleExtra(PARAMS);
            if (params != null)
                fragment.setArguments(params);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setTransition(FragmentTransaction.TRANSIT_NONE);
            ft.replace(R.id.flTemplateContainer, fragment);
            ft.commit();
        }
    }

    private void initToolBar() {
        Toolbar tbTemplateBar = searchViewById(R.id.tbTemplateBar);
        tbTemplateBar.setTitle("");
        setSupportActionBar(tbTemplateBar);
        TextView tvTemplateTitle = searchViewById(R.id.tvTemplateTitle);
        tvTemplateTitle.setText(getIntent().getStringExtra(TITLE));
    }

}
