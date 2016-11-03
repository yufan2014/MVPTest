package com.mvptest.ui.mvp.presenter;

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
        loginModel.getData1(view);
    }

    public void unbind(){
        super.unbind();
        if (loginModel != null) {
            loginModel.unSubscribe();
            loginModel = null;
        }
    }
}
