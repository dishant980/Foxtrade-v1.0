package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CommissionResponse {

    @SerializedName("transactions")
    private List<CommissionItem> transactions;

    public List<CommissionItem> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<CommissionItem> transactions) {
        this.transactions = transactions;
    }

    public CommissionResponse(List<CommissionItem> transactions) {
        this.transactions = transactions;
    }

    public static class CommissionItem {

        @SerializedName("tr_date")
        private String transactionDate;

        @SerializedName("narration")
        private String narration;

        @SerializedName("downline_id")
        private int downlineId;

        @SerializedName("refer_code")
        private int referCode;

        @SerializedName("investment")
        private double investment;

        @SerializedName("roi")
        private double roi;

        @SerializedName("level")
        private int level;

        @SerializedName("comm_on_roi")
        private double commOnRoi;

        @SerializedName("total")
        private double total;

        public String getTransactionDate() {
            return transactionDate;
        }

        public String getNarration() {
            return narration;
        }

        public int getDownlineId() {
            return downlineId;
        }

        public int getReferCode() {
            return referCode;
        }

        public double getInvestment() {
            return investment;
        }

        public double getRoi() {
            return roi;
        }

        public int getLevel() {
            return level;
        }

        public double getCommOnRoi() {
            return commOnRoi;
        }

        public double getTotal() {
            return total;
        }

        public void setTransactionDate(String transactionDate) {
            this.transactionDate = transactionDate;
        }

        public void setNarration(String narration) {
            this.narration = narration;
        }

        public void setDownlineId(int downlineId) {
            this.downlineId = downlineId;
        }

        public void setReferCode(int referCode) {
            this.referCode = referCode;
        }

        public void setInvestment(double investment) {
            this.investment = investment;
        }

        public void setRoi(double roi) {
            this.roi = roi;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public void setCommOnRoi(double commOnRoi) {
            this.commOnRoi = commOnRoi;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }
}
