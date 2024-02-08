package com.fxt.exchange;

public class ListItemData {
    private final int id;
    private final String name;
    private final String email;
    private final int referCode;
    private final int teamSize;
    private final int teamBusiness;
    private final int investment;

    // Constructor
    public ListItemData(int id, String name, String email, int referCode, int teamSize, int teamBusiness, int investment) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.referCode = referCode;
        this.teamSize = teamSize;
        this.teamBusiness = teamBusiness;
        this.investment = investment;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getReferCode() {
        return referCode;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public int getTeamBusiness() {
        return teamBusiness;
    }

    public int getInvestment() {
        return investment;
    }


}

