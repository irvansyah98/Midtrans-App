package com.iervan.belajarmidtrans;

public class Product {
    private String imgaes;
    private String name;
    private int qty;
    private int price;
    private double rating;

    public Product(String imgaes, String name, int qty, int price, double rating) {
        this.imgaes = imgaes;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.rating = rating;
    }

    public String getImgaes() {
        return imgaes;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }
}
