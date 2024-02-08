package com.fxt.exchange;

import java.io.Serializable;

public class JsonResponse {
    private String status;
    private User user;
    private Authorisation authorisation;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Authorisation getAuthorisation() {
        return authorisation;
    }

    public void setAuthorisation(Authorisation authorisation) {
        this.authorisation = authorisation;
    }


}

 class User  implements Serializable {
    private int id;
    private String name;
    private String email;
    private long refer_code;
    private long referred_by;
    private String trading_no;
    private String trc_no;
    private String email_verified_at;
    private String two_factor_confirmed_at;
    private String key;
    private String current_team_id;
    private String profile_photo_path;
    private String status;
    private String deleted_at;
    private String created_at;
    private String updated_at;
    private String profile_photo_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getRefer_code() {
        return refer_code;
    }

    public void setRefer_code(long refer_code) {
        this.refer_code = refer_code;
    }

    public long getReferred_by() {
        return referred_by;
    }

    public void setReferred_by(long referred_by) {
        this.referred_by = referred_by;
    }

    public String getTrading_no() {
        return trading_no;
    }

    public void setTrading_no(String trading_no) {
        this.trading_no = trading_no;
    }

    public String getTrc_no() {
        return trc_no;
    }

    public void setTrc_no(String trc_no) {
        this.trc_no = trc_no;
    }

    public String getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(String email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public String getTwo_factor_confirmed_at() {
        return two_factor_confirmed_at;
    }

    public void setTwo_factor_confirmed_at(String two_factor_confirmed_at) {
        this.two_factor_confirmed_at = two_factor_confirmed_at;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCurrent_team_id() {
        return current_team_id;
    }

    public void setCurrent_team_id(String current_team_id) {
        this.current_team_id = current_team_id;
    }

    public String getProfile_photo_path() {
        return profile_photo_path;
    }

    public void setProfile_photo_path(String profile_photo_path) {
        this.profile_photo_path = profile_photo_path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
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

    public String getProfile_photo_url() {
        return profile_photo_url;
    }

    public void setProfile_photo_url(String profile_photo_url) {
        this.profile_photo_url = profile_photo_url;
    }
}

class Authorisation {
    private String token;
    private String type;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


