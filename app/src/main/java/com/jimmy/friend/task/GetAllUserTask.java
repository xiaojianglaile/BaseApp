package com.jimmy.friend.task;

import android.os.AsyncTask;

import com.google.gson.reflect.TypeToken;
import com.jimmy.common.base.BaseResponse;
import com.jimmy.common.utils.HttpUtils;
import com.jimmy.friend.bean.User;

import java.util.List;

/**
 * Created by Jimmy on 2016/7/31.
 */
public class GetAllUserTask extends AsyncTask<Void, Void, List<User>> {

    private OnGetAllUserListener listener;

    public GetAllUserTask(OnGetAllUserListener listener) {
        this.listener = listener;
    }

    @Override
    protected List<User> doInBackground(Void... params) {
        BaseResponse<List<User>> response = HttpUtils.syncHttpGet("http://192.168.1.27:8080/getAllUser", new TypeToken<BaseResponse<List<User>>>(){}.getType());
        if (response.getCode() == 200) {
            return response.getData();
        } else {
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<User> users) {
        super.onPostExecute(users);
        if (listener != null) {
            listener.onGetAllUserFinished(users);
        }
    }

    public interface OnGetAllUserListener {
        void onGetAllUserFinished(List<User> user);
    }
}
