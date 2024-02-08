package com.fxt.exchange;

import java.io.Serializable;

public class UserDetails implements Serializable {
    private String name;
    private String refer_code;

    public UserDetails(String name, String refer_code){
        this.name=name;
        this.refer_code=refer_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRefer_code() {
        return refer_code;
    }

    public void setRefer_code(String refer_code) {
        this.refer_code = refer_code;
    }
}
