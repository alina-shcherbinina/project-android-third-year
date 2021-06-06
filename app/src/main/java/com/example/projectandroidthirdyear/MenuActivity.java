package com.example.projectandroidthirdyear;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ItemClass> list;
    private String accountName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null)
            accountName = extras.getString("nameINTENT");

        //--> Creating a list
        list = new ArrayList<>();
        list.add(new ItemClass(R.drawable.quiz_1_cover, "How well do you know Harry Potter movies?"));
        list.add(new ItemClass(R.drawable.quiz_2_cover, "Guess the movie"));
        list.add(new ItemClass(R.drawable.quiz_3_cover, "Who said that? (PI edition)"));
        list.add(new ItemClass(R.drawable.quiz_4_cover, "Guess the country"));


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
                intent.putExtra("imageINTENT", list.get(position).getImg() );
                intent.putExtra("nameINTENT", list.get(position).getName());
                startActivity(intent);
            }
        });

    }
}