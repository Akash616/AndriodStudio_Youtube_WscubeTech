// To parse this JSON data, do
//
//     final dummyDataApi = dummyDataApiFromJson(jsonString);

import 'dart:convert';

DummyDataApi dummyDataApiFromJson(String str) => DummyDataApi.fromJson(json.decode(str));

class DummyDataApi {
    List<Product> products;

    DummyDataApi({
        required this.products,
    });

    factory DummyDataApi.fromJson(Map<String, dynamic> json) => DummyDataApi(
        products: List<Product>.from(json["products"].map((x) => Product.fromJson(x))),
    );

}

class Product {
    int id;
    String title;
    String description;
    int price;
    List<String> images;

    Product({
        required this.id,
        required this.title,
        required this.description,
        required this.price,
        required this.images,
    });

    factory Product.fromJson(Map<String, dynamic> json) => Product(
        id: json["id"],
        title: json["title"],
        description: json["description"],
        price: json["price"],
        images: List<String>.from(json["images"].map((x) => x)),
    );

}
