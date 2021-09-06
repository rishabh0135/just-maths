package com.example.justmath;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton img1S, img2P, img3R;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1S = findViewById(R.id.img1S);
        img2P= findViewById(R.id.img2P);
        img3R = findViewById(R.id.img3R);

        img2P.setOnClickListener(v -> {

            Intent i = new Intent(getApplicationContext(),GameActivity.class);
            startActivity(i);
        });

        img1S.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Just Maths - Fun way to learn Maths. http://www.play.google.com");
            startActivity(intent);
        });

        img3R.setOnClickListener(v -> {

            Toast.makeText(MainActivity.this,"You can open your Google Play landing page",Toast.LENGTH_LONG).show();
        });
    }
}