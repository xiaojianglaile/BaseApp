package com.jimmy.friend.main;

import com.google.gson.reflect.TypeToken;
import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.common.base.task.BaseAsyncTask;
import com.jimmy.common.listener.OnTaskFinishedListener;
import com.jimmy.common.util.HttpUtil;
import com.jimmy.common.util.StringUtil;
import com.jimmy.friend.bean.Commodity;

import java.util.List;

/**
 * Created by Jimmy on 2016/7/31.
 */
public class LoadCommoditiesTask extends BaseAsyncTask<List<Commodity>> {

    private final String URL = "http://7xte9i.com1.z0.glb.clouddn.com/commodities.json?" + StringUtil.getRandomString(5);

    public LoadCommoditiesTask(OnTaskFinishedListener<List<Commodity>> onTaskFinishedListener) {
        super(onTaskFinishedListener);
    }

    @Override
    protected List<Commodity> doInBackground(Void... params) {
        BaseResponse<List<Commodity>> response = HttpUtil.syncHttpGet(URL, new TypeToken<BaseResponse<List<Commodity>>>() {
        }.getType());
        if (response != null && response.getCode() == 1) {
            return response.getData();
        } else {
            return null;
        }
    }

}
