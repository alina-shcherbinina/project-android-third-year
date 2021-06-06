package com.example.projectandroidthirdyear;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {
    private ImageView img;
    private TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);

        img = findViewById(R.id.id_img_details);
        tv_name = findViewById(R.id.id_name_details);


        img.setImageResource(getIntent().getIntExtra("imageINTENT", R.drawable.quiz_1_cover));
        tv_name.setText(getIntent().getStringExtra("nameINTENT"));
    }
}
