package com.aariyan.faster.Model;

import com.aariyan.faster.Adapter.BusinessIndustryAdapter;

public class BusinessIndustriesModel {

    private int id;
    private String name;
    public BusinessIndustriesModel () {}

    public BusinessIndustriesModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
