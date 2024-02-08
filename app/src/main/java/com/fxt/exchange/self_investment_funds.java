package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;

public class self_investment_funds
{
    @SerializedName("wallet_bal")
    private String walletBalance;
    @SerializedName("min_deposit")
    private String minimumDeposite;

    @SerializedName("prev_investment")
    private String previousInvestment;

    @SerializedName("invest_amount")
    private String investAmount;

    @SerializedName("id")
    private int UserId;


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

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
