package com.hitesh.onebanceassignment.Data;

public class DishData {

    private String FoodName;
    private String imageName;
    private String price;
    private int count;

    public DishData(String foodName, String imageName, String price, int count) {
        FoodName = foodName;
        this.imageName = imageName;
        this.price = price;
        this.count = count;
    }

    public String getFoodName() {
        return FoodName;
    }

    public String getImageName() {
        return imageName;
    }

    public String getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void increCount() {
        this.count++;
    }

    public void dcreCount() {
        this.count--;
    }
}
