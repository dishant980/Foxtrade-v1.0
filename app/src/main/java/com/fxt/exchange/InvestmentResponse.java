package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InvestmentResponse {

    @SerializedName("transactions")
    private List<InvestmentItem> transactions;

    public List<InvestmentItem> getTransactions() {
        return transactions;
    }

    public static class InvestmentItem {
        @SerializedName("tr_date")
        private String transactionDate;

        @SerializedName("narration")
        private String narration;

        @SerializedName("amount")
        private int amount;

        @SerializedName("total")
        private double total;

        public String getTransactionDate() {
            return transactionDate;
        }

        public String getNarration() {
            return narration;
        }

        public int getAmount() {
            return amount;
        }

        public double getTotal() {
            return total;
        }
    }
}

