package com.mvptest.ui.mvp.presenter;

import com.mvptest.bean.IndexContents;
import com.mvptest.http.HttpCallBack;
import com.mvptest.ui.mvp.model.LoginModel;
import com.mvptest.ui.mvp.view.LoginView;

/**
 * Created by Administrator on 2016/11/2.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginModel loginModel;

    public LoginPresenter() {
        loginModel = new LoginModel();
    }


    public void getData1() {
        loginModel.getData1(new HttpCallBack<IndexContents>() {
            @Override
            public void onHttpStart() {
                view.onHttpStart();
            }

            @Override
            public void onHttpSuccess(IndexContents model) {
                view.onHttpSuccess(model);
            }

            @Override
            public void onHttpFailure(int code, String msg) {
                view.onHttpFailure(code,msg);
            }

            @Override
            public void onHttpCompleted() {
                view.onHttpCompleted();
            }
        });
    }

    public void unbind(){
        super.unbind();
        if (loginModel != null) {
            loginModel.unSubscribe();
            loginModel = null;
        }
    }
}
