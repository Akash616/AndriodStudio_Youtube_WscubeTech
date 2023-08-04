package com.networkcallapiapp.retrofitdemoexample.DemoOne;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.networkcallapiapp.retrofitdemoexample.DemoOne.adapter.PostsAdapter;
import com.networkcallapiapp.retrofitdemoexample.DemoOne.api.RetrofitClient;
import com.networkcallapiapp.retrofitdemoexample.DemoOne.modalclass.Posts;
import com.networkcallapiapp.retrofitdemoexample.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityOne extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager layoutManager;
    PostsAdapter adapter;
    List<Posts> postsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_one);

       recyclerView = findViewById(R.id.recyclerView);
       progressBar = findViewById(R.id.progressBar);

       layoutManager = new LinearLayoutManager(this);
       recyclerView.setLayoutManager(layoutManager);

       adapter = new PostsAdapter(postsList);
       recyclerView.setAdapter(adapter);

       fetchPosts();

    }

    private void fetchPosts(){
        progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getRetrofitClient().getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {

                if(response.isSuccessful() && response.body() != null){
                    postsList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivityOne.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}