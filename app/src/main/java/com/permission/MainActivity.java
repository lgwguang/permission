package com.permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_PERMISSION = 0x01;
    public static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void requestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG,ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)+"");

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_PERMISSION);

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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_PERMISSION: {
                if(grantResults.length == 0){
                    Log.d(TAG, "用户取消了权限弹窗");
                    return;
                }

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "权限请求通过");
                } else {
                    Log.d(TAG, "权限请求失败");
                }

                // 用户拒绝了某些权限
                for (int x : grantResults) {
                    Log.d(TAG, x + "");
                    if (x == PackageManager.PERMISSION_DENIED) {
                        Log.d(TAG, "用户拒绝了某些权限");
                        return;
                    }
                }



                return;
            }
        }
    }

    public void request(View view) {
        PermissionUtils.requestPermissions(this);

    }
}
