package com.frame.mvp;

/**
 * Created by Administrator on 2016/11/2.
 */

public interface BaseView {
    void onHttpStart();

    void onHttpSuccess(Object model);

    void onHttpFailure(int code, String msg);

    void onHttpCompleted();

}
