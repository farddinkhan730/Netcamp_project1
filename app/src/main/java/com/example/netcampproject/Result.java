package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setTitle("Thank-you for Reviewing Our Project ");
        t1=findViewById(R.id.scores);
        t1.setText(t1.getText()+" :- "+Quizfirst.score);
    }

}