package com.jimmy.friend.login;

import com.jimmy.common.base.mvp.IBaseModel;

/**
 * Created by Jimmy on 2016/8/22 0022.
 */
public interface ILoginModel extends IBaseModel {
    void login(String username, String password, OnLoginListener onLoginListener);
}
