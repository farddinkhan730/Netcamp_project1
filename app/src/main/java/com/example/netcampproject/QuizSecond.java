package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class QuizSecond extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_second);
        getSupportActionBar().setTitle("Quiz App");
        b1=(Button)findViewById(R.id.subbtn2);
        r1=(RadioButton)findViewById(R.id.radioButton5);
        r2=(RadioButton)findViewById(R.id.radioButton6);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(r1.isChecked()){
                    ++Quizfirst.score;
                }
                else {
                    --Quizfirst.score;
                }
                Intent i=new Intent(QuizSecond.this,QuizThird.class);
                startActivity(i);
                finish();
            }
        });
    }
}