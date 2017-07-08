package com.jimmy.common.view.pagerv;

import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.common.base.view.IPageDataBinding;
import com.jimmy.common.listener.OnResponseListener;

import java.util.List;

/**
 * Created by Jimmy on 2017/7/6 0006.
 */
class PageRVModel implements IPageRV.IPageRecyclerModel {

    @Override
    public void refreshData(IPageDataBinding dataBinding, int page, int size, OnResponseListener<BaseResponse<List>> listener) {
        dataBinding.onStart(page, size, listener);
    }

    @Override
    public void loadMoreData(IPageDataBinding dataBinding, int page, int size, OnResponseListener<BaseResponse<List>> listener) {
        dataBinding.onNext(page, size, listener);
    }
}
