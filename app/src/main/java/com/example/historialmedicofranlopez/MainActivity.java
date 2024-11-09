package com.example.historialmedicofranlopez;

public class MainActivity extends AppCompatActivity {
    private AuthManager authManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authManager = new AuthManager(this);
        if (!authManager.isAuthenticated()) {
            authManager.authenticate();
        }

        findViewById(R.id.btnAddRecord).setOnClickListener(v -> startActivity(new Intent(this, EditRecordActivity.class)));
        findViewById(R.id.btnViewRecords).setOnClickListener(v -> startActivity(new Intent(this, ViewRecordActivity.class)));
    }
}

