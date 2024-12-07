package com.example.shoescenter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CommandeActivity extends BaseActivity {

    private TextView tvCartItems, tvTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);

        tvCartItems = findViewById(R.id.tvCartItems);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);

        // Get cart items and display them
        List<Product> cartItems = CartManager.getInstance().getCartItems();
        StringBuilder itemsText = new StringBuilder();
        for (Product product : cartItems) {
            itemsText.append(product.getName())
                    .append(" - ")
                    .append(product.getPrice())
                    .append("\n");
        }
        tvCartItems.setText(itemsText.toString());

        // Calculate and display total price
        double totalPrice = CartManager.getInstance().getTotalPrice();
        tvTotalPrice.setText("Prix total : " + totalPrice + " TND");
    }
}
