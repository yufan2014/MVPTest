package com.mvptest.config;

import android.os.Environment;

/**
 * Created by Administrator on 2016/9/27.
 */

public class Constants {
    public static String PATCH_FILE = "";
    public static String URL_PATCH_DOWNLOAD = "";
    public static String PACKAGE_NAME = "";
    public static String SD_CARD = Environment.getExternalStorageDirectory().getAbsolutePath()+"";
    public static String NEW_APK_PATH = SD_CARD+"XX.apk";
    public static String PATCH_FILE_PATH = SD_CARD+PATCH_FILE;
}
