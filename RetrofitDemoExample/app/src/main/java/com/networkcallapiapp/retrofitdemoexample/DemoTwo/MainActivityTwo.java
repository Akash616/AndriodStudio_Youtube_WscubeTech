package com.networkcallapiapp.retrofitdemoexample.DemoTwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.networkcallapiapp.retrofitdemoexample.DemoTwo.ModalClass.UserModal;
import com.networkcallapiapp.retrofitdemoexample.DemoTwo.adapter.UserAdapter;
import com.networkcallapiapp.retrofitdemoexample.DemoTwo.api.ApiInterface;
import com.networkcallapiapp.retrofitdemoexample.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityTwo extends AppCompatActivity {

    public static String api = "https://jsonplaceholder.typicode.com"; //base url
    List<UserModal> allUsersList;
    RecyclerView rcvMain;

    ProgressBar progressBarTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        rcvMain = findViewById(R.id.rcvMain);
        progressBarTwo = findViewById(R.id.progressBarTwo);
        rcvMain.setLayoutManager(new LinearLayoutManager(this));


        progressBarTwo.setVisibility(View.VISIBLE);
        //Now Let's Call API
        RetrofitInstance.getInstance().apiInterface.getUsers().enqueue(new Callback<List<UserModal>>() {
            @Override
            public void onResponse(Call<List<UserModal>> call, Response<List<UserModal>> response) {
                //Log.e("Api", "onResponse" + response.body().toString()); it will print modal, not data
                //allUsersList = response.body(); //it store data into list

                //for(int i=0; i<allUsersList.size(); i++){ //check in logcat
                //    Log.e("Api", "onResponse "+ allUsersList.get(i).getTitle());
                //}

                if(response.isSuccessful() && response.body() != null){
                    allUsersList = response.body();
                    rcvMain.setAdapter(new UserAdapter(MainActivityTwo.this, allUsersList));
                    progressBarTwo.setVisibility(View.GONE);
                }

               // rcvMain.setAdapter(new UserAdapter(MainActivityTwo.this, allUsersList));

            }

            @Override
            public void onFailure(Call<List<UserModal>> call, Throwable t) {
                Log.e("Api", "onFailure: " + t.getLocalizedMessage());
            }
        });

    }
}