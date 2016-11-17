package com.frame.http;


import com.frame.bean.BaseBean;

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
        callBack.onHttpStart();
    }

    @Override
    public void onCompleted() {
        callBack.onHttpCompleted();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            String msg = httpException.getMessage();
            callBack.onHttpFailure(code, msg);
        } else {
            callBack.onHttpFailure(0, e.getMessage());
        }
        callBack.onHttpCompleted();
    }

    @Override
    public void onNext(T t) {
        if(t instanceof BaseBean) {
            BaseBean bean = (BaseBean) t;
            if (bean.code == HttpSetting.CODE_SUCCESS) {
                callBack.onHttpSuccess(t);
            } else {
                callBack.onHttpFailure(bean.code, bean.msg);
            }
        }else if(t instanceof String){
            callBack.onHttpSuccess(t.toString().trim());
        }
    }
}
