package com.example.myportofolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail app");

        //inisialisasi
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvDetail = findViewById(R.id.tv_detail);
        ImageView imgApp = findViewById(R.id.img_detail);
        //get data yang dikriim dari MainActivity
        Intent terimaData = getIntent();
        tvName.setText(terimaData.getStringExtra("NAME"));
        tvDetail.setText(terimaData.getStringExtra("DETAIL"));
        Glide.with(this)
                .load(terimaData.getIntExtra("IMAGE",1))
                .apply(new RequestOptions().override(350, 550))
                .into(imgApp);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
