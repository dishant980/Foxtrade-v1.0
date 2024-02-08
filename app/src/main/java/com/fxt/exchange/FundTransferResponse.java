package com.fxt.exchange;

import com.google.gson.annotations.SerializedName;

public class FundTransferResponse {
    @SerializedName("beneficiary_refer_code")
    private String beneficiaryReferCode;

    @SerializedName("transfer_amount")
    private double transferAmount;

    @SerializedName("remarks")
    private String remarks;

    @SerializedName("transfer_to_admin")
    private int transferToAdmin = 1;
    @SerializedName("success_msg")
    private String successMessage;

    @SerializedName("status")
    private int status;

    public FundTransferResponse(String beneficiaryReferCode, double transferAmount, String remarks, int transferToAdmin, String successMessage, int status) {
        this.beneficiaryReferCode = beneficiaryReferCode;
        this.transferAmount = transferAmount;
        this.remarks = remarks;
        this.transferToAdmin= transferToAdmin;
        this.successMessage = successMessage;
        this.status = status;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public int getStatus() {
        return status;
    }

    public String getBeneficiaryReferCode() {
        return beneficiaryReferCode;
    }

    public void setBeneficiaryReferCode(String beneficiaryReferCode) {
        this.beneficiaryReferCode = beneficiaryReferCode;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int isTransferToAdmin() {
        return transferToAdmin;
    }

    public void setTransferToAdmin(int transferToAdmin) {
        this.transferToAdmin = transferToAdmin;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

