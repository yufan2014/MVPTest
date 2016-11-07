package com.mvptest.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2016/11/7.
 */

public class ImageLoadUtil {

    private static Context sContext;

    private ImageLoadUtil() {}

    public static void init(Context context) {
        sContext = context;
    }

    public static void load(ImageView target, String url) {
        Glide.with(sContext).load(url).into(target);
    }
}
