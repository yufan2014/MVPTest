package com.mvptest.ui;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvptest.R;
import com.mvptest.bean.IndexContents;
import com.mvptest.ui.base.BaseMVPActivity;
import com.mvptest.ui.mvp.presenter.LoginPresenter;
import com.mvptest.ui.mvp.view.BaseView;
import com.mvptest.ui.mvp.view.LoginView;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/11/2.
 */

public class LoginActivity extends BaseMVPActivity<LoginView, LoginPresenter> implements BaseView {
    @Bind(R.id.username)
    EditText username;
    @Bind(R.id.pwd)
    EditText pwd;
    @Bind(R.id.submit)
    Button submit;
    private ProgressDialog progressBar;

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void initView() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getData1();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onHttpSuccess(Object model) {
        if(model instanceof IndexContents){
            IndexContents info = (IndexContents) model;
            Toast.makeText(this, ""+info.getTitles().get(0).getName(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onHttpStart() {
        showLoading("提交中...");
    }

    @Override
    public void onHttpFailure(int code, String msg) {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHttpCompleted() {
        closeLoading();
    }

}
