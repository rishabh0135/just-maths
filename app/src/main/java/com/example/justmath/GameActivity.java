package com.example.justmath;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView txtViewQuestion;
    TextView txtViewResult;
    TextView txtTime;
    TextView txtScore;
    Button btnRight;
    Button btnWrong;
    boolean isResultCorrect;
    int seconds = 59;
    private int score = 0;
    private boolean stopTimer = false;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        txtViewQuestion = (TextView) findViewById(R.id.textViewQuestion);
        txtViewResult = (TextView) findViewById(R.id.textViewResult);
        txtTime = (TextView) findViewById(R.id.txtTime);
        txtScore = (TextView) findViewById(R.id.txtScore);
        btnRight = (Button) findViewById(R.id.btnRight);
        btnWrong = (Button) findViewById(R.id.btnWrong);


        timer();

        btnRight.setOnClickListener(v -> verifyAnswer(true));
        btnWrong.setOnClickListener(v -> verifyAnswer(false));

        generateQuestion();

    }

    @SuppressLint("SetTextI18n")
    private void generateQuestion() {
        isResultCorrect = true;

        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        int result = a + b;
        float f = random.nextFloat();
        if (f > 0.5f) {
            result = random.nextInt(100);
            isResultCorrect = false;
        }
        txtViewQuestion.setText(a + "+" + b);
        txtViewResult.setText("=" + result);
    }

    public void verifyAnswer(boolean answer) {
        if (answer == isResultCorrect) {
            score += 5;
            txtScore.setText("SCORE: " + score);
        } else {
            Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);
        }
        generateQuestion();
    }

    private void timer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                txtTime.setText("TIME :" + seconds);
                seconds--;
                if (seconds < 0) {
                    Intent i = new Intent(GameActivity.this, ScoreActivity.class);
                    i.putExtra("score", score);
                    startActivity(i);
                    stopTimer = true;
                }
                if (stopTimer == false) {
                    handler.postDelayed(this, 1000);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopTimer = false;
        finish();
    }


}
