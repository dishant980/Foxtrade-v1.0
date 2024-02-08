package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;

public class BeneficiaryResponse {

    private int id;
    private String name;
    private int investment;
    private int wallet;

    @SerializedName("freeze_roi_generation")
    private int freezeRoiGeneration;

    @SerializedName("freeze_comm_on_roi_generation")
    private int freezeCommOnRoiGeneration;

    @SerializedName("freeze_comm_on_roi_of_parents")
    private int freezeCommOnRoiOfParents;

    @SerializedName("profile_photo_url")
    private String profilePhotoUrl;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getInvestment() {
        return investment;
    }

    public int getWallet() {
        return wallet;
    }

    public int getFreezeRoiGeneration() {
        return freezeRoiGeneration;
    }

    public int getFreezeCommOnRoiGeneration() {
        return freezeCommOnRoiGeneration;
    }

    public int getFreezeCommOnRoiOfParents() {
        return freezeCommOnRoiOfParents;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

}

