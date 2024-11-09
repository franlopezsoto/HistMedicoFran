package com.example.historialmedicofranlopez;

import androidx.room.Database;

@Database(entities = {MedicalRecord.class}, version = 1)
public abstract class MedicalDatabase extends RoomDatabase {
    public abstract MedicalRecordDao medicalRecordDao();
}
