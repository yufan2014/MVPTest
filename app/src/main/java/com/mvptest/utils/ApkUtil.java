package com.mvptest.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * Created by Administrator on 2016/9/27.
 */

public class ApkUtil {

    /**
     * 获取apk目录
     * @param context
     * @param packageName
     * @return
     */
    public static String getSoureApkPath(Context context,String packageName){

        if(TextUtils.isEmpty(packageName)){
            return null;
        }
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName,0);
            return info.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
