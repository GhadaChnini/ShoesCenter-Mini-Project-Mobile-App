package com.example.shoescenter;

public class Product {
    private String name;
    private int imageResId;
    private String size;
    private String color;
    private String price;

    public Product(String name, int imageResId, String size, String color, String price) {
        this.name = name;
        this.imageResId = imageResId;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getPrice() {
        return price;
    }
}
