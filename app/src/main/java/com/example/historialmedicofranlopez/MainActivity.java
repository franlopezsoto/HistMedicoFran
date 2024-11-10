package com.example.historialmedicofranlopez;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddRecord = findViewById(R.id.btnAddRecord);
        Button btnViewRecords = findViewById(R.id.btnViewRecords);

        btnAddRecord.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EditRecordActivity.class);
            startActivity(intent);
        });

        btnViewRecords.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ViewRecordActivity.class);
            startActivity(intent);
        });
    }
}


