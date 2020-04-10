import 'package:flutter/services.dart';

class VkAuth {
  static const platform = const MethodChannel('samples.flutter.dev/dogShare');

  static Future<void> signIn() async {
      try {
        final String result = await platform.invokeMethod('vkSignIn');
        print(result);
      } on PlatformException catch (e) {
      }
  }
}