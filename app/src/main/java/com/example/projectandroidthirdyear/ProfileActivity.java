package com.example.projectandroidthirdyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView account_name, test_title, test_body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        account_name = findViewById(R.id.account_name);
        String account_saved = getIntent().getStringExtra("accountINTENT");
        account_name.setText(account_saved);

        test_title = findViewById(R.id.test_title);
        String title_int = getIntent().getStringExtra("titleINTENT");
        test_title.setText(title_int);

        test_body = findViewById(R.id.test_body);
        String result_int = getIntent().getStringExtra("resultINTENT") + "\n "
                + "Score: " + getIntent().getStringExtra("scoreINTENT") + " out of 5";
        test_body.setText(result_int);

    }
}