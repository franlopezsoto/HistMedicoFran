package com.example.historialmedicofranlopez;

import androidx.room.Room;

public class MedicalRecordRepository {
    private final MedicalRecordDao recordDao;

    public MedicalRecordRepository(Application application) {
        MedicalDatabase db = Room.databaseBuilder(application, MedicalDatabase.class, "medical_db").build();
        recordDao = db.medicalRecordDao();
    }

    public void insert(MedicalRecord record) {
        new Thread(() -> recordDao.insert(record)).start();
    }

    public List<MedicalRecord> getAllRecords() {
        return recordDao.getAllRecords();
    }
}
