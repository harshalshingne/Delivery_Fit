package com.example.delivery_fit.Entity;

public class BannerEntity {
    int backgroundColor;

    public BannerEntity(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public String toString() {
        return "BannerEntity{" +
                "backgroundColor=" + backgroundColor +
                '}';
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
