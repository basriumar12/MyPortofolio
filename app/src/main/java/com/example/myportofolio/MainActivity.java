package com.example.myportofolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //buat variabel
    private String title = "Mode List";
    private RecyclerView rvPortofolio;
    private ArrayList<ModelPortofolio> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //iniisialisasi variabel
        rvPortofolio = findViewById(R.id.rv_main);
        rvPortofolio.setHasFixedSize(true);
        list.addAll(PortofolioData.getListData());
        showRecyclerList();
    }

    //inisialisasi recylerview dan menampilkan dalam bentuk list
    private void showRecyclerList() {
        rvPortofolio.setLayoutManager(new LinearLayoutManager(this));
        AdapterPortofolio listHeroAdapter = new AdapterPortofolio(list);
        rvPortofolio.setAdapter(listHeroAdapter);
        //list item ketika di klik
        listHeroAdapter.setOnItemClickCallback(new AdapterPortofolio.OnItemClickCallback() {
            @Override
            public void onItemClicked(ModelPortofolio data) {
                showSelectedPorotofolio(data);
            }
        });
    }
    //menampilkan grid
    private void showRecyclerGrid() {
        rvPortofolio.setLayoutManager(new GridLayoutManager(this,2));
        AdapterPortofolio listHeroAdapter = new AdapterPortofolio(list);
        rvPortofolio.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new AdapterPortofolio.OnItemClickCallback() {
            @Override
            public void onItemClicked(ModelPortofolio data) {
                showSelectedPorotofolio(data);
            }
        });
    }
// method item ketika klik dan mengirim datanya ke detailactivity
    private void showSelectedPorotofolio(ModelPortofolio data) {

        Toast.makeText(this, "Kamu memilih " + data.getName(), Toast.LENGTH_SHORT).show();
        //buat objek intent
        Intent kirimData = new Intent(this, DetailActivity.class);
       //kirim value

        kirimData.putExtra("NAME", data.getName());
        kirimData.putExtra("DETAIL", data.getDetail());
        kirimData.putExtra("IMAGE", data.getPhoto());
        startActivity(kirimData);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    //aktifkan mode di item menu
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;


        }
        setActionBarTitle(title);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

}
