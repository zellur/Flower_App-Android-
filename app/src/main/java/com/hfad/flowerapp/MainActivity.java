package com.hfad.flowerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hfad.flowerapp.FlowerClass.FlowerAdapter;
import com.hfad.flowerapp.FlowerClass.FlowerResponse;
import com.hfad.flowerapp.FlowerClass.FlowerService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://services.hanselandpetal.com/";
    private FlowerService service;
    private ListView listView;
    private FlowerAdapter adapter;
    private List<FlowerResponse> flowers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.flowerList);

      Retrofit retrofit = new Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .build();

      service = retrofit.create(FlowerService.class);

        Call<List<FlowerResponse>> flowerCall =service.getFlowerResponse();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FlowerResponse response = flowers.get(position);
                startActivity(new Intent(MainActivity.this,FlowerDetail.class)
                .putExtra("flowers",response));
            }
        });

        flowerCall.enqueue(new Callback<List<FlowerResponse>>() {
            @Override
            public void onResponse(Call<List<FlowerResponse>> call, Response<List<FlowerResponse>> response) {
                if(response.code() == 200){

                 flowers = response.body();
                   // Toast.makeText(MainActivity.this, ""+flowers.size(), Toast.LENGTH_SHORT).show();
                    adapter = new FlowerAdapter(MainActivity.this,flowers);
                    listView.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<List<FlowerResponse>> call, Throwable t) {

            }
        });

    }
}
