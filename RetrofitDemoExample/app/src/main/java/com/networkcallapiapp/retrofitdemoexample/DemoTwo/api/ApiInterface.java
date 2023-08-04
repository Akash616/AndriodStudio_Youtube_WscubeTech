package com.networkcallapiapp.retrofitdemoexample.DemoTwo.api;

import com.networkcallapiapp.retrofitdemoexample.DemoTwo.ModalClass.UserModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    //ab retrofit toh build hogaya, ab isko batana bhi padega hum kaunsa response lare hai
    //or kasa lara hai. Toh uska liya Interface bana padta hai. (ApiInterface)

    @GET("/photos")
    //jab bhi koi yaha pai( @GET("/photos") ) request balta hai, toh mujha ak list milna chahiya.
    //Bec. json response is coming in List, of type Modal class.
    Call<List<UserModal>> getUsers();

}
