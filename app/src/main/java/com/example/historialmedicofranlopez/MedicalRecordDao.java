package com.example.historialmedicofranlopez;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MedicalRecordDao {
    @Insert
    void insert(MedicalRecord record);

    @Update
    void update(MedicalRecord record);

    @Delete
    void delete(MedicalRecord record);

    @Query("SELECT * FROM medical_records")
    List<MedicalRecord> getAllRecords();
}
