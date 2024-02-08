package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;

public class updatePassword {

    @SerializedName("current_password")
    private String currentPassword;

    @SerializedName("password")
    private String password;

    @SerializedName("password_confirmation")
    private String confirmPassword;


    @SerializedName("id")
    private int UserId;


    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
