package com.mvptest.http;

/**
 * Created by Administrator on 2016/8/18.
 */

public class HttpSetting {

    /**
     *正式服url
     **/
    public static final String PHPROOTURL = "http://server.zdoer.net/";
    /**
     *测试服url
     **/
    public static final String PHPTESTURL = "http://test-server.zdoer.net/";
    /**
     *md5 key
     **/
    public static final String MD5_KEY = "8f38780480386fcdf5978bd41ef13bce";
    /**
     *成功
     **/
    public static final int CODE_SUCCESS = 1;
    /**
     *失败
     **/
    public static final int CODE_FAIL = 0;
    /**
     *token验证失败
     **/
    public static final int CODE_AUTH_FAIL = -2;

}
