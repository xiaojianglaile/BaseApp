package com.jimmy.friend.login;

/**
 * Created by Jimmy on 2016/8/22 0022.
 */
public interface OnLoginListener {
    void onLogin(LoginCode code);

    enum LoginCode {
        LOGIN_SUCCESS,
        INPUT_FORMAT_ERROR,
        USER_INFO_ERROR,
        NET_ERROR
    }
}
