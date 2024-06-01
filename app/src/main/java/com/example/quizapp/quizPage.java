package com.example.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class quizPage extends AppCompatActivity {
    private List<Questions> questList ;
    private TextView timer ;
    private AppCompatButton  option1,option2,option3,subBtn;
    private CountDownTimer quizTimer ;
    private TextView selectedTopic;
    private String usersOption = "";
    private int currentQuestion = 0;
    private ImageView backBtn;
    private TextView questions;
    private  TextView question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

       final String getTopic = getIntent().getStringExtra("selectedTopic");

       timer = findViewById(R.id.timertv);
       selectedTopic = findViewById(R.id.topicSelected);
       backBtn = findViewById(R.id.backbtn);

        question = findViewById(R.id.question);
        questions = findViewById(R.id.questions_tv);
        option1 = findViewById(R.id.opt1);
        option2 = findViewById(R.id.opt2);
        option3 = findViewById(R.id.opt3);
         subBtn = findViewById(R.id.submitBtn);

       selectedTopic.setText(getTopic);

        assert getTopic != null;
        questList = QuestionsList.getQuestions(getTopic);

       questions.setText((currentQuestion + 1) + "/" + questList.size());
       question.setText(questList.get(0).getQuestion());
       option1.setText(questList.get(0).getOption1());
       option2.setText(questList.get(0).getOption2());
       option3.setText(questList.get(0).getOption3());

        startTime();


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(usersOption.isEmpty()){
                 usersOption = option1.getText().toString();
                 option1.setBackgroundResource(R.drawable.wrong_background);
                 option1.setTextColor(Color.BLACK);

                 showAnswer();

                 questList.get(currentQuestion).setUserAnswer(usersOption);
             }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usersOption.isEmpty()){
                    usersOption = option2.getText().toString(); // Corrected this line
                    option2.setBackgroundResource(R.drawable.wrong_background);
                    option2.setTextColor(Color.BLACK);

                    showAnswer();

                    questList.get(currentQuestion).setUserAnswer(usersOption);
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usersOption.isEmpty()){
                    usersOption = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.wrong_background);
                    option3.setTextColor(Color.BLACK);

                    showAnswer();

                    questList.get(currentQuestion).setUserAnswer(usersOption);
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizTimer.cancel();

                startActivity(new Intent(quizPage.this, MainActivity.class));
                finish();
            }
        });
         subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(usersOption.isEmpty()){
                 Toast.makeText(quizPage.this, "PLEASE SELECT AN OPTION", Toast.LENGTH_SHORT).show();
             }else {
                 nextQuestion();
             }
            }
        });

    }



    public void startTime(){
        // Set the countdown timer for 1 minute (60 seconds)
        quizTimer = new CountDownTimer(60000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                // Update the timer TextView with the remaining time in seconds
                timer.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                // When the timer finishes, display "Time Up" and handle quiz completion
                timer.setText("Time Up");
                MediaPlayer alarm = MediaPlayer.create(quizPage.this, R.raw.alarm);
                alarm.start();
                Intent intent = new Intent(quizPage.this, quizResults.class);
                intent.putExtra("correctAnswer", getCorrectAnswers());
                intent.putExtra("incorrectAnswer", getIncorrectAns());
                startActivity(intent);
            }
        }.start(); // Start the countdown timer
    }


    private int getCorrectAnswers(){
        int correctAns = 0;

        for (int i = 0; i<questList.size();i++) {
            final String getUserAns = questList.get(i).getUserAnswer();
            final String getAns = questList.get(i).getAnswer();

            if (getUserAns.equals(getAns)){
                correctAns++;
            }
        }
        return correctAns;
    }

    private int getIncorrectAns(){
        int correctAns = 0;

        for (int i = 0; i<questList.size();i++) {
            final String getUserAns = questList.get(i).getUserAnswer();
            final String getAns = questList.get(i).getAnswer();

            if (!getUserAns.equals(getAns)){
                correctAns++;
            }
        }
        return correctAns;
    }

    private void showAnswer (){
        String getAns = questList.get(currentQuestion).getAnswer();

        if (option1.getText().toString().equals(getAns)){
            option1.setBackgroundResource(R.drawable.right_background);
            option1.setTextColor(Color.BLACK);
        } else if (option2.getText().toString().equals(getAns)) {
            option2.setBackgroundResource(R.drawable.right_background);
            option2.setTextColor(Color.BLACK);
        }else if (option3.getText().toString().equals(getAns)) {
            option3.setBackgroundResource(R.drawable.right_background);
            option3.setTextColor(Color.BLACK);
        }
    }
    private void nextQuestion() {
        currentQuestion++;
        if (currentQuestion == questList.size() - 1) {
            // Set the submit button text when the current question is the second last one
            subBtn.setText("Submit");
        }

        if (currentQuestion < questList.size()) {
            usersOption = "";

            option1.setBackgroundResource(R.drawable.round_button);
            option1.setTextColor(Color.parseColor("#FF000000"));

            option2.setBackgroundResource(R.drawable.round_button);
            option2.setTextColor(Color.parseColor("#FF000000"));

            option3.setBackgroundResource(R.drawable.round_button);
            option3.setTextColor(Color.parseColor("#FF000000"));

            questions.setText((currentQuestion + 1) + "/" + questList.size());
            question.setText(questList.get(currentQuestion).getQuestion());
            option1.setText(questList.get(currentQuestion).getOption1());
            option2.setText(questList.get(currentQuestion).getOption2());
            option3.setText(questList.get(currentQuestion).getOption3());
        } else {
            // Launch quiz results activity when all questions are answered
            Intent intent = new Intent(quizPage.this, quizResults.class);
            intent.putExtra("correct", getCorrectAnswers());
            intent.putExtra("incorrect", getIncorrectAns());
            startActivity(intent);
            finish();
        }
    }

}