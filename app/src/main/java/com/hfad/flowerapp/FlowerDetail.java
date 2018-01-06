package com.hfad.flowerapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.flowerapp.FlowerClass.FlowerResponse;
import com.squareup.picasso.Picasso;

public class FlowerDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_detail);

        ImageView img = findViewById(R.id.image);
        TextView tex = findViewById(R.id.text);

        FlowerResponse response = (FlowerResponse) getIntent().getSerializableExtra("flowers");


        String flowerUrl = "photos/"+response.getPhoto();
        Uri flowerUri = Uri.parse(MainActivity.BASE_URL+flowerUrl);
        Picasso.with(this).load(flowerUri).into(img);

        tex.setText(response.getName()+"\n"+
        response.getCategory()+"\n"+
        response.getInstructions()+"\n"+
        response.getPrice());


    }
}
