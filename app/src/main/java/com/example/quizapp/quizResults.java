package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class quizResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        final TextView incorrectAns = findViewById(R.id.incorrect_tv);
        final AppCompatButton startAgain = findViewById(R.id.restart);
        final TextView correctAns = findViewById(R.id.correct_tv);


        final int getIncorrectAns = getIntent().getIntExtra("incorrect",0);
        final int getCorrectAns = getIntent().getIntExtra("correct",0);

        incorrectAns.setText(String.valueOf(getIncorrectAns));
        correctAns.setText(String.valueOf(getCorrectAns));

        startAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(quizResults.this,MainActivity.class));
                finish();
            }
        });

    };

}