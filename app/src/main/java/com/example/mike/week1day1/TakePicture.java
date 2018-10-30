package com.example.mike.week1day1;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class TakePicture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);

        ImageView iv = findViewById( R.id.imageHolder );

        iv.setImageBitmap( (Bitmap) getIntent().getExtras().get("data") );

    }

}
