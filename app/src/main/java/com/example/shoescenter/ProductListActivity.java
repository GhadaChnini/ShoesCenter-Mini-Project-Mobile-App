package com.example.shoescenter;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductListActivity extends BaseActivity {

    private RecyclerView recyclerViewProducts;
    private ProductAdapter productAdapter;
    private String category;
    private List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        Objects.requireNonNull(getSupportActionBar()).show();
        category = getIntent().getStringExtra("category");

        Toast.makeText(this, "Category: " + category, Toast.LENGTH_SHORT).show();


        recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        // Use GridLayoutManager with 2 columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewProducts.setLayoutManager(gridLayoutManager);

        // Populate the product list based on the selected category
        populateProductList();

        // Set up ProductAdapter with an Add-to-Cart listener
        productAdapter = new ProductAdapter(this, productList, product -> {
            CartManager.getInstance().addToCart(product);
            Toast.makeText(this, product.getName() + " added to cart.", Toast.LENGTH_SHORT).show();
        });

        recyclerViewProducts.setAdapter(productAdapter);
    }

    // Populate the product list with sample data based on category
    private void populateProductList() {
        if ("Men".equals(category)) {
            productList.add(new Product("Men's Shoe 1", R.drawable.shoe1, "42", "Red", "50TND"));
            productList.add(new Product("Men's Shoe 2", R.drawable.shoe2, "43", "Blue", "60TND"));
        } else if ("Women".equals(category)) {
            productList.add(new Product("Women's Shoe 1", R.drawable.shoe3, "39", "Black", "70TND"));
            productList.add(new Product("Women's Shoe 2", R.drawable.shoe4, "40", "White", "80TND"));
        }
        // Add more categories and products as needed
    }


}
