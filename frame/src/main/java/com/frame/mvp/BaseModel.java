package com.frame.mvp;

import com.frame.http.HttpCallBack;
import com.frame.http.SubscriberCallBack;
import com.frame.http.retrofit.ApiClient;
import com.frame.http.retrofit.ApiService;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import static com.frame.http.retrofit.ApiClient.getRetrofit;

/**
 * Created by Administrator on 2016/11/2.
 */

public class BaseModel<A extends ApiService> {

    public ApiService service = null;
    private CompositeSubscription mCompositeSubscription;
    
    public BaseModel(){
        if(service == null)
            service = getRetrofit().create(ApiService.class);
    }

    public void setApiService(Class A){
        if(service == null)
            service = (ApiService)ApiClient.getRetrofit().create(A);
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
