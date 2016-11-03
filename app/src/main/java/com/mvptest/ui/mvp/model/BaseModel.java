package com.mvptest.ui.mvp.model;

import com.mvptest.http.HttpCallBack;
import com.mvptest.http.SubscriberCallBack;
import com.mvptest.http.retrofit.ApiClient;
import com.mvptest.http.retrofit.ApiService;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/11/2.
 */

public class BaseModel {

    public ApiService service = null;
    private CompositeSubscription mCompositeSubscription;
    
    public BaseModel(){
        if(service == null)
            service = ApiClient.getRetrofit().create(ApiService.class);
    }

    /**
     * 获取网络数据
     * @param observable
     * @param httpCallBack
     */
    public void getHttp(Observable observable, HttpCallBack httpCallBack){
        addSubscription(observable,httpCallBack);
    }


    public void addSubscription(Observable observable, HttpCallBack httpCallBack) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SubscriberCallBack(httpCallBack));
        mCompositeSubscription.add(new SubscriberCallBack(httpCallBack));
    }


    public void unSubscribe(){
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }




}
