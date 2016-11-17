package com.frame.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.frame.mvp.BasePresenter;


/**
 * Created by Administrator on 2016/8/18.
 */

public abstract class BaseMVPActivity<V, P extends BasePresenter<V>> extends BaseActivity{

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        mPresenter.bindView((V) this);
    }

    protected abstract P initPresenter();


    @Override
    protected void onDestroy() {
        mPresenter.unbind();
        super.onDestroy();
    }




}
