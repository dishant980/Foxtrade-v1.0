package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;

public class FundTransferRequest {
    @SerializedName("beneficiary_refer_code")
    private String beneficiaryReferCode;

    @SerializedName("transfer_amount")
    private String transferAmount;

    @SerializedName("remarks")
    private String remarks;

    @SerializedName("transfer_to_admin")
    private int transferToAdmin;

    @SerializedName("wallet_bal")
    private String walletBalance;

    @SerializedName("beneficiary_name")
    private String beneficiaryName;

    @SerializedName("id")
    private int userId;

    public String getBeneficiaryReferCode() {
        return beneficiaryReferCode;
    }

    public void setBeneficiaryReferCode(String beneficiaryReferCode) {
        this.beneficiaryReferCode = beneficiaryReferCode;
    }

    public String getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getTransferToAdmin() {
        return transferToAdmin;
    }

    public void setTransferToAdmin(int transferToAdmin) {
        this.transferToAdmin = transferToAdmin;
    }

    public String getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(String walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
