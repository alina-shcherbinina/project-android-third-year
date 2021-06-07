package com.example.projectandroidthirdyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static android.content.ContentValues.TAG;

public class ResultTestActivity extends AppCompatActivity {

    TextView result_score, result_title, result_text;
    ImageView result_image;
    Button share, back_menu;
    String account_name, picture_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_test);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            account_name = extras.getString("accountINTENT");
            picture_url = extras.getString("pictureINTENT");
        }

        result_score = findViewById(R.id.score_result);
        result_title = findViewById(R.id.title_result);
        result_image = findViewById(R.id.image_result);
        result_text = findViewById(R.id.text_result);

        share = findViewById(R.id.share);
        back_menu = findViewById(R.id.goToMenu);

        String score_int = getIntent().getStringExtra("scoreINTENT");
        String title_int = getIntent().getStringExtra("titleINTENT");
        String result_int = getIntent().getStringExtra("resultINTENT");

        result_score.setText(String.format("Your score: %s out of 5", score_int));
        result_title.setText(title_int);
        result_text.setText(result_int);
        result_image.setImageResource(getIntent().getIntExtra("imageINTENT", R.drawable.quiz_1_cover));


        back_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultTestActivity.this, MenuActivity.class);
                intent.putExtra("accountINTENT", account_name);
                intent.putExtra("pictureINTENT", picture_url);
                intent.putExtra("titleINTENT", title_int);
                intent.putExtra("scoreINTENT", score_int);
                intent.putExtra("resultINTENT", result_int);

                startActivity(intent);
            }
        });

        String message = result_title.getText() + "\n "
                + result_text.getText()
                + "\nMy score is: " + getIntent().getStringExtra("scoreINTENT") +" out of 5";

        share.setOnClickListener(new View.OnClickListener() {
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