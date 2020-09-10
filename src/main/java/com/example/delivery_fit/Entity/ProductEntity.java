package com.example.delivery_fit.Entity;

public class ProductEntity {

    int product_Image;
    String product_Name;
    String product_url;

    public ProductEntity(String product_url) {
        this.product_url = product_url;
    }

    public ProductEntity(int product_Image, String product_Name) {
        this.product_Image = product_Image;
        this.product_Name = product_Name;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "product_Image=" + product_Image +
                ", product_Name='" + product_Name + '\'' +
                '}';
    }

    public int getProduct_Image() {
        return product_Image;
    }

    public void setProduct_Image(int product_Image) {
        this.product_Image = product_Image;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public String getProduct_url() {
        return product_url;
    }

    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }
}
