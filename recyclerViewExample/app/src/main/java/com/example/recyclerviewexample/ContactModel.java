package com.example.recyclerviewexample;

public class ContactModel {
    //Structure Class/Modal class/SuiteCase class
    //Online image - url(String)
    //drawable folder - int(path => R.drawable.img_name)
    //Variable - One Integer(Image) and two Strings(Contact and contact number)
    int img;
    String name, number;

    //Constructor or getter and setter
    public ContactModel(int img, String name, String number){
        this.name = name;
        this.number = number;
        this.img = img;
    }

    public ContactModel(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
