package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;

public class SelfinvestmentResponse {
    @SerializedName("wallet_bal")
    private String walletBalance;
    @SerializedName("min_deposit")
    private String minimumDeposite;

    @SerializedName("prev_investment")
    private String previousInvestment;

    @SerializedName("invest_amount")
    private String investAmount;


    @SerializedName("success_msg")
    private String successMessage;

    @SerializedName("status")
    private int status;
    public String getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(String walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getMinimumDeposite() {
        return minimumDeposite;
    }

    public void setMinimumDeposite(String minimumDeposite) {
        this.minimumDeposite = minimumDeposite;
    }

    public String getPreviousInvestment() {
        return previousInvestment;
    }

    public void setPreviousInvestment(String previousInvestment) {
        this.previousInvestment = previousInvestment;
    }

    public String getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(String investAmount) {
        this.investAmount = investAmount;
    }



    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
