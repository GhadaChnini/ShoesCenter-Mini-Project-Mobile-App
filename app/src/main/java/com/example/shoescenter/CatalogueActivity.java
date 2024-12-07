package com.example.shoescenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CatalogueActivity extends BaseActivity {


    private GridView gridCategories;
    private CategoryAdapter categoryAdapter;
    private String[] categories = {"Men", "Women", "Kids", "Sports"};
    private int[] categoryImages = {
            R.drawable.men_image,
            R.drawable.women_image,
            R.drawable.kids_image,
            R.drawable.sports_image
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        gridCategories = findViewById(R.id.gridCategories);

        categoryAdapter = new CategoryAdapter(this, categories, categoryImages);
        gridCategories.setAdapter(categoryAdapter);

        gridCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CatalogueActivity.this, ProductListActivity.class);
                intent.putExtra("category", categories[position]);
                startActivity(intent);
            }
        });


    }




}
