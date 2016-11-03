package com.mvptest.ui.mvp.model;

import com.mvptest.bean.IndexContents;
import com.mvptest.http.HttpCallBack;

/**
 * Created by Administrator on 2016/11/2.
 */

public class LoginModel extends BaseModel {

    public void getData1(HttpCallBack<IndexContents> callBack) {
        getHttp(service.getIndex(),callBack);
    }


}
