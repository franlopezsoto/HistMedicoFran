package com.example.historialmedicofranlopez;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditRecordActivity extends AppCompatActivity {
    private EditText conditionInput, treatmentInput;
    private Button saveButton;
    private MedicalRecordRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_record);

        conditionInput = findViewById(R.id.conditionInput);
        treatmentInput = findViewById(R.id.treatmentInput);
        saveButton = findViewById(R.id.saveButton);
        repository = new MedicalRecordRepository(getApplication());

        saveButton.setOnClickListener(v -> saveRecord());
    }