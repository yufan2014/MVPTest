package com.frame.http.version_update;

import com.frame.bean.BaseBean;

/**
 * Created by Administrator on 2016/11/10.
 */
public class UpdateAppInfo extends BaseBean {
    // app名字
    public String appname;
    //服务器版本
    public String serverVersion;
    //服务器版本号
    public int serverVersioncode;
    //服务器标志
    public String serverFlag;
    //强制升级
    public String lastForce;
    //app最新版本地址
    public String updateurl;
    //升级信息
    public String upgradeinfo;
}
