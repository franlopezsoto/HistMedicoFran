package com.example.historialmedicofranlopez;

import androidx.room.Entity;

@Entity(tableName = "medical_records")
public class MedicalRecord {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String condition;
    private String treatment;
    private long date;

    // Getters y Setters
}
