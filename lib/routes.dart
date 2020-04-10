
import 'package:dogshare/ui/homePage.dart';
import 'package:dogshare/ui/profilePage.dart';
import 'package:flutter/material.dart';
import 'package:dogshare/ui/counter.dart';

class Routes extends StatelessWidget {
  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      routes: <String, WidgetBuilder>{
        "/HomePage": (BuildContext context) => HomePage(),
        "/ProfilePage": (BuildContext context) => new ProfilePage(),
        "/Counter": (BuildContext context) => new Counter(),
      },
      home: BottomBar(),
    );
  }
}

class BottomBar extends StatefulWidget {
  BottomBar({Key key}) : super(key: key);

  @override
  BottomBarState createState() => BottomBarState();
}

class BottomBarState extends State<BottomBar> {
  int _selectedIndex = 0;
  static List<Widget> _widgetOptions = <Widget>[
    HomePage(),
    ProfilePage(),
  ];

  void _onItemTapped(int index) {
    setState(() {_selectedIndex = index;});
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // appBar: AppBar(
      //   title: const Text('BottomNavigationBar Sample'),
      // ),
      body: Center(
        child: _widgetOptions.elementAt(_selectedIndex),
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            title: Text('Home'),
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person),
            title: Text('Profile'),
          ),
        ],
        currentIndex: _selectedIndex,
        selectedItemColor: Colors.red,
        onTap: _onItemTapped,
      ),
    );
  }
}
