package com.example.mike.week1day1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCreatePersonList(View view) {
        Intent intent = new Intent(getApplicationContext(), CreatePersonsList.class);
        startActivity(intent);
    }

    public void onCalculateEMI(View view) {
        Intent intent = new Intent(getApplicationContext(), CalculateEMI.class);
        startActivity(intent);
    }

    public void onTakePicture(View view) {
        // Taking picture and then redirecting to imageview
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult( takePictureIntent, 1 );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // Redirecting to activity to display Picture
            Intent redirectToPicture = new Intent(getApplicationContext(), TakePicture.class);
            redirectToPicture.putExtra("data", imageBitmap);
            startActivity(redirectToPicture);
        }

    }
    public void sendEmail(View view) {
        // Getting text from editText
        EditText et = findViewById( R.id.stringToShare );
        String strToSend = et.getText().toString();

        // Starting sending text activity
        Intent send = new Intent( Intent.ACTION_SEND );
        send.putExtra(Intent.EXTRA_TEXT, strToSend);
        send.setType("text/plain");
        startActivity(Intent.createChooser(send, "Sending String to Another App"));
    }

    public void call(View view) {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        startActivity(dialIntent);
    }
}
