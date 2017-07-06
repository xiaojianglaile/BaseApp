package com.jimmy.common.view.pagerv;

import com.android.volley.VolleyError;
import com.jimmy.common.base.mvp.BasePresenter;
import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.common.base.view.BaseDataBinding;
import com.jimmy.common.config.ApiCode;
import com.jimmy.common.listener.OnResponseListener;

import java.util.List;

/**
 * Created by Jimmy on 2017/7/6 0006.
 */
class PageRVPresenter extends BasePresenter<IPageRV.IPageRecyclerView, IPageRV.IPageRecyclerModel> {

    private int page, size;
    private boolean isMore = true, isLoading = false;

    PageRVPresenter(IPageRV.IPageRecyclerView view, int page, int size) {
        super(view);
        mModel = new PageRVModel();
        this.page = page;
        this.size = size;
    }

    void onLoadMoreData(BaseDataBinding dataBinding) {
        if (dataBinding != null && isMore && !isLoading) {
            page++;
            isLoading = true;
            mModel.loadMoreData(dataBinding, page, size, new OnResponseListener<BaseResponse<List>>() {
                @Override
                public void onResponse(BaseResponse<List> response) {
                    if (response.getCode() == 0 && response.getData() != null && response.getData().size() > 0) {
                        mView.insertData(response.getData());
                        mView.hideEmptyView();
                        isMore = response.getData().size() >= size;
                    } else {
                        mView.showEmptyView();
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

    void onRefreshData(BaseDataBinding dataBinding) {
        if (!isLoading) {
            page = 0;
            isMore = true;
            isLoading = true;
            mModel.refreshData(dataBinding, page, size, new OnResponseListener<BaseResponse<List>>() {
                @Override
                public void onResponse(BaseResponse<List> response) {
                    if (response.getCode() == ApiCode.SUCCESS && response.getData() != null && response.getData().size() > 0) {
                        mView.replaceData(response.getData());
                        mView.hideEmptyView();
                        isMore = response.getData().size() >= size;
                    } else {
                        mView.showEmptyView();
                    }
                    mView.setRefreshing(false);
                    isLoading = false;
                }

                @Override
                public void onError(VolleyError error) {
                    super.onError(error);
                    mView.setRefreshing(false);
                    isLoading = false;
                }
            });
        } else {
            mView.setRefreshingDelay(false, 1000);
        }
    }
}
