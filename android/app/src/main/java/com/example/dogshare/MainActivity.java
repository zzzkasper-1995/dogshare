package com.example.dogshare;

import androidx.annotation.NonNull;

import com.vk.api.sdk.VK;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.GeneratedPluginRegistrant;

import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
  private static final String CHANNEL = "samples.flutter.dev/dogShare";

  @Override
  public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    GeneratedPluginRegistrant.registerWith(flutterEngine);
    
    new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
          .setMethodCallHandler(
                  (call, result) -> {
                    if (call.method.equals("vkSignIn")) {
                      String res = vkSignIn();
                      result.success(res);
                    }
                  }
          );
  }

  private String vkSignIn() {
          VK.login(this);
          return "vkSignIn success";
  }
}
