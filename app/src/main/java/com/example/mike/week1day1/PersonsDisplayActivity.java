package com.example.mike.week1day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PersonsDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons_display);

        ListView lv = findViewById( R.id.listView );

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, findViewById(R.id.listItem), (Object[]) getIntent().getExtras().get("persons"));

    }
}
