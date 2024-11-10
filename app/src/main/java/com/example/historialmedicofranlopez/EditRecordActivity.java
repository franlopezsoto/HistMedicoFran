package com.example.historialmedicofranlopez;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditRecordActivity extends AppCompatActivity {

    // Declaración de los elementos de la interfaz de usuario
    private EditText conditionInput;
    private EditText treatmentInput;
    private Button saveButton;
    private MedicalRecordRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_record); // Asegúrate de que el archivo de layout coincida

        // Inicialización de las vistas
        conditionInput = findViewById(R.id.conditionInput);
        treatmentInput = findViewById(R.id.treatmentInput);
        saveButton = findViewById(R.id.saveButton);

        // Inicialización del repositorio de registros médicos
        repository = new MedicalRecordRepository(getApplication());

        // Configuración del botón de guardar
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

        // Inserta el registro en la base de datos
        repository.insert(record);
        Toast.makeText(this, "Registro guardado exitosamente", Toast.LENGTH_SHORT).show();
        finish(); // Finaliza la actividad y regresa a la anterior
    }
}
