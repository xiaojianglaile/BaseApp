package com.jimmy.friend.task;

import android.os.AsyncTask;

import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.common.util.HttpUtils;
import com.jimmy.friend.bean.User;
import com.jimmy.friend.params.UserParams;

import java.util.List;

/**
 * Created by Jimmy on 2016/7/31.
 */
public class GetUserTask extends AsyncTask<Void, Void, User> {

    private OnGetAllUserListener listener;

    public GetUserTask(OnGetAllUserListener listener) {
        this.listener = listener;
    }

    @Override
    protected User doInBackground(Void... params) {
        BaseResponse<User> response = HttpUtils.syncHttpPost("http://192.168.1.27:8080/findByNamePost", new UserParams("Jimmy"));
        if (response.getCode() == 200) {
            return response.getData();
        } else {
            return null;
        }
    }

    @Override
    protected void onPostExecute(User users) {
        super.onPostExecute(users);
        if (listener != null) {
            listener.onGetUserFinished(users);
        }
    }

    public interface OnGetAllUserListener {
        void onGetUserFinished(User user);
    }
}
