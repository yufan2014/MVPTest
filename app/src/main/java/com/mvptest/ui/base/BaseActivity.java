package com.mvptest.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentViewBefore();
        setContentView(setContentViewId());
        ButterKnife.bind(this);

        initGetData();
        initView();
        initData();

    }


    /**
     * 初始化视图之前
     */
    protected void setContentViewBefore(){

    }
    /**
     * 设置状态栏颜色
     */
    protected int setStatusColor(){
        return 0;
    }

    /**
     * 初始化视图
     */
    protected abstract int setContentViewId();

    /**
     * 获取上一个界面传送过来的数据
     */
    protected abstract void initGetData();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();


    /**
     * 获取网络数据
     */
//    public void getHttp(Observable observable,HttpCallBack httpCallBack){
//        addSubscription(observable,httpCallBack);
//    }
//
//
//    public void addSubscription(Observable observable,HttpCallBack httpCallBack) {
//        if (mCompositeSubscription == null) {
//            mCompositeSubscription = new CompositeSubscription();
//        }
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SubscriberCallBack(httpCallBack));
//       mCompositeSubscription.add(new SubscriberCallBack(httpCallBack));
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
//            mCompositeSubscription.unsubscribe();
//        }
//    }


    public void showLoading(String title) {
        if(progressBar == null)
        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage(title);
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();
    }


    public void closeLoading() {
        if(progressBar != null)
            progressBar.dismiss();
    }
}
