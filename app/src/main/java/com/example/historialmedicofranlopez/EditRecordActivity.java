package com.example.historialmedicofranlopez;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    private void saveRecord() {
        String condition = conditionInput.getText().toString().trim();
        String treatment = treatmentInput.getText().toString().trim();
        if (condition.isEmpty() || treatment.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        MedicalRecord record = new MedicalRecord();
        record.setCondition(condition);
        record.setTreatment(treatment);
        record.setDate(System.currentTimeMillis());

        repository.insert(record);
        Toast.makeText(this, "Registro guardado exitosamente", Toast.LENGTH_SHORT).show();
        finish();
    }
}
