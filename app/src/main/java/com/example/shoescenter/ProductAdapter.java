package com.example.shoescenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    public interface OnAddToCartClickListener {
        void onAddToCart(Product product);
    }

    private final Context context;
    private final List<Product> productList;
    private final OnAddToCartClickListener addToCartClickListener;

    // Updated constructor to include the listener
    public ProductAdapter(Context context, List<Product> productList, OnAddToCartClickListener addToCartClickListener) {
        this.context = context;
        this.productList = productList;
        this.addToCartClickListener = addToCartClickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productName.setText(product.getName());
        holder.productImage.setImageResource(product.getImageResId());


        // Add listener for product image click
        holder.productImage.setOnClickListener(v -> {
            showProductDetailsDialog(product);
        });

        holder.addToCartButton.setOnClickListener(v -> {
            CartManager.getInstance().addToCart(product);
            Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show();
        });
    }

    // Method to show the product details in a dialog
    private void showProductDetailsDialog(Product product) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(product.getName());
        builder.setMessage(
                "Size: " + product.getSize() + "\n" +
                        "Color: " + product.getColor() + "\n" +
                        "Price: " + product.getPrice()
        );
        builder.setPositiveButton("Close", (dialog, which) -> dialog.dismiss());
        builder.show();
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        ImageView productImage;
        Button addToCartButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productImage = itemView.findViewById(R.id.productImage);
            addToCartButton = new Button(itemView.getContext());
            addToCartButton.setText("Add to Cart");
            ((ViewGroup) itemView).addView(addToCartButton);
        }
    }
}
