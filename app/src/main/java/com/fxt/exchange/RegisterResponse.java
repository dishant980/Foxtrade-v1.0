package com.fxt.exchange;

public class RegisterResponse {

    public String refer_code;
    String error;
    String status;
    String name;

    public RegisterResponse(String error, String message) {
        this.error = error;
        this.status=error;
        this.name=name;

    }

    public String getGetrefer_code() {
        return refer_code;
    }

    public void setGetrefer_code(String getrefer_code) {
        this.refer_code = getrefer_code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
