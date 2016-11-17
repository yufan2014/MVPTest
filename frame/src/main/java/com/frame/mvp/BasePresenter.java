package com.frame.mvp;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2016/11/2.
 */

public class BasePresenter<V> {

    private WeakReference<V> mViewRef;
    public V view;

    public BasePresenter(){
        this.mViewRef = new WeakReference<>(view);
    }

    public void bindView(V view){
        this.view = view;
    }



    public void unbind(){

        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
