package com.example.drug.entity;

public class Guardianship {
    private int id;
    private String account;
    private String beaccount;
    private String createdtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBeaccount() {
        return beaccount;
    }

    public void setBeaccount(String beaccount) {
        this.beaccount = beaccount;
    }

    public String getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }
}
