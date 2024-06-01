package com.example.quizapp;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

        LinearLayout csharpLayout;
        LinearLayout javaLayout;
        LinearLayout sqlLayout;
        LinearLayout oracleLayout;
        public Button startquiz;
        private String selectedTopic = "";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            csharpLayout = findViewById(R.id.csharpquiz);
            javaLayout = findViewById(R.id.javaquiz);
            sqlLayout = findViewById(R.id.sqlquiz);
            oracleLayout = findViewById(R.id.oraclequiz);
            startquiz = findViewById(R.id.startbtn);

            csharpLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedTopic = "CSHARP";

                    csharpLayout.setBackgroundResource(R.drawable.round_color_background);
                    javaLayout.setBackgroundResource(R.drawable.round_background);
                    sqlLayout.setBackgroundResource(R.drawable.round_background);
                    oracleLayout.setBackgroundResource(R.drawable.round_background);

                }
            });

            javaLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedTopic = "JAVA";

                    javaLayout.setBackgroundResource(R.drawable.round_color_background);
                    csharpLayout.setBackgroundResource(R.drawable.round_background);
                    sqlLayout.setBackgroundResource(R.drawable.round_background);
                    oracleLayout.setBackgroundResource(R.drawable.round_background);

                }
            });
            sqlLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedTopic = "SQL";

                    sqlLayout.setBackgroundResource(R.drawable.round_color_background);
                    csharpLayout.setBackgroundResource(R.drawable.round_background);
                    javaLayout.setBackgroundResource(R.drawable.round_background);
                    oracleLayout.setBackgroundResource(R.drawable.round_background);

                }
            });
            oracleLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedTopic = "ORACLE";

                    oracleLayout.setBackgroundResource(R.drawable.round_color_background);
                    csharpLayout.setBackgroundResource(R.drawable.round_background);
                    javaLayout.setBackgroundResource(R.drawable.round_background);
                    sqlLayout.setBackgroundResource(R.drawable.round_background);

                }
            });

            startquiz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(selectedTopic.isEmpty()){
                        Toast.makeText(MainActivity.this, "Please choose topic", Toast.LENGTH_SHORT).show();
                    } else{
                        Intent intent = new Intent(MainActivity.this,quizPage.class);
                        intent.putExtra("selectedTopic",selectedTopic);
                        startActivity(intent);
                    }
                }
            });


        }
    }



