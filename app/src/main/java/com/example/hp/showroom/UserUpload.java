package com.example.hp.showroom;

public class UserUpload {

    private String username;
    private String email;
    private String contact;
    private String password;
    private String confirmpassword;
    private String latitude;
    private String longitude;


    public UserUpload() {
        //empty constructor needed
    }

    public UserUpload(String username, String email, String contact, String password, String confirmpassword, String latitude, String longitude) {
        this.username = username;
        this.email = email;
        this.contact = contact;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

