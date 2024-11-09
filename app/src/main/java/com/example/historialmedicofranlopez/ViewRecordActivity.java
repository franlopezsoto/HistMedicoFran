package com.example.historialmedicofranlopez;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ViewRecordActivity extends AppCompatActivity {
    private RecyclerView recordsRecyclerView;
    private MedicalRecordAdapter adapter;
    private MedicalRecordRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);

        recordsRecyclerView = findViewById(R.id.recordsRecyclerView);
        recordsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        repository = new MedicalRecordRepository(getApplication());

        List<MedicalRecord> records = repository.getAllRecords();
        if (records.isEmpty()) {
            Toast.makeText(this, "No se encontraron registros", Toast.LENGTH_SHORT).show();
        }
        adapter = new MedicalRecordAdapter(records);
        recordsRecyclerView.setAdapter(adapter);
    }
}
