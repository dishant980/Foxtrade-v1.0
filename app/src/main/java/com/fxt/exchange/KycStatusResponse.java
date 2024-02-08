package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KycStatusResponse {
    @SerializedName("getkycStatus")
    private String kycStatus;

    @SerializedName("countries")
    private List<Country> countries;

    public String getKycStatus() {
        return kycStatus;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public static class Country {
        private String country;
        private String name;
        private String code;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Country(String country, String name, String code, String createdAt, String updatedAt) {
            this.country = country;
            this.name = name;
            this.code = code;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }
    }
}

