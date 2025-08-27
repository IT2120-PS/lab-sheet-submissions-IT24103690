package com.example.lab4javafx.model;

public class Student {
    private String sid;
    private String sname;
    private String address;
    private String dob;
    private String nic;
    private String cid;

    public Student(String sid, String sname, String address, String dob, String nic, String cid) {
        this.sid = sid;
        this.sname = sname;
        this.address = address;
        this.dob = dob;
        this.nic = nic;
        this.cid = cid;
    }

    // Getters and setters
    public String getSid() { return sid; }
    public void setSid(String sid) { this.sid = sid; }

    public String getSname() { return sname; }
    public void setSname(String sname) { this.sname = sname; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getNic() { return nic; }
    public void setNic(String nic) { this.nic = nic; }

    public String getCid() { return cid; }
    public void setCid(String cid) { this.cid = cid; }
}
