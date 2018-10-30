package com.example.mike.week1day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mike.week1day1.model.Person;

import java.util.ArrayList;

public class PersonsDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons_display);

        ListView lv = findViewById( R.id.listView );

        ArrayList<Person> persons = (ArrayList<Person>) getIntent().getExtras().get("persons");

        ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(
                this,
                android.R.layout.simple_list_item_1,
                persons );

        lv.setAdapter(adapter);

        }
}
