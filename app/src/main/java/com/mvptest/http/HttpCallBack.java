package com.mvptest.http;

/**
 * Created by Administrator on 2016/8/18.
 */

public interface HttpCallBack<T> {
    void onStart();

    void onSuccess(T model);

    void onFailure(int code, String msg);

    void onCompleted();
}
