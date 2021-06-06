package com.example.projectandroidthirdyear;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultTestActivity extends AppCompatActivity {

    TextView result_score, result_title, result_text;
    ImageView result_image;
    Button share, back_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_test);

        result_score = findViewById(R.id.score_result);
        result_title = findViewById(R.id.title_result);
        result_image = findViewById(R.id.image_result);
        result_text = findViewById(R.id.text_result);

        share = findViewById(R.id.share);
        back_menu = findViewById(R.id.goToMenu);

        result_score.setText(getIntent().getStringExtra("scoreINTENT"));
        result_title.setText(getIntent().getStringExtra("titleINTENT"));
        result_text.setText(getIntent().getStringExtra("resultINTENT"));
        result_image.setImageDrawable(Drawable.createFromPath(getIntent().getStringExtra("imageINTENT")));

    }
}