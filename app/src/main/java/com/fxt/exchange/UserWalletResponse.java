package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserWalletResponse {

    @SerializedName("userWalletBal")
    private UserWalletBalance userWalletBalance;

    @SerializedName("fundRequests")
    private List<FundRequest> fundRequests;

    @SerializedName("min_deposit")
    private ConfigValue minDeposit;

    @SerializedName("max_total_income")
    private ConfigValue maxTotalIncome;


    public UserWalletBalance getUserWalletBalance() {
        return userWalletBalance;
    }

    public void setUserWalletBalance(UserWalletBalance userWalletBalance) {
        this.userWalletBalance = userWalletBalance;
    }

    public List<FundRequest> getFundRequests() {
        return fundRequests;
    }

    public void setFundRequests(List<FundRequest> fundRequests) {
        this.fundRequests = fundRequests;
    }

    public ConfigValue getMinDeposit() {
        return minDeposit;
    }

    public void setMinDeposit(ConfigValue minDeposit) {
        this.minDeposit = minDeposit;
    }

    public ConfigValue getMaxTotalIncome() {
        return maxTotalIncome;
    }

    public void setMaxTotalIncome(ConfigValue maxTotalIncome) {
        this.maxTotalIncome = maxTotalIncome;
    }

    public static class UserWalletBalance {

        @SerializedName("id")
        private int id;

        @SerializedName("user_id")
        private int userId;

        @SerializedName("wallet")
        private double wallet;

        @SerializedName("investment")
        private double investment;

        @SerializedName("roi")
        private double roi;

        @SerializedName("commission_on_roi")
        private double commissionOnRoi;

        @SerializedName("direct_reward")
        private double directReward;

        @SerializedName("team_reward")
        private double teamReward;

        @SerializedName("founders_club")
        private double foundersClub;

        @SerializedName("invested_msg")
        private String investedMessage;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public double getWallet() {
            return wallet;
        }

        public void setWallet(double wallet) {
            this.wallet = wallet;
        }

        public double getInvestment() {
            return investment;
        }

        public void setInvestment(double investment) {
            this.investment = investment;
        }

        public double getRoi() {
            return roi;
        }

        public void setRoi(double roi) {
            this.roi = roi;
        }

        public double getCommissionOnRoi() {
            return commissionOnRoi;
        }

        public void setCommissionOnRoi(double commissionOnRoi) {
            this.commissionOnRoi = commissionOnRoi;
        }

        public double getDirectReward() {
            return directReward;
        }

        public void setDirectReward(double directReward) {
            this.directReward = directReward;
        }

        public double getTeamReward() {
            return teamReward;
        }

        public void setTeamReward(double teamReward) {
            this.teamReward = teamReward;
        }

        public double getFoundersClub() {
            return foundersClub;
        }

        public void setFoundersClub(double foundersClub) {
            this.foundersClub = foundersClub;
        }

        public String getInvestedMessage() {
            return investedMessage;
        }

        public void setInvestedMessage(String investedMessage) {
            this.investedMessage = investedMessage;
        }
    }

    // Inner class for FundRequest
    public static class FundRequest{
        @SerializedName("id")
        private int id;

        @SerializedName("tr_id")
        private int transactionId;

        @SerializedName("tr_amount")
        private double transactionAmount;

        @SerializedName("tr_narration")
        private String transactionNarration;

        @SerializedName("tr_date")
        private String transactionDate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(int transactionId) {
            this.transactionId = transactionId;
        }

        public double getTransactionAmount() {
            return transactionAmount;
        }

        public void setTransactionAmount(double transactionAmount) {
            this.transactionAmount = transactionAmount;
        }

        public String getTransactionNarration() {
            return transactionNarration;
        }

        public void setTransactionNarration(String transactionNarration) {
            this.transactionNarration = transactionNarration;
        }

        public String getTransactionDate() {
            return transactionDate;
        }

        public void setTransactionDate(String transactionDate) {
            this.transactionDate = transactionDate;
        }
    }


    public static class ConfigValue {

        @SerializedName("config_value")
        private double configValue;

        public double getConfigValue() {
            return configValue;
        }

        public void setConfigValue(double configValue) {
            this.configValue = configValue;
        }
    }
}

