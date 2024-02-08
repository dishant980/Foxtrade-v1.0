package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SalaryResponse {
    @SerializedName("transactions")
    private List<SalaryItem> transactions;

    public List<SalaryItem> getTransactions() {
        return transactions;
    }

    public static class SalaryItem {

        @SerializedName("id")
        private int id;

        @SerializedName("refer_code")
        private int referCode;

        @SerializedName("name")
        private String name;

        @SerializedName("month_start")
        private String monthStart;

        @SerializedName("salary_rank")
        private int salaryRank;

        @SerializedName("level")
        private String level;

        @SerializedName("club_id")
        private String clubId;

        @SerializedName("club_name")
        private String clubName;

        @SerializedName("salary")
        private int salary;

        public int getId() {
            return id;
        }

        public int getReferCode() {
            return referCode;
        }

        public String getName() {
            return name;
        }

        public String getMonthStart() {
            return monthStart;
        }

        public int getSalaryRank() {
            return salaryRank;
        }

        public String getLevel() {
            return level;
        }

        public String getClubId() {
            return clubId;
        }

        public String getClubName() {
            return clubName;
        }

        public int getSalary() {
            return salary;
        }
    }
}
