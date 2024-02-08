package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TransactionResponse {
    private List<TransactionItem> transactions;

    public List<TransactionItem> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionItem> transactions) {
        this.transactions = transactions;
    }

    public static class TransactionItem {
        @SerializedName("user_id")
        private final int userId;

        @SerializedName("tr_date")
        private final String transactionDate;

        private final String narration;
        private final double credit;
        private final double debit;
        private final double balance;

        public TransactionItem(int userId, String transactionDate, String narration, double credit, double debit, double balance) {
            this.userId = userId;
            this.transactionDate = transactionDate;
            this.narration = narration;
            this.credit = credit;
            this.debit = debit;
            this.balance = balance;
        }

        public int getUserId() {
            return userId;
        }

        public String getTransactionDate() {
            return transactionDate;
        }

        public String getNarration() {
            return narration;
        }

        public double getCredit() {
            return credit;
        }

        public double getDebit() {
            return debit;
        }

        public double getBalance() {
            return balance;
        }
    }
}

