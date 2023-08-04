package com.networkcallapiapp.retrofitdemoexample.DemoThree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.networkcallapiapp.retrofitdemoexample.DemoThree.modelclass.PostsModel;
import com.networkcallapiapp.retrofitdemoexample.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityThree extends AppCompatActivity {

    TextView tvOne;
    String url = "https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_three);

        tvOne = findViewById(R.id.tvOne);
        tvOne.setText("");

        // 1. Model Class of json data
        //----------------------------------------------------------------------------------------------------------------------
        // 2. Interface - Call
        //-----------------------------------------------------------------------------------------------------------------------
        // 3. Retrofit object creation
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //-----------------------------------------------------------------------------------------------------------------------
        // 4. Convert json data to model class object
        MyApi myApi = retrofit.create(MyApi.class);
        //Hum na usko bata diya hai, json ka jo data hoga woh kis mai convert hoga - MyApi.class
        //------------------------------------------------------------------------------------------------------------------------
        // 5. Create a Call of model class and enqueue for processing
        Call<List<PostsModel>>  call = myApi.getModels();
        call.enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
                // 6. receive response data in simple model type list
                List<PostsModel> data = response.body();
                for(int i=0; i<data.size(); i++)
                    tvOne.append(" ID : "+data.get(i).getId()+" \n Title : "+data.get(i).getTitle()+"\n\n\n");
            }

            @Override
            public void onFailure(Call<List<PostsModel>> call, Throwable t) {
                Toast.makeText(MainActivityThree.this,"OnFailure..", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------------------------------------------------------------------

    }
}