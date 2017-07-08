package com.jimmy.common.view.pagerv;

import com.jimmy.common.base.mvp.IBaseModel;
import com.jimmy.common.base.mvp.IBaseView;
import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.common.base.view.IPageDataBinding;
import com.jimmy.common.listener.OnResponseListener;

import java.util.List;

/**
 * Created by Jimmy on 2017/7/6 0006.
 */
interface IPageRV {

    interface IPageRecyclerView extends IBaseView {
        void insertData(List data);

        void replaceData(List data);

        void hideEmptyView();

        void showEmptyView();

        void setRefreshing(boolean refreshing);

        void setRefreshingDelay(boolean refreshing, long delay);
    }

    interface IPageRecyclerModel extends IBaseModel {
        void refreshData(IPageDataBinding dataBinding, int page, int size, OnResponseListener<BaseResponse<List>> listener);
        void loadMoreData(IPageDataBinding dataBinding, int page, int size, OnResponseListener<BaseResponse<List>> listener);
    }

}
