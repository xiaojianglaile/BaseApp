package com.jimmy.friend.login;

import com.jimmy.common.base.task.BaseAsyncTask;
import com.jimmy.common.listener.OnTaskFinishedListener;
import com.jimmy.common.util.HttpUtils;
import com.jimmy.common.util.StringUtils;
import com.jimmy.friend.result.LoginResult;
import com.jimmy.friend.bean.User;

import java.util.List;

/**
 * Created by Jimmy on 2016/7/31.
 */
public class LoginTask extends BaseAsyncTask<List<User>> {

    private String URL = "http://7xte9i.com1.z0.glb.clouddn.com/users.json?" + StringUtils.getRandomString(5);

    public LoginTask(OnTaskFinishedListener<List<User>> onTaskFinishedListener) {
        super(onTaskFinishedListener);
    }

    @Override
    protected List<User> doInBackground(Void... params) {
        LoginResult response = HttpUtils.syncHttpGet(URL, LoginResult.class);
        if (response != null && response.getCode() == 1) {
            return response.getData();
        } else {
            return null;
        }
    }

}
