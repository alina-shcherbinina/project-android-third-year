package com.example.projectandroidthirdyear;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView account_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        account_name = findViewById(R.id.account_name);
        account_name.setText(getIntent().getStringExtra("accountINTENT"));
    }
}