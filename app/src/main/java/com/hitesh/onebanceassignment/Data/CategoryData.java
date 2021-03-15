package com.hitesh.onebanceassignment.Data;

public class CategoryData {

    private String cuisineName;
    private String imageName;

    public CategoryData(String cuisineName, String imageName) {
        this.cuisineName = cuisineName;
        this.imageName = imageName;

    }

    public String getImageName() {
        return imageName;
    }

    public String getCuisineName() {
        return cuisineName;
    }
}
