package com.networkcallapiapp.retrofitdemoexample.DemoOne.modalclass;

public class Posts {

    //you have to create the same name as your json response.
    //But if you want to change variable name, so you need to add an notation : @SerializedName()
    private String title;
    private String body;

    public Posts(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

}
