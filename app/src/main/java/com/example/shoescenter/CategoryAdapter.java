package com.example.shoescenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryAdapter extends BaseAdapter {

    private Context context;
    private String[] categories;
    private int[] categoryImages;

    public CategoryAdapter(Context context, String[] categories, int[] categoryImages) {
        this.context = context;
        this.categories = categories;
        this.categoryImages = categoryImages;
    }

    @Override
    public int getCount() {
        return categories.length;
    }

    @Override
    public Object getItem(int position) {
        return categories[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        }

        TextView categoryName = convertView.findViewById(R.id.categoryName);
        ImageView categoryImage = convertView.findViewById(R.id.categoryImage);

        categoryName.setText(categories[position]);
        categoryImage.setImageResource(categoryImages[position]);

        return convertView;
    }
}
