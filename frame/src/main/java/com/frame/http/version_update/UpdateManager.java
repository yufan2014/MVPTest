package com.frame.http.version_update;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import com.frame.http.HttpCallBack;
import com.frame.http.SubscriberCallBack;
import com.frame.http.retrofit.ApiClient;
import com.frame.http.retrofit.ApiService;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zs on 2016/7/7.
 */
public class UpdateManager {

    private Context mContext;
    private ApiService service;

    public UpdateManager(Context context) {
        this.mContext = context;
    }

    /**
     * 检测软件更新
     */
    public void checkUpdate(final boolean isToast) {
        /**
         * 在这里请求后台接口，获取更新的内容和最新的版本号
         */
//        // 版本的更新信息
//        String version_info = "更新内容\n" + "    1. 车位分享异常处理\n" + "    2. 发布车位折扣格式统一\n" + "    ";
//        int mVersion_code = DeviceUtils.getVersionCode(mContext);// 当前的版本号
//        int nVersion_code = 2;
//        if (mVersion_code < nVersion_code) {
//            // 显示提示对话
//            showNoticeDialog(version_info);
//        } else {
//            if (isToast) {
//                Toast.makeText(mContext, "已经是最新版本", Toast.LENGTH_SHORT).show();
//            }
//        }


        if (service == null)
            service = ApiClient.getRetrofit().create(ApiService.class);
        service.checkVersion()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SubscriberCallBack(new HttpCallBack<UpdateAppInfo>() {
                    @Override
                    public void onHttpStart() {

                    }

                    @Override
                    public void onHttpSuccess(UpdateAppInfo model) {
                        int current_version_code = DeviceUtils.getVersionCode(mContext);// 当前的版本号
                        if (current_version_code < model.serverVersioncode) {
                            // 显示提示对话
                            showNoticeDialog(model.upgradeinfo);
                        } else {
                            if (isToast) {
                                Toast.makeText(mContext, "已经是最新版本", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }

                    @Override
                    public void onHttpFailure(int code, String msg) {

                    }

                    @Override
                    public void onHttpCompleted() {

                    }
                }));


    }

    /**
     * 显示更新对话框
     *
     * @param version_info
     */
    private void showNoticeDialog(String version_info) {
        // 构造对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("发现新版本");
        builder.setMessage(version_info);
        // 更新
        builder.setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent(mContext, DownLoadService.class);
                intent.putExtra("title","app名字");
                intent.putExtra("dwonload_url","下载地址");
                mContext.startService(intent);
            }
        });
        // 稍后更新
        builder.setNegativeButton("以后再说", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Dialog noticeDialog = builder.create();
        noticeDialog.show();
    }
}
