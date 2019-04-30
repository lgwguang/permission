package com.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * author： liguangwei
 * date： 2019/04/30
 * Email： ligw@wanbu.com.cn
 **/
public class PermissionUtils {

    public static String TAG = PermissionUtils.class.getSimpleName();
    public static final int REQUEST_PERMISSION = 0x01;


    public static void requestPermissions(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_CONTACTS)+"");
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_PERMISSION);

            //第一次返回false；拒绝后再次点击会返回true;勾选不再询问后返回false;
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
//                Log.d(TAG, "shouldShowRequestPermissionRationale");
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_PERMISSION);
//            } else {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_PERMISSION);
//                Log.d(TAG, "requestPermissions");
//            }
        }
    }




}
