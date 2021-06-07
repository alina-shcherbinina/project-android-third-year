package com.example.projectandroidthirdyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultTestActivity extends AppCompatActivity {

    TextView result_score, result_title, result_text;
    ImageView result_image;
    Button share, back_menu;
    String account_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_test);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            account_name = extras.getString("accountINTENT");
        }


        result_score = findViewById(R.id.score_result);
        result_title = findViewById(R.id.title_result);
        result_image = findViewById(R.id.image_result);
        result_text = findViewById(R.id.text_result);

        share = findViewById(R.id.share);
        back_menu = findViewById(R.id.goToMenu);

        result_score.setText(String.format("Your score: %s out of 5", getIntent().getStringExtra("scoreINTENT")));
        result_title.setText(getIntent().getStringExtra("titleINTENT"));
        result_text.setText(getIntent().getStringExtra("resultINTENT"));
        result_image.setImageResource(getIntent().getIntExtra("imageINTENT", R.drawable.quiz_1_cover));


        back_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultTestActivity.this, MenuActivity.class);
                intent.putExtra("accountINTENT", account_name);
                startActivity(intent);
            }
        });
    }


}