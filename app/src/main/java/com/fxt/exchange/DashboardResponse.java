package com.fxt.exchange;

public class DashboardResponse {

    private int income_percent;
    private int deposit;
    private double withdrawal;
    private double wallet;
    private double roi;
    private double commission_on_roi;
    private int founder_club;
    private int direct_business;
    private int team_business;
    private int monthly_team_business;
    private String rank;
    private int trading_no;


    public int getIncome_percent() {
        return income_percent;
    }

    public void setIncome_percent(int income_percent) {
        this.income_percent = income_percent;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public double getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(double withdrawal) {
        this.withdrawal = withdrawal;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public double getCommission_on_roi() {
        return commission_on_roi;
    }

    public void setCommission_on_roi(double commission_on_roi) {
        this.commission_on_roi = commission_on_roi;
    }

    public int getFounder_club() {
        return founder_club;
    }

    public void setFounder_club(int founder_club) {
        this.founder_club = founder_club;
    }

    public int getDirect_business() {
        return direct_business;
    }

    public void setDirect_business(int direct_business) {
        this.direct_business = direct_business;
    }

    public int getTeam_business() {
        return team_business;
    }

    public void setTeam_business(int team_business) {
        this.team_business = team_business;
    }

    public int getMonthly_team_business() {
        return monthly_team_business;
    }

    public void setMonthly_team_business(int monthly_team_business) {
        this.monthly_team_business = monthly_team_business;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getTrading_no() {
        return trading_no;
    }

    public void setTrading_no(int trading_no) {
        this.trading_no = trading_no;
    }
}

