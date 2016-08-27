package com.jimmy.friend.login;

import com.jimmy.common.base.mvp.IBaseView;

/**
 * Created by Jimmy on 2016/8/22 0022.
 */
public interface ILoginView extends IBaseView {
    void clearUsernameAndPassword();
    void showLoading();
    void hideLoading();
    String getUsername();
    String getPassword();
    void loginSuccess();
    void loginFailed();
    void infoFormatError();
    void netError();
}
