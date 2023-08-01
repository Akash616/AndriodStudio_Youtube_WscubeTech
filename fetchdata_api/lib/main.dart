import 'package:fetchdata_api/services/api_services.dart';
import 'package:flutter/material.dart';

import 'models/current_apiData.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(primarySwatch: Colors.deepPurple),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text("Fetching data from API"),
        ),
        body: FutureBuilder(
          future: getCurrentData(),
          builder: (context, snapshot) {
            if (snapshot.hasData) {
              var data = snapshot.data as DummyDataApi;

              return SingleChildScrollView(
                  physics: const BouncingScrollPhysics(),
                  child: ListView.builder(
                  itemCount: data.products.length,
                  itemBuilder: (context, index) {
                    return Card(
                      child: Padding(
                        padding: EdgeInsets.all(8.0),
                        child: ListTile(
                          leading: Image.network(data.products[index].images[index], width: 90,height: 90,),
                          title: Text(data.products[index].title),
                          subtitle: Text(data.products[index].description),
                          trailing: Text(data.products[index].price.toString()),
                        ),
                      ),
                    );
                  },
                  ));
            } else {
              return const Center(child: CircularProgressIndicator());
            }
          },
        ));
  }
}
