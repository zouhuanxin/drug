package com.example.drug.entity;

public class Druglist1 {
    private int id;
    private String name;
    private String createdtime;
    private String account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Druglist1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdtime='" + createdtime + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
