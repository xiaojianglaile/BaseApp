package com.jimmy.friend.result;

import com.jimmy.friend.bean.User;

import java.util.List;

/**
 * Created by Jimmy on 2016/8/30 0030.
 */
public class LoginResult {

    private int code;
    private String message;
    private List<User> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
