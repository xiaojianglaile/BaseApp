package com.jimmy.common.view.datarv;

import com.android.volley.VolleyError;
import com.jimmy.common.base.mvp.BasePresenter;
import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.common.base.view.IDataBinding;
import com.jimmy.common.config.ApiCode;
import com.jimmy.common.listener.OnResponseListener;

import java.util.List;

/**
 * Created by Jimmy on 2017/7/8 0008.
 */
class DataRVPresenter extends BasePresenter<IDataRV.IDataRecyclerView, IDataRV.IDataRecyclerModel> {

    private boolean isLoading = false;

    DataRVPresenter(IDataRV.IDataRecyclerView view) {
        super(view);
        mModel = new DataRVModel();
    }


    void onLoadData(IDataBinding dataBinding) {
        if (!isLoading) {
            isLoading = true;
            mModel.loadData(dataBinding, new OnResponseListener<BaseResponse<List>>() {
                @Override
                public void onResponse(BaseResponse<List> response) {
                    if (response.getCode() == ApiCode.SUCCESS && response.getData() != null && response.getData().size() > 0) {
                        mView.replaceData(response.getData());
                        mView.hideEmptyView();
                    } else {
                        mView.showEmptyView();
                    }
                    isLoading = false;
                }

                @Override
                public void onError(VolleyError error) {
                    super.onError(error);
                    mView.showEmptyView();
                    isLoading = false;
                }
            });
        } else {
            mView.setRefreshingDelay(false, 1000);
        }
    }
}
