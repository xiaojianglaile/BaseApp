package com.jimmy.common.base.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jimmy.common.R;
import com.jimmy.common.util.BeanUtils;

/**
 * Created by Jimmy on 2016/8/26 0026.
 */
public class TemplateActivity extends BaseActivity implements View.OnClickListener {

    public static String NAME = "template.fragment.name";
    public static String TITLE = "template.title";
    public static String PARAMS = "template.fragment.params";
    public static String LEFT_RESOURCE_ID = "template.left.resource.id";
    public static String RIGHT_RESOURCE_ID = "template.right.resource.id";
    public static String RIGHT_TEXT = "template.right.text";

    private Fragment mFragment;

    @Override
    protected void bindView() {
        setContentView(R.layout.activity_template);
        initToolBar();
        initFragment();
    }

    private void initFragment() {
        mFragment = getSupportFragmentManager().findFragmentById(R.id.flTemplateContainer);
        if (mFragment == null) {
            mFragment = BeanUtils.getFragment(this, getIntent().getStringExtra(NAME));
            Bundle params = getIntent().getBundleExtra(PARAMS);
            if (params != null)
                mFragment.setArguments(params);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setTransition(FragmentTransaction.TRANSIT_NONE);
            ft.replace(R.id.flTemplateContainer, mFragment);
            ft.commit();
        }
    }

    private void initToolBar() {
        Toolbar tbTemplateBar = searchViewById(R.id.tbTemplateBar);
        tbTemplateBar.setTitle("");
        setSupportActionBar(tbTemplateBar);
        TextView tvTemplateTitle = searchViewById(R.id.tvTemplateTitle);
        tvTemplateTitle.setText(getIntent().getStringExtra(TITLE));
        ImageButton ibTemplateLeft = searchViewById(R.id.ibTemplateLeft);
        ImageButton ibTemplateRight = searchViewById(R.id.ibTemplateRight);
        int leftResId = getIntent().getIntExtra(LEFT_RESOURCE_ID, -1);
        ibTemplateLeft.setImageResource(leftResId == -1 ? R.drawable.btn_back : leftResId);
        int rightResId = getIntent().getIntExtra(RIGHT_RESOURCE_ID, -1);
        if (rightResId != -1) {
            ibTemplateRight.setVisibility(View.VISIBLE);
            ibTemplateRight.setImageResource(rightResId);
        } else {
            ibTemplateRight.setVisibility(View.GONE);
        }
        TextView tvTemplateRight = searchViewById(R.id.tvTemplateRight);
        String rightText = getIntent().getStringExtra(RIGHT_TEXT);
        if (rightText != null) {
            tvTemplateRight.setVisibility(View.VISIBLE);
            tvTemplateRight.setText(rightText);
        } else {
            tvTemplateRight.setVisibility(View.GONE);
        }
        ibTemplateLeft.setOnClickListener(this);
        ibTemplateRight.setOnClickListener(this);
        tvTemplateRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.ibTemplateLeft) {
            if (mFragment != null && mFragment instanceof TemplateFragment) {
                ((TemplateFragment) mFragment).onLeftButtonClick(v);
            }

        } else if (i == R.id.ibTemplateRight || i == R.id.tvTemplateRight) {
            if (mFragment != null && mFragment instanceof TemplateFragment) {
                ((TemplateFragment) mFragment).onRightButtonClick(v);
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mFragment != null) {
            mFragment.onActivityResult(requestCode, resultCode, data);
        }
    }

}
