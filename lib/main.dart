
import 'package:dogshare/routes.dart';
import 'package:dogshare/ui/counter.dart';
import 'package:dogshare/ui/homePage.dart';
import 'package:dogshare/ui/profilePage.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      routes: <String, WidgetBuilder>{
        "/HomePage": (BuildContext context) => HomePage(),
        "/ProfilePage": (BuildContext context) => new ProfilePage(),
        "/Counter": (BuildContext context) => new Counter(),
      },
      home: Routes(),
    );
  }
}