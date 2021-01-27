package com.aariyan.faster.Model;

//to show the data on Request Fragment under the Chat Navigation menu:
public class RequestListModel {

    private int id;
    private String date,name,orderNumber;
    private int productImage;
    private String productName,productPrice;

    public RequestListModel(){}

    public RequestListModel(int id, String date, String name, String orderNumber, int productImage, String productName, String productPrice) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.orderNumber = orderNumber;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
