package com.frame.http;

/**
 * Created by Administrator on 2016/8/18.
 */

public interface HttpCallBack<T> {
    void onHttpStart();

    void onHttpSuccess(T model);

    void onHttpFailure(int code, String msg);

    void onHttpCompleted();
}
