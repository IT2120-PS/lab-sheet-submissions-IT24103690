package com.example.lab4javafx.model;

public class Offers {
    private String CID;
    private String Mcode;
    private String Accademic_year;
    private int Semester;

    public Offers(String CID, String Mcode, String Accademic_year, int Semester) {
        this.CID = CID;
        this.Mcode = Mcode;
        this.Accademic_year = Accademic_year;
        this.Semester = Semester;
    }

    public String getCID() { return CID; }
    public void setCID(String CID) { this.CID = CID; }

    public String getMcode() { return Mcode; }
    public void setMcode(String mcode) { Mcode = mcode; }

    public String getAccademic_year() { return Accademic_year; }
    public void setAccademic_year(String accademic_year) { Accademic_year = accademic_year; }

    public int getSemester() { return Semester; }
    public void setSemester(int semester) { Semester = semester; }
}
