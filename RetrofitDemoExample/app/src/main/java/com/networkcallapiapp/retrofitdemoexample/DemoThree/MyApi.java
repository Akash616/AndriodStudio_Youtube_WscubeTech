package com.networkcallapiapp.retrofitdemoexample.DemoThree;

import com.networkcallapiapp.retrofitdemoexample.DemoThree.modelclass.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {

    //Retrofit bolta hai, ki aap method ka declaration bana ka rakhiya,
    //jo kya karega, ak retrofit ka Call ko return karega.

    //---------------------------------------------------------------------------------------------------------------
    @GET("posts") //Data kis page mai mil raha hai, posts wala mai
    //Call return karega, List type ka, or woh List kis type ka hoga PostsModel class type ka.
    Call<List<PostsModel>> getModels(); //function declare - getModels()

}
