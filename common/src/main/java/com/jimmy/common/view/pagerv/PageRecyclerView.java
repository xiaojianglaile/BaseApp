package com.jimmy.common.view.pagerv;

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
import com.jimmy.common.base.view.BaseDataBinding;

import java.util.List;

/**
 * Created by Jimmy on 2017/6/15 0015.
 */
public class PageRecyclerView extends RecyclerView implements SwipeRefreshLayout.OnRefreshListener, IPageRV.IPageRecyclerView {

    private int page, size, orientation;
    private List data;
    private SuperAdapter adapter;
    private BaseDataBinding dataBinding;
    private SwipeRefreshLayout swipeRefreshLayout;
    private View emptyView;
    private PageRVPresenter presenter;

    public PageRecyclerView(Context context) {
        this(context, null);
    }

    public PageRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PageRecyclerView);
        page = array.getInt(R.styleable.PageRecyclerView_page_num, 0);
        size = array.getInt(R.styleable.PageRecyclerView_page_size, 10);
        orientation = array.getInt(R.styleable.PageRecyclerView_orientation, VERTICAL);
        array.recycle();
        init();
    }

    private void init() {
        initRecyclerView();
        initPresenter();
    }

    private void initPresenter() {
        presenter = new PageRVPresenter(this, page, size);
    }

    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(orientation);
        setLayoutManager(manager);
        DefaultItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setSupportsChangeAnimations(false);
        setItemAnimator(itemAnimator);
        addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (computeVerticalScrollExtent() + computeVerticalScrollOffset() >= computeVerticalScrollRange()) {
                    if (data != null) {
                        presenter.onLoadMoreData(dataBinding);
                    }
                }
            }
        });
    }

    @Override
    public void insertData(List data) {
        adapter.addAll(data);
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

    public void setDataBinding(BaseDataBinding dataBinding) {
        this.dataBinding = dataBinding;
        if (data != null) {
            presenter.onRefreshData(dataBinding);
        }
    }

    @Override
    public void onRefresh() {
        if (data != null) {
            presenter.onRefreshData(dataBinding);
        } else {
            setRefreshingDelay(false, 1000);
        }
    }
}
