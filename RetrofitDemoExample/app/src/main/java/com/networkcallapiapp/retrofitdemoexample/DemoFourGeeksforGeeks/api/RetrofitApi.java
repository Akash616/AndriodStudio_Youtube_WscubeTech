package com.networkcallapiapp.retrofitdemoexample.DemoFourGeeksforGeeks.api;

import com.networkcallapiapp.retrofitdemoexample.DemoFourGeeksforGeeks.modalclass.DataModal;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

//Creating an Interface class for our API Call
public interface RetrofitApi {

    // as we are making a post request to post a data
    // so we are annotating it with post
    // and along with that we are passing a parameter as users
    @POST("users")

    //on below line we are creating a method to post our data.
    Call<DataModal> createPost(@Body DataModal dataModal);

    //Call - response
    //ResponseBody - if model is not there
    //Body - all data jara hai

}
