package com.example.dogshare

import android.content.Intent
import android.util.Log
import androidx.annotation.NonNull
import com.example.dogshare.VKLib.meth.Meth
import com.vk.api.sdk.VK

import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant


class MainActivity: FlutterActivity() {
    private val CHANNEL = "samples.flutter.dev/dogShare"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL)
                .setMethodCallHandler { call: MethodCall, result: MethodChannel.Result ->
                    if (call.method == "vkSignIn") {
                        Log.d("MethodChannel", "vkSignIn");
                        vkSignIn()
                        result.success({})
                    }
                    if (call.method == "vkGetUsers") {
                        Log.d("MethodChannel", "vkGetUsers");
                        Meth().getUsers()
                        result.success({})
                    }
                    if (call.method == "vkGetProfile") {
                        Log.d("MethodChannel", "vkGetProfile");
                        Meth().getProfile()
                        result.success({})
                    }
                }
    }

    // VK API
    private fun vkSignIn() {
        VK.login(this)
    }

    // VK API
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object: VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                Log.d("vkSignIn", "onLogin");
            }

            override fun onLoginFailed(errorCode: Int) {
                Log.d("vkSignIn", "onLoginFailed");
            }
        }
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
