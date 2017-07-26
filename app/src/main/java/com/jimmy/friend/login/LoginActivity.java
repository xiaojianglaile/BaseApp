package com.jimmy.friend.login;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jimmy.common.base.app.BaseActivity;
import com.jimmy.friend.R;
import com.jimmy.friend.main.MainActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener, ILoginView {

    private EditText etUsername, etPassword;
    private LoginPresenter mLoginPresenter;
    private View vLoading;

    @Override
    protected void bindView() {
        setContentView(R.layout.activity_login);
        etUsername = findView(R.id.etUsername);
        etPassword = findView(R.id.etPassword);
        vLoading = findView(R.id.vLoading);
        findView(R.id.btnLogin).setOnClickListener(this);
        findView(R.id.btnClear).setOnClickListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
        mLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                mLoginPresenter.login();
                break;
            case R.id.btnClear:
                mLoginPresenter.clearUsernameAndPassword();
                break;
        }
    }

    @Override
    public void clearUsernameAndPassword() {
        etUsername.getText().clear();
        etPassword.getText().clear();
    }

    @Override
    public void showLoading() {
        vLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        vLoading.setVisibility(View.GONE);
    }

    @Override
    public String getUsername() {
        return etUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Login Failed! Username or Password is Error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void infoFormatError() {
        Toast.makeText(this, "Username or Password length is more than 6!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void netError() {
        Toast.makeText(this, "Net Error!", Toast.LENGTH_SHORT).show();
    }
}
