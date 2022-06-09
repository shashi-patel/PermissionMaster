package com.shashi.permissionmaster;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.shashi.permissionmaster.databinding.ActivityMainBinding;

import java.util.ArrayList;

import lib.shashi.permissions.PermissionHandler;
import lib.shashi.permissions.Permissions;

public class MainActivityJava extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(MainActivityJava.this, R.layout.activity_main);
        activityMainBinding.mbtnAllowPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Permissions.check(MainActivityJava.this, new String[]{Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, null, null, new PermissionHandler() {
                    @Override
                    public void onGranted() {
                        Toast.makeText(MainActivityJava.this, "Permission granted!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDenied(Context context, ArrayList<String> deniedPermissions) {
                        super.onDenied(context, deniedPermissions);
                        Toast.makeText(MainActivityJava.this, "Permission denied!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
