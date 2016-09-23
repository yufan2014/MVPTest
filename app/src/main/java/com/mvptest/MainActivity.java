package com.mvptest;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mvptest.bean.IndexContents;
import com.mvptest.http.HttpCallBack;
import com.mvptest.utils.IntentUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.content)
    TextView content;
    @Bind(R.id.test_btn)
    TextView test_btn;
    @Bind(R.id.get_http)
    TextView get_http;
    @Bind(R.id.scroll_test)
    TextView scrollTest;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void initView() {
        content.setMovementMethod(ScrollingMovementMethod.getInstance());
        scrollTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtil.gotoActivity(MainActivity.this,ScrollTestActivity.class);
            }
        });

        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHttp(service.getMM("美女", 24), new HttpCallBack<String>() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(String model) {
                        content.setText((String) model);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "onCompleted", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        get_http.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHttp(service.getIndex(), new HttpCallBack<IndexContents>() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(IndexContents model) {
                        content.setText(model.getTitles().get(0).getName());
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "onCompleted", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    @Override
    protected void initData() {


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
