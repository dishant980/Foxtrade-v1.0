package com.fxt.exchange;

public class UserResponse<Authorization> {
    private String status;
    private User user;
    private Authorization authorization;

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }


}
