package com.jimmy.common.view.datarv;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.jimmy.common.R;
import com.jimmy.common.adapter.SuperAdapter;
import com.jimmy.common.base.view.IDataBinding;

import java.util.List;

/**
 * Created by Jimmy on 2017/7/8 0008.
 */
public class DataRecyclerView extends RecyclerView implements SwipeRefreshLayout.OnRefreshListener, IDataRV.IDataRecyclerView {

    private int orientation;
    private List data;
    private SuperAdapter adapter;
    private IDataBinding dataBinding;
    private SwipeRefreshLayout swipeRefreshLayout;
    private View emptyView;
    private DataRVPresenter presenter;

    public DataRecyclerView(Context context) {
        this(context, null);
    }

    public DataRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DataRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.DataRecyclerView);
        orientation = array.getInt(R.styleable.DataRecyclerView_drv_orientation, VERTICAL);
        array.recycle();
        init();
    }

    private void init() {
        initRecyclerView();
        initPresenter();
    }

    private void initPresenter() {
        presenter = new DataRVPresenter(this);
    }

    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(orientation);
        setLayoutManager(manager);
        DefaultItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setSupportsChangeAnimations(false);
        setItemAnimator(itemAnimator);
    }

    @Override
    public void onRefresh() {
        if (data != null && dataBinding != null) {
            presenter.onLoadData(dataBinding);
        } else {
            setRefreshingDelay(false, 1000);
        }
    }

    @Override
    public void replaceData(List data) {
        adapter.replaceAll(data);
    }

    @Override
    public void hideEmptyView() {
        if (emptyView != null) {
            emptyView.setVisibility(GONE);
        }
    }

    @Override
    public void showEmptyView() {
        if (adapter.getData().isEmpty() && emptyView != null) {
            emptyView.setVisibility(VISIBLE);
        }
    }

    @Override
    public void setRefreshing(boolean refreshing) {
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(refreshing);
        }
    }

    @Override
    public void setRefreshingDelay(boolean refreshing, long delay) {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                setRefreshing(false);
            }
        }, delay);
    }

    public void setAdapter(SuperAdapter adapter) {
        super.setAdapter(adapter);
        this.adapter = adapter;
        data = adapter.getData();
    }

    public void setRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(this);
        }
    }

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
    }

    public void setDataBinding(IDataBinding dataBinding) {
        this.dataBinding = dataBinding;
        if (data != null) {
            presenter.onLoadData(dataBinding);
        }
    }

}
