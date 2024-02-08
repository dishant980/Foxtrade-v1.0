package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;

public class SubmitKycResponse {
    @SerializedName("getkycStatus")
    private String kycStatus;
    private String id;

    private String fname;
    private String lname;
    private String phone_no;

    private String dob;
    private String gender;
    private int country;
    private String state;
    private String city;
    private int pincode;
    private String address1;
    private String doc_type;
    private String doc_image_front;
    private String doc_image_back;
    private String photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    public String getDoc_image_front() {
        return doc_image_front;
    }

    public void setDoc_image_front(String doc_image_front) {
        this.doc_image_front = doc_image_front;
    }

    public String getDoc_image_back() {
        return doc_image_back;
    }

    public void setDoc_image_back(String doc_image_back) {
        this.doc_image_back = doc_image_back;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
    }
}
