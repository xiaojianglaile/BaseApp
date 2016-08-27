package com.jimmy.friend.login;

import com.google.gson.reflect.TypeToken;
import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.common.base.task.BaseAsyncTask;
import com.jimmy.common.listener.OnTaskFinishedListener;
import com.jimmy.common.util.HttpUtil;
import com.jimmy.common.util.StringUtil;
import com.jimmy.friend.bean.User;

import java.util.List;

/**
 * Created by Jimmy on 2016/7/31.
 */
public class LoginTask extends BaseAsyncTask<List<User>> {

    private String URL = "http://7xte9i.com1.z0.glb.clouddn.com/users.json?" + StringUtil.getRandomString(5);

    public LoginTask(OnTaskFinishedListener<List<User>> onTaskFinishedListener) {
        super(onTaskFinishedListener);
    }

    @Override
    protected List<User> doInBackground(Void... params) {
        BaseResponse<List<User>> response = HttpUtil.syncHttpGet(URL, new TypeToken<BaseResponse<List<User>>>() {
        }.getType());
        if (response != null && response.getCode() == 1) {
            return response.getData();
        } else {
            return null;
        }
    }

}
