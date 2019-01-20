package com.example.hp.showroom;

import com.orm.SugarRecord;

public class User extends SugarRecord<User> {

    String name;
    String email;
    String number;
    String password;
    String confirmpassword;
    String latitude;
    String longitude;


    public User(){

    }

    public User(String name, String email, String number, String password, String confirmpassword, String latitude, String longitude) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
