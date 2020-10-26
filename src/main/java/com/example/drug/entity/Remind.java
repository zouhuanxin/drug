package com.example.drug.entity;

public class Remind {
    private int id;
    private String account;
    private String drugimage;
    private String drugname;
    private String drugdesc;
    private String drugcreatedtime;
    private String drugtaketime;
    private int drugstatus;
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

    public String getDrugimage() {
        return drugimage;
    }

    public void setDrugimage(String drugimage) {
        this.drugimage = drugimage;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getDrugdesc() {
        return drugdesc;
    }

    public void setDrugdesc(String drugdesc) {
        this.drugdesc = drugdesc;
    }

    public String getDrugcreatedtime() {
        return drugcreatedtime;
    }

    public void setDrugcreatedtime(String drugcreatedtime) {
        this.drugcreatedtime = drugcreatedtime;
    }

    public String getDrugtaketime() {
        return drugtaketime;
    }

    public void setDrugtaketime(String drugtaketime) {
        this.drugtaketime = drugtaketime;
    }

    public int getDrugstatus() {
        return drugstatus;
    }

    public void setDrugstatus(int drugstatus) {
        this.drugstatus = drugstatus;
    }

    public String getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }

    @Override
    public String toString() {
        return "Remind{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", drugimage='" + drugimage + '\'' +
                ", drugname='" + drugname + '\'' +
                ", drugdesc='" + drugdesc + '\'' +
                ", drugcreatedtime='" + drugcreatedtime + '\'' +
                ", drugtaketime='" + drugtaketime + '\'' +
                ", drugstatus=" + drugstatus +
                ", createdtime='" + createdtime + '\'' +
                '}';
    }
}
