package com.example.drug.entity;

public class Druglist2 {
    private int id;
    private int id2;
    private String drugimage;
    private String drugname;
    private String drugdesc;
    private String drugcreatedtime;
    private String createdtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
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

    public String getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }

    @Override
    public String toString() {
        return "Druglist2{" +
                "id=" + id +
                ", id2=" + id2 +
                ", drugimage='" + drugimage + '\'' +
                ", drugname='" + drugname + '\'' +
                ", drugdesc='" + drugdesc + '\'' +
                ", drugcreatedtime='" + drugcreatedtime + '\'' +
                ", createdtime='" + createdtime + '\'' +
                '}';
    }
}
