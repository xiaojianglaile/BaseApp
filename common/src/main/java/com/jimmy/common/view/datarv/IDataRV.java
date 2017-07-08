package com.jimmy.common.view.datarv;

import com.jimmy.common.base.mvp.IBaseModel;
import com.jimmy.common.base.mvp.IBaseView;
import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.common.base.view.IDataBinding;
import com.jimmy.common.listener.OnResponseListener;

import java.util.List;

/**
 * Created by Jimmy on 2017/7/8 0008.
 */
interface IDataRV {

    interface IDataRecyclerView extends IBaseView {
        void replaceData(List data);

        void hideEmptyView();

        void showEmptyView();

        void setRefreshing(boolean refreshing);

        void setRefreshingDelay(boolean refreshing, long delay);
    }

    interface IDataRecyclerModel extends IBaseModel {
        void loadData(IDataBinding dataBinding, OnResponseListener<BaseResponse<List>> listener);
    }

}
