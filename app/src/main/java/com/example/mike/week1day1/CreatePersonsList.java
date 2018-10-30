package com.example.mike.week1day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mike.week1day1.model.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CreatePersonsList extends AppCompatActivity {

    private EditText et_name;
    private EditText et_age;
    private EditText et_gender;
    private ArrayList<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_persons_list);

        et_name = findViewById( R.id.name );
        et_age = findViewById( R.id.age );
        et_gender = findViewById( R.id.gender );

        personList = new ArrayList<>();
    }

    public void addPerson(View view) {
        // Retrieving field values;
        String name = et_name.getText().toString();
        String age = et_age.getText().toString();
        String gender = et_gender.getText().toString();

        if (name.equals("") || age.equals("") || gender.equals("")){
            Toast.makeText(this, "Fill in All fields", Toast.LENGTH_SHORT);
            return;
        }

        Person p = new Person(name,age,gender);

        personList.add( p );

        Toast.makeText( this, "Added "+p.toString(), Toast.LENGTH_SHORT );
    }

    public void displayPersonList(View view) {
        if ( personList.size() == 0 ){
            Toast.makeText( this, "There is no Persons in List", Toast.LENGTH_SHORT );
            return;
        }
        Intent intent = new Intent( getApplicationContext(), PersonsDisplayActivity.class );
        intent.putExtra("persons", personList);
        startActivity(intent);
    }
}
