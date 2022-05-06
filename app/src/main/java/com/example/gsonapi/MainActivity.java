package com.example.gsonapi;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public final String URL="https://jsonplaceholder.typicode.com/posts";
    RecyclerView list;
    RecyclerAdapter adapter;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.list);
        

        ApiInterface apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        apiInterface.getData().enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                List<Example> datalist1=response.body();

                adapter = new RecyclerAdapter(MainActivity.this,datalist1);
                list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                list.setAdapter(adapter);
                Toast.makeText(MainActivity.this, "data is add", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Data is failed = "+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ############# "+t.getMessage() );
            }
        });



    }
}