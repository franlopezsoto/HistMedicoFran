package com.example.historialmedicofranlopez;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Date;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MedicalRecordAdapter extends RecyclerView.Adapter<MedicalRecordAdapter.MedicalRecordViewHolder> {
    private List<MedicalRecord> medicalRecords;

    public MedicalRecordAdapter(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    @NonNull
    @Override
    public MedicalRecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_record, parent, false);
        return new MedicalRecordViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MedicalRecordViewHolder holder, int position) {
        MedicalRecord record = medicalRecords.get(position);
        holder.conditionTextView.setText("Condición: " + record.getCondition());
        holder.treatmentTextView.setText("Tratamiento: " + record.getTreatment());
        holder.dateTextView.setText("Fecha: " + new Date(record.getDate()).toString());
    }

    @Override
    public int getItemCount() {
        return medicalRecords.size();
    }

    public static class MedicalRecordViewHolder extends RecyclerView.ViewHolder {
        TextView conditionTextView, treatmentTextView, dateTextView;

        public MedicalRecordViewHolder(@NonNull View itemView) {
            super(itemView);
            conditionTextView = itemView.findViewById(R.id.conditionTextView);
            treatmentTextView = itemView.findViewById(R.id.treatmentTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
        }
    }
}
