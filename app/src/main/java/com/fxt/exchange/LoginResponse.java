package com.fxt.exchange;

public class LoginResponse extends UserResponse {

    private String email;
    private String name;
    private int refer_code;
    private String password;
     static String Token;

    private int id;
    private String created_at;
    private String updated_at;


    public static String Token() {
        return Token;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRefer_code() {
        return refer_code;
    }

    public void setRefer_code(int refer_code)
    {
        this.refer_code = refer_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String string() {
        return string();
    }


    }

