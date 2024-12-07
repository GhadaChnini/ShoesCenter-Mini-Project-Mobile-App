package com.example.shoescenter;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId(); // Get the ID of the selected menu item

        if (id == R.id.menuHome) {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        } else if (id == R.id.menuCatalogue) {
            // No need to do anything here for the main "Catalogue" item
            return true;
        } else if (id == R.id.menuMen) {
            // Open ProductListActivity with "Men" category
            openCategory("Men");
            return true;
        } else if (id == R.id.menuWomen) {
            // Open ProductListActivity with "Women" category
            openCategory("Women");
            return true;
        } else if (id == R.id.menuKids) {
            // Open ProductListActivity with "Kids" category
            openCategory("Kids");
            return true;
        } else if (id == R.id.menuSports) {
            // Open ProductListActivity with "Kids" category
            openCategory("Sports");
            return true;
        }else if (id == R.id.menuContact) {
            startActivity(new Intent(this, ContactActivity.class));
            return true;
        } else if (id == R.id.menuCommande) {
            startActivity(new Intent(this, CommandeActivity.class));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    // Helper method to start ProductListActivity with the selected category
    private void openCategory(String category) {
        Intent intent = new Intent(this, ProductListActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}
