package com.example.projectandroidthirdyear;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView img;
    private TextView tv_name;
    Button btn_start;
    int index;
    String account_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            index = extras.getInt("indexINTENT");
            account_name = extras.getString("accountINTENT");
        }

        img = findViewById(R.id.id_img_details);
        tv_name = findViewById(R.id.id_name_details);
        btn_start = findViewById(R.id.id_start);
        btn_start.setOnClickListener(this);


        img.setImageResource(getIntent().getIntExtra("imageINTENT", R.drawable.quiz_1_cover));
        tv_name.setText(getIntent().getStringExtra("nameINTENT"));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_start:
                StartTest();
                break;
        }
    }

    private void StartTest() {
        Intent intent = new Intent(TestActivity.this, PlayTestActivity.class);
        intent.putExtra("indexINTENT", index);
        intent.putExtra("accountINTENT", account_name);
        startActivity(intent);

    }

}
