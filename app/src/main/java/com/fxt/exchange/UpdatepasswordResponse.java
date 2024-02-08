package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;

public class UpdatepasswordResponse {
    @SerializedName("success_msg")
    private String successMessage;
    @SerializedName("current_password")
    private String currentPassword;

    @SerializedName("password")
    private String password;

    @SerializedName("password_confirmation")
    private String confirmPassword;

    @SerializedName("status")
    private int status;

    public UpdatepasswordResponse(String successMessage, String currentPassword, String password, String confirmPassword, int status) {
        this.successMessage = successMessage;
        this.currentPassword = currentPassword;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.status = status;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
