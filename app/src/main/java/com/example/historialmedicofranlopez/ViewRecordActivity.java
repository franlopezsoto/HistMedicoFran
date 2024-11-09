package com.example.historialmedicofranlopez;

import androidx.appcompat.app.AppCompatActivity;

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
        adapter = new MedicalRecordAdapter(records);
        recordsRecyclerView.setAdapter(adapter);
    }
}