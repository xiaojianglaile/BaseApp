package com.jimmy.friend.login;

import com.jimmy.common.base.mvp.BasePresenter;

/**
 * Created by Jimmy on 2016/8/22 0022.
 */
public class LoginPresenter extends BasePresenter<ILoginView, ILoginModel> {

    public LoginPresenter(ILoginView view) {
        super(view);
        mModel = new LoginModel();
    }

    public void login() {
        mView.showLoading();
        mModel.login(mView.getUsername(), mView.getPassword(), new OnLoginListener() {
            @Override
            public void onLogin(LoginCode code) {
                switch (code) {
                    case LOGIN_SUCCESS:
                        mView.loginSuccess();
                        break;
                    case INPUT_FORMAT_ERROR:
                        mView.infoFormatError();
                        break;
                    case USER_INFO_ERROR:
                        mView.loginFailed();
                        break;
                    case NET_ERROR:
                        mView.netError();
                        break;
                }
                mView.hideLoading();
            }
        });
    }

    public void clearUsernameAndPassword() {
        mView.clearUsernameAndPassword();
    }

}
