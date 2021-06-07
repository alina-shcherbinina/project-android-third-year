package com.example.projectandroidthirdyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static android.content.ContentValues.TAG;

public class ProfileActivity extends AppCompatActivity {
    TextView account_name, test_title, test_body;
    Button share_btn;
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

        share_btn = findViewById(R.id.share_btn);

        String message = title_int + "\n "
                + result_int;

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://twitter.com/intent/tweet?text=" + urlEncode(message);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });



    }

    private String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.wtf(TAG, "UTF-8 should always be supported", e);
            return "";
        }
    }
}