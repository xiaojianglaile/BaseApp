package com.jimmy.friend.login;

import android.os.AsyncTask;

import com.jimmy.common.listener.OnTaskFinishedListener;
import com.jimmy.friend.bean.User;

import java.util.List;

/**
 * Created by Jimmy on 2016/8/22 0022.
 */
public class LoginModel implements ILoginModel {

    @Override
    public void login(final String username, final String password, final OnLoginListener onLoginListener) {
        if (username.length() < 6 || password.length() < 6) {
            if (onLoginListener != null) {
                onLoginListener.onLogin(OnLoginListener.LoginCode.INPUT_FORMAT_ERROR);
            }
        } else {
            new LoginTask(new OnTaskFinishedListener<List<User>>() {
                @Override
                public void onTaskFinished(List<User> data) {
                    if (onLoginListener != null) {
                        if (data != null) {
                            boolean isSuccess = false;
                            for (int i = 0; i < data.size(); i++) {
                                if (username.equals(data.get(i).getUsername()) && password.equals(data.get(i).getPassword())) {
                                    isSuccess = true;
                                    break;
                                }
                            }
                            if (isSuccess) {
                                onLoginListener.onLogin(OnLoginListener.LoginCode.LOGIN_SUCCESS);
                            } else {
                                onLoginListener.onLogin(OnLoginListener.LoginCode.USER_INFO_ERROR);
                            }
                        } else {
                            onLoginListener.onLogin(OnLoginListener.LoginCode.NET_ERROR);
                        }
                    }
                }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }

}
