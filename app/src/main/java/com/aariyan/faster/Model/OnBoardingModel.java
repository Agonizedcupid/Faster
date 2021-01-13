package com.aariyan.faster.Model;

//Model class that will contain Modeled Data for OnBoarding:
public class OnBoardingModel {

    private int image;
    private String title,description;

    public OnBoardingModel(){}

    public OnBoardingModel(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
