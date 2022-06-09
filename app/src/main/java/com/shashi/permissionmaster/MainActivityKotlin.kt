package com.shashi.permissionmaster

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.shashi.permissionmaster.databinding.ActivityMainBinding
import lib.shashi.permissions.PermissionHandler
import lib.shashi.permissions.Permissions

class MainActivityKotlin : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding =
            DataBindingUtil.setContentView(this@MainActivityKotlin, R.layout.activity_main)
        activityMainBinding.mbtnAllowPermission.setOnClickListener {
            Permissions.check(
                this@MainActivityKotlin,
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                null,
                null,
                object : PermissionHandler() {
                    override fun onGranted() {
                        // do your task.
                        Toast.makeText(
                            this@MainActivityKotlin,
                            "Permission granted!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }

                    override fun onDenied(
                        context: Context?,
                        deniedPermissions: java.util.ArrayList<String>?
                    ) {
                        super.onDenied(context, deniedPermissions)
                        // do your task.
                        Toast.makeText(
                            this@MainActivityKotlin,
                            "Permission denied!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                })
        }
    }
}