package com.example.lab4javafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Module {

    private StringProperty MID;
    private StringProperty MName;
    private StringProperty MDescription;

    // Constructor
    public Module(String MID, String MName, String MDescription) {
        this.MID = new SimpleStringProperty(MID);
        this.MName = new SimpleStringProperty(MName);
        this.MDescription = new SimpleStringProperty(MDescription);
    }

    // MID
    public String getMID() {
        return MID.get();
    }

    public void setMID(String MID) {
        this.MID.set(MID);
    }

    public StringProperty MIDProperty() {
        return MID;
    }

    // MName
    public String getMName() {
        return MName.get();
    }

    public void setMName(String MName) {
        this.MName.set(MName);
    }

    public StringProperty MNameProperty() {
        return MName;
    }

    // MDescription
    public String getMDescription() {
        return MDescription.get();
    }

    public void setMDescription(String MDescription) {
        this.MDescription.set(MDescription);
    }

    public StringProperty MDescriptionProperty() {
        return MDescription;
    }
}
