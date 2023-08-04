package com.networkcallapiapp.retrofitdemoexample.DemoTwo;

import static com.networkcallapiapp.retrofitdemoexample.DemoTwo.MainActivityTwo.api;

import com.networkcallapiapp.retrofitdemoexample.DemoTwo.api.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    //String api = "https://jsonplaceholder.typicode.com/photos";
    public static RetrofitInstance instance; //instance means object banana
    ApiInterface apiInterface;

    public RetrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //ab retrofit ko build karanga
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static RetrofitInstance getInstance() {
        if (instance == null) {
            instance = new RetrofitInstance();
        }
        return instance;
    }

}
