package com.jimmy.friend.activity;

import android.os.AsyncTask;

import com.jimmy.common.base.app.BaseActivity;
import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.friend.bean.User;
import com.jimmy.common.listener.OnResponseListener;
import com.jimmy.common.util.HttpUtils;
import com.jimmy.friend.R;
import com.jimmy.friend.params.UserParams;
import com.jimmy.friend.task.GetAllUserTask;
import com.jimmy.friend.task.GetUserTask;

import java.util.List;

public class MainActivity extends BaseActivity implements GetAllUserTask.OnGetAllUserListener, GetUserTask.OnGetAllUserListener {

    @Override
    protected void bindView() {
        setContentView(R.layout.activity_main);

        // 异步访问网络操作
        HttpUtils.httpGet("http://192.168.1.27:8080/getAllUser", new OnResponseListener<List<User>>() {
            @Override
            public void onResponse(BaseResponse<List<User>> response) {
                if (response.getCode() == 200 && response.getData() != null) {
                    System.out.println("---------------------------------");
                    for (int i = 0; i < response.getData().size(); i++) {
                        System.out.println(response.getData().get(i).getId());
                        System.out.println(response.getData().get(i).getName());
                        System.out.println(response.getData().get(i).getAge());
                        System.out.println(response.getData().get(i).getSex());
                    }
                }
            }
        });

        // 异步访问网络操作
        HttpUtils.httpPost("http://192.168.1.27:8080/findByNamePost", new UserParams("Jimmy"), new OnResponseListener<User>() {
            @Override
            public void onResponse(BaseResponse<User> response) {
                System.out.println("---------------------------------");
                if (response.getCode() == 200 && response.getData() != null) {
                    System.out.println(response.getData().getId());
                    System.out.println(response.getData().getName());
                    System.out.println(response.getData().getAge());
                    System.out.println(response.getData().getSex());
                }
            }
        });

        // 异步线程-->执行同步访问网络操作
        new GetAllUserTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        new GetUserTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }

    @Override
    public void onGetAllUserFinished(List<User> users) {
        System.out.println("---------------------------------");
        if (users != null) {
            for (int i = 0; i < users.size(); i++) {
                System.out.println(users.get(i).getId());
                System.out.println(users.get(i).getName());
                System.out.println(users.get(i).getAge());
                System.out.println(users.get(i).getSex());
            }
        }
    }

    @Override
    public void onGetUserFinished(User user) {
        System.out.println("---------------------------------");
        if (user != null) {
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getAge());
            System.out.println(user.getSex());
        }
    }
}
