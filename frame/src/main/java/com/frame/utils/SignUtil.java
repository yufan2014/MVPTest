package com.frame.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.DisplayMetrics;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 * 签名
 */

public class SignUtil {

    /**
     * 获取apk的签名
     * @param context
     * @param packageName
     * @return
     */
    public static String getAppSign(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> installedPackages = pm.getInstalledPackages(PackageManager.GET_SIGNATURES);
        for (PackageInfo info : installedPackages) {
            if (info.packageName.equals(packageName))
                return info.signatures[0].toCharsString();
        }
        return null;
    }

    /**
     * 获取apk的签名
     * @param path
     * @return
     */
    public static String getAppSign(String path) {
        //参数列表的类型
        Class<?>[] typeArgs = new Class[1];
        //参数列表的值
        Object[] valueArgs = new Object[1];


        try {
            //1 获取packageParser类
            Class<?> pkgParserCls = Class.forName("android.content.pm.PackageParser");

            //2 创建packageParser实例
            typeArgs[0] = String.class;
            Constructor<?> pkgParserCt = pkgParserCls.getConstructor(typeArgs);
            valueArgs[0] = path;
            Object pkgParser = pkgParserCt.newInstance(valueArgs);

            //3 获取packageParser类的parserPackage方法
            typeArgs = new Class[4];
            typeArgs[0] = File.class;
            typeArgs[1] = String.class;
            typeArgs[2] = DisplayMetrics.class;
            typeArgs[3] = int.class;
            Method parserPackageMethod = pkgParserCls.getDeclaredMethod("parserPackage", typeArgs);

            //4 执行parserPackage方法
            valueArgs = new Object[4];
            valueArgs[0] = new File(path);
            valueArgs[1] = path;
            DisplayMetrics metrics = new DisplayMetrics();
            metrics.setToDefaults();
            valueArgs[2] = metrics;
            valueArgs[3] = PackageManager.GET_SIGNATURES;
            Object pkgParserPkg = parserPackageMethod.invoke(valueArgs);


            //5 得到packageParser.Package实例
            //得到packageParser类的collectCertificates方法
            typeArgs = new Class[2];
            typeArgs[0] = pkgParserCls.getClass();
            typeArgs[1] = int.class;
            Method collectCertificates = pkgParserCls.getMethod("collectCertificates", typeArgs);

            //执行collectCertificates方法
            valueArgs = new Object[4];
            valueArgs[0] = pkgParserPkg;
            valueArgs[1] = PackageManager.GET_SIGNATURES;
            collectCertificates.invoke(pkgParser, valueArgs);

            //6 得到packageParser.Package类的mSignatures属性
            Field mSignaturesField = pkgParserPkg.getClass().getDeclaredField("mSignatures");

            //7 得到packageParser.Package类的mSignatures属性的值
            Signature[] signature = (Signature[]) mSignaturesField.get(pkgParserPkg);

            return signature[0].toCharsString();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }
}
