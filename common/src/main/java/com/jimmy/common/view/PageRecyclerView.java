package com.jimmy.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.android.volley.VolleyError;
import com.jimmy.common.R;
import com.jimmy.common.adapter.SuperAdapter;
import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.common.base.view.BaseDataBinding;
import com.jimmy.common.config.ApiCode;
import com.jimmy.common.listener.OnResponseListener;

import java.util.List;

/**
 * Created by Jimmy on 2017/6/15 0015.
 */
public class PageRecyclerView extends RecyclerView implements SwipeRefreshLayout.OnRefreshListener {

    private int page, size, orientation;
    private boolean isMore = true, isLoading = false;
    private List data;
    private SuperAdapter adapter;
    private BaseDataBinding dataBinding;
    private SwipeRefreshLayout swipeRefreshLayout;

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
                    if (dataBinding != null && data != null && isMore && !isLoading) {
                        page++;
                        isLoading = true;
                        dataBinding.onNext(page, size, new OnResponseListener<BaseResponse<List>>() {
                            @Override
                            public void onResponse(BaseResponse<List> response) {
                                if (response.getCode() == 0 && response.getData() != null && response.getData().size() > 0) {
                                    insertData(response.getData());
                                }
                                isLoading = false;
                            }

                            @Override
                            public void onError(VolleyError error) {
                                super.onError(error);
                                isLoading = false;
                            }
                        });
                    }
                }
            }
        });
    }

    private void insertData(List data) {
        adapter.addAll(data);
        isMore = data.size() >= size;
    }

    private void replaceData(List data) {
        adapter.replaceAll(data);
        isMore = data.size() >= size;
    }

    private void refresh() {
        page = 0;
        isMore = true;
        isLoading = true;
        this.dataBinding.onStart(page, size, new OnResponseListener<BaseResponse<List>>() {
            @Override
            public void onResponse(BaseResponse<List> response) {
                if (response.getCode() == ApiCode.SUCCESS && response.getData() != null && response.getData().size() > 0) {
                    replaceData(response.getData());
                }
                swipeRefreshLayout.setRefreshing(false);
                isLoading = false;
            }

            @Override
            public void onError(VolleyError error) {
                super.onError(error);
                swipeRefreshLayout.setRefreshing(false);
                isLoading = false;
            }
        });
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

    public void setDataBinding(BaseDataBinding dataBinding) {
        this.dataBinding = dataBinding;
        if (data != null && !isLoading) {
            isLoading = true;
            this.dataBinding.onStart(page, size, new OnResponseListener<BaseResponse<List>>() {
                @Override
                public void onResponse(BaseResponse<List> response) {
                    if (response.getCode() == 0 && response.getData() != null && response.getData().size() > 0) {
                        insertData(response.getData());
                    }
                    isLoading = false;
                }

                @Override
                public void onError(VolleyError error) {
                    super.onError(error);
                    isLoading = false;
                }
            });
        }
    }

    @Override
    public void onRefresh() {
        if (!isLoading) {
            refresh();
        } else {
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }, 1000);
        }
    }
}
