package com.example.saloon_version_0.pojo;

import java.io.Serializable;

public class Products implements Serializable {
    private String product_Id;
    private String product_Name;
    private Double price;
    private String gender;
    private  String description;

    public Products() {
    }

    public Products(String product_Id, String product_Name, Double price, String gender,String description) {
        this.product_Id = product_Id;
        this.product_Name = product_Name;
        this.price = price;
        this.gender = gender;
        this.description = description;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(String product_Id) {
        this.product_Id = product_Id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Products{" +
                "product_Id='" + product_Id + '\'' +
                ", product_Name='" + product_Name + '\'' +
                ", price=" + price +
                ", gender='" + gender + '\'' +
                '}';
    }
}
