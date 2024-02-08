package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FundResponse {

    @SerializedName("userWalletBal")
    private UserWalletBalance userWalletBal;

    @SerializedName("fundRequests")
    private List<FundRequest> fundRequests;

    public UserWalletBalance getUserWalletBal() {
        return userWalletBal;
    }

    public List<FundRequest> getFundRequests() {
        return fundRequests;
    }

    public static class UserWalletBalance {
        private int id;
        @SerializedName("user_id")
        private int userId;
        private double wallet;
        private double investment;
        private int roi;
        @SerializedName("commission_on_roi")
        private double commissionOnRoi;

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

        public int getRoi() {
            return roi;
        }

        public void setRoi(int roi) {
            this.roi = roi;
        }

        public double getCommissionOnRoi() {
            return commissionOnRoi;
        }

        public void setCommissionOnRoi(double commissionOnRoi) {
            this.commissionOnRoi = commissionOnRoi;
        }
    }

    public static class FundRequest {
        private int id;
        @SerializedName("beneficiary_user_id")
        private int beneficiaryUserId;
        private String name;
        @SerializedName("approved_amount")
        private double approvedAmount;
        @SerializedName("approved_at")
        private String approvedAt;
        @SerializedName("user_remarks")
        private String userRemarks;
        @SerializedName("admin_remarks")
        private String adminRemarks;
        @SerializedName("status_id")
        private int statusId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getBeneficiaryUserId() {
            return beneficiaryUserId;
        }

        public void setBeneficiaryUserId(int beneficiaryUserId) {
            this.beneficiaryUserId = beneficiaryUserId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getApprovedAmount() {
            return approvedAmount;
        }

        public void setApprovedAmount(double approvedAmount) {
            this.approvedAmount = approvedAmount;
        }

        public String getApprovedAt() {
            return approvedAt;
        }

        public void setApprovedAt(String approvedAt) {
            this.approvedAt = approvedAt;
        }

        public String getUserRemarks() {
            return userRemarks;
        }

        public void setUserRemarks(String userRemarks) {
            this.userRemarks = userRemarks;
        }

        public String getAdminRemarks() {
            return adminRemarks;
        }

        public void setAdminRemarks(String adminRemarks) {
            this.adminRemarks = adminRemarks;
        }

        public int getStatusId() {
            return statusId;
        }

        public void setStatusId(int statusId) {
            this.statusId = statusId;
        }
    }
}

