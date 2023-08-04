package com.networkcallapiapp.retrofitdemoexample.DemoFourGeeksforGeeks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.networkcallapiapp.retrofitdemoexample.DemoFourGeeksforGeeks.api.RetrofitApi;
import com.networkcallapiapp.retrofitdemoexample.DemoFourGeeksforGeeks.modalclass.DataModal;
import com.networkcallapiapp.retrofitdemoexample.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityFour extends AppCompatActivity {

    String url = "https://reqres.in/api/";
    private EditText idEdtName, idEdtJob;
    private Button idBtnPost;
    private TextView idTvResponse;
    private ProgressBar idPbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_four);

        // initializing our views
        idEdtName = findViewById(R.id.idEdtName);
        idEdtJob = findViewById(R.id.idEdtJob);
        idBtnPost = findViewById(R.id.idBtnPost);
        idTvResponse = findViewById(R.id.idTvResponse);
        idPbLoading = findViewById(R.id.idPbLoading);

        // adding on click listener to our button.
        idBtnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the text field is empty or not.
                if (idEdtName.getText().toString().isEmpty() && idEdtJob.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivityFour.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to post the data and passing our name and job.
                postData(idEdtName.getText().toString(), idEdtJob.getText().toString());
            }
        });

    }

    private void postData(String name, String job) {

        // below line is for displaying our progress bar.
        idPbLoading.setVisibility(View.VISIBLE);

        // on below line we are creating a retrofit
        // builder and passing our base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();

        // below line is to create an instance for our retrofit api class.
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);

        // passing data from our text fields to our modal class.
        DataModal dataModal = new DataModal(name, job);

        // calling a method to create a post and passing our modal class.
        Call<DataModal> call = retrofitApi.createPost(dataModal);

        // on below line we are executing our method.
        call.enqueue(new Callback<DataModal>() {
            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {
                // this method is called when we get response from our api.
                //Toast.makeText(MainActivityFour.this, "Data added to API", Toast.LENGTH_SHORT).show();

                // below line is for hiding our progress bar.
                idPbLoading.setVisibility(View.GONE);

                // on below line we are setting empty text
                // to our both edit text.
                idEdtName.setText("");
                idEdtJob.setText("");

                // we are getting response from our body
                // and passing it to our modal class.
                DataModal responseFromAPI = response.body();

                // on below line we are getting our data from modal class and adding it to our string.
                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName()
                        + "\n" + "Job : " + responseFromAPI.getJob();

                //Log.e();
                Log.d("onResponse","Error messgae...."+response.code()); //.body()

                // below line we are setting our
                // string to our text view.
                //idTvResponse.setText(responseString);

                if (response.code() == 200 || response.code() == 201) {
                    Toast.makeText(MainActivityFour.this, "Data added to API", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivityFour.this, SecondActivityFour.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Data", responseString);
                    bundle.putString("Data2", responseFromAPI.getName());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.
                idTvResponse.setText("Error found is : " + t.getMessage());
            }
        });

    }
}