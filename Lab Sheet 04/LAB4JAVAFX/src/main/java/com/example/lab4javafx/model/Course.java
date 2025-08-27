package com.example.lab4javafx.model;

public class Course {
    private String cid;
    private String cname;
    private String description;
    private double fee;

    public Course(String cid, String cname, String description, double fee) {
        this.cid = cid;
        this.cname = cname;
        this.description = description;
        this.fee = fee;
    }

    // Getters and setters
    public String getCid() { return cid; }
    public void setCid(String cid) { this.cid = cid; }

    public String getCname() { return cname; }
    public void setCname(String cname) { this.cname = cname; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }
}
