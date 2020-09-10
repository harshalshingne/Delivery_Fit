package com.example.delivery_fit.Entity;

public class CategoryEntity {

    String catName;
    int catIcon;
    int catBackground;

    public CategoryEntity(String catName, int catIcon, int catBackground) {
        this.catName = catName;
        this.catIcon = catIcon;
        this.catBackground = catBackground;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "catName='" + catName + '\'' +
                ", catIcon=" + catIcon +
                ", catBackground=" + catBackground +
                '}';
    }

    public int getCatBackground() {
        return catBackground;
    }

    public void setCatBackground(int catBackground) {
        this.catBackground = catBackground;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatIcon() {
        return catIcon;
    }

    public void setCatIcon(int catIcon) {
        this.catIcon = catIcon;
    }
}

