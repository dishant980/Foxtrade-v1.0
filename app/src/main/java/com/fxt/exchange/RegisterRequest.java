package com.fxt.exchange;

public class RegisterRequest {

    private String name;
    private String email;
    private String referred_by;
    private String password;
    private String phone_number;

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

    public String getReferred_by() {
        return referred_by;
    }

    public void setReferred_by(String referred_by) {
        this.referred_by = referred_by;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
