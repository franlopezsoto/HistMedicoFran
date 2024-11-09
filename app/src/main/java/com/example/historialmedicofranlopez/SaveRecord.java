package com.example.historialmedicofranlopez;

import java.text.BreakIterator;

private class void SaveRecord() {
    BreakIterator conditionInput;
    String condition = conditionInput.getText().toString();
    String treatment = treatmentInput.getText().toString();
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