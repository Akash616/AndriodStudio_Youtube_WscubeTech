import 'package:http/http.dart' as http;

import '../models/current_apiData.dart'; //for network call

var currentLink = "https://dummyjson.com/products";

getCurrentData() async {
  var res = await http.get(Uri.parse(currentLink));
  if(res.statusCode == 200){
    var data = dummyDataApiFromJson(res.body.toString());
    print("Data received");
    return data;
  }
}