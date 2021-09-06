package com.example.justmath;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    ImageButton img2S;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView ts = (TextView) findViewById(R.id.totalScore);
        int score = getIntent().getIntExtra("score", 0);
        ts.setText("Current Score : " + score);

        img2S = findViewById(R.id.img2S);

        img2S.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Just Maths - Fun way to learn Maths. http://www.play.google.com");
            startActivity(intent);
        });
    }


}
