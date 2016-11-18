package com.mvptest.ui;

import android.widget.TextView;

import com.frame.base.BaseActivity;
import com.mvptest.R;

import butterknife.Bind;

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

    }

    @Override
    protected void initData() {

    }

//    @Override
//    protected void initView() {
//        content.setMovementMethod(ScrollingMovementMethod.getInstance());
//        scrollTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                IntentUtil.gotoActivity(MainActivity.this,ScrollTestActivity.class);
//            }
//        });
//
//        test_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getHttp();
//            }
//        });
//        get_http.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getHttp(service.getIndex(), new HttpCallBack<IndexContents>() {
//
//                    @Override
//                    public void onStart() {
//
//                    }
//
//                    @Override
//                    public void onSuccess(IndexContents model) {
//                        content.setText(model.getTitles().get(0).getName());
//                    }
//
//                    @Override
//                    public void onFailure(int code, String msg) {
//                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onCompleted() {
//                        Toast.makeText(MainActivity.this, "onCompleted", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//
//    }
//
//    @Override
//    protected void initData() {
//
//
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
