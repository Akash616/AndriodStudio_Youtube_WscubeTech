package com.networkcallapiapp.retrofitdemoexample.DemoOne.api;

import androidx.annotation.CallSuper;

import com.networkcallapiapp.retrofitdemoexample.DemoOne.modalclass.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/posts")
    Call<List<Posts>> getPosts();

}
