package com.mvptest.http;

import com.mvptest.bean.BaseBean;
import com.mvptest.config.HttpSetting;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/8/18.
 */

public class SubscriberCallBack<T> extends Subscriber<T> {

    private final HttpCallBack callBack;

    public SubscriberCallBack(HttpCallBack<Class<T>> callBack){
        this.callBack = callBack;
    }


    @Override
    public void onStart() {
        super.onStart();
        callBack.onStart();
    }

    @Override
    public void onCompleted() {
        callBack.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            String msg = httpException.getMessage();
            callBack.onFailure(code, msg);
        } else {
            callBack.onFailure(0, e.getMessage());
        }
        callBack.onCompleted();
    }

    @Override
    public void onNext(T t) {
        if(t instanceof BaseBean) {
            BaseBean bean = (BaseBean) t;
            if (bean.code == HttpSetting.CODE_SUCCESS) {
                callBack.onSuccess(t);
            } else {
                callBack.onFailure(bean.code, bean.msg);
            }
        }else if(t instanceof String){
            callBack.onSuccess(t.toString().trim());
        }
    }
}
