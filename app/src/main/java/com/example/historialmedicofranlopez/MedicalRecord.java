package com.example.historialmedicofranlopez;

import androidx.room.Entity;

@Entity(tableName = "medical_records")
public class MedicalRecord {
    private int id;
    private String condition;
    private String treatment;
    private long date;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
