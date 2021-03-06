import 'package:dogshare/services/vkApi.dart';
import 'package:flutter/material.dart';

class ProfilePage extends StatelessWidget {
  
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.red,
          title: Text("ProfilePage"),
        ),
        body: Container(
          width: double.infinity,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Text("ProfilePage"),
              new Padding(
                padding: const EdgeInsets.only(top: 16.0),
                child: new FlatButton.icon(
                  onPressed: () {
                    // Navigator.of(context).pushNamed("/Counter");
                    VkAuth.signIn();
                  },
                  color: Colors.red,
                  textColor: Colors.white,
                  icon: const Icon(Icons.navigate_next, size: 18.0),
                  label: const Text('SignIn'),
                ),
              ),
              new FlatButton.icon(
                  onPressed: () {
                    // Navigator.of(context).pushNamed("/Counter");
                    VkAuth.vkGetUsers();
                  },
                  color: Colors.red,
                  textColor: Colors.white,
                  icon: const Icon(Icons.navigate_next, size: 18.0),
                  label: const Text('vkGetUsers'),
                ),
                new FlatButton.icon(
                  onPressed: () {
                    // Navigator.of(context).pushNamed("/Counter");
                    VkAuth.vkGetProfile();
                  },
                  color: Colors.red,
                  textColor: Colors.white,
                  icon: const Icon(Icons.navigate_next, size: 18.0),
                  label: const Text('vkGetProfile'),
                ),
            ],
          ),
        ),
    );
  }
}