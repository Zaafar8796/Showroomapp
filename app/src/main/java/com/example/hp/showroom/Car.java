package com.example.hp.showroom;

import com.orm.SugarRecord;

public class Car extends SugarRecord {

    String carname;
    String brandname;
    String model;
    String chasis;
    String variant;
    String transmission;
    String mileage;
    String city;
    String description;
    String image;
    String price;

    public Car(){

    }
//    public Car(String honda_city, String rs1500000) {
//
//    }

    public Car(String carname, String brandname, String model, String chasis, String variant, String transmission, String mileage, String city, String description, String image, String price) {
        this.carname = carname;
        this.brandname = brandname;
        this.model = model;
        this.chasis = chasis;
        this.variant = variant;
        this.transmission = transmission;
        this.mileage = mileage;
        this.city = city;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
