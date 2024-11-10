package com.example.historialmedicofranlopez;

import android.app.Application;
import java.util.List;

public class MedicalRecordRepository {
    private final AppDatabase database;
    private final MedicalRecordDao recordDao;

    public MedicalRecordRepository(Application application) {
        // Inicializa la base de datos Room
        database = AppDatabase.getInstance(application);
        recordDao = database.medicalRecordDao();  // Asegúrate de que el método para obtener el DAO esté implementado en AppDatabase
    }

    public void insert(MedicalRecord record) {
        new Thread(() -> recordDao.insert(record)).start();
    }

    public List<MedicalRecord> getAllRecords() {
        return recordDao.getAllRecords();
    }
}
