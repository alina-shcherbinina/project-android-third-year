package com.example.projectandroidthirdyear;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ItemClass> list;
    private String accountName;
    ImageButton profile_btn;

    String title_int;
    String score_int;
    String result_int;
    String picture_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        profile_btn = findViewById(R.id.profile_btn);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null)
            accountName = extras.getString("accountINTENT");
            title_int = extras.getString("titleINTENT");
            score_int = extras.getString("scoreINTENT");
            result_int = extras.getString("resultINTENT");
            picture_url = extras.getString("pictureINTENT");

        String account_name_saved = accountName;

        //--> Creating a list
        list = new ArrayList<>();
        list.add(new ItemClass(R.drawable.quiz_1_cover, "How well do you know Harry Potter movies?", 1));
        list.add(new ItemClass(R.drawable.quiz_2_cover, "Guess the movie", 2));
        list.add(new ItemClass(R.drawable.quiz_3_cover, "Who said that? (PI edition)", 3));
        list.add(new ItemClass(R.drawable.quiz_4_cover, "Guess the country", 4));


        recyclerView = findViewById(R.id.id_RecyclerView);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        MyAdapter adapter = new MyAdapter(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.OnRecyclerViewClickListener(new MyAdapter.OnRecyclerViewClickListener() {
            @Override
            public void OnItemClick(int position) {

                Intent intent = new Intent(MenuActivity.this, TestActivity.class);
                intent.putExtra("imageINTENT", list.get(position).getImg());
                intent.putExtra("nameINTENT", list.get(position).getName());
                intent.putExtra("indexINTENT", list.get(position).getIndex());
                intent.putExtra("accountINTENT", account_name_saved);
                intent.putExtra("pictureINTENT", picture_url);
                startActivity(intent);

            }
        });

        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
                intent.putExtra("accountINTENT", account_name_saved);
                intent.putExtra("titleINTENT", title_int);
                intent.putExtra("scoreINTENT", score_int);
                intent.putExtra("resultINTENT", result_int);
                intent.putExtra("pictureINTENT", picture_url);
                startActivity(intent);
            }
        });


    }
}