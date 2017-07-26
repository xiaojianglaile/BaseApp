package com.jimmy.common.base.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jimmy on 2016/7/31.
 */
public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;
    protected Context mContext;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getContext();
        mView = initContentView(inflater, container);
        if (mView == null)
            throw new NullPointerException("Fragment content view is null.");
        initView();
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
        bindData();
    }

    /**
     * 请求动态数据
     */
    protected void initData() {

    }

    /**
     * 绑定静态数据
     */
    protected void bindData() {

    }

    @Nullable
    protected abstract View initContentView(LayoutInflater inflater, @Nullable ViewGroup container);

    protected abstract void initView();

    protected <VT extends View> VT findView(int id) {
        if (mView == null)
            throw new NullPointerException("Fragment content view is null.");
        VT view = mView.findViewById(id);
        if (view == null)
            throw new NullPointerException("This resource id is invalid.");
        return view;
    }

    public String getAppString(int id) {
        return mActivity.getResources().getString(id);
    }

    public String getAppString(int id, Object... formatArgs) {
        return mActivity.getResources().getString(id, formatArgs);
    }

}
