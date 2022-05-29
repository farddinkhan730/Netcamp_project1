package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().hide();
        b1=findViewById(R.id.videoply);
        b2=findViewById(R.id.Textspeek);
        b3=findViewById(R.id.qui);
        b4=findViewById(R.id.vibrat);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity4.this, "Video Player App", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity4.this,Video_player.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity4.this, "Text To Speak App", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity4.this,Text_to_Speek.class));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity4.this, "CALCULATOR APP", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity4.this,Quizfirst.class));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity4.this, "Vibrator App", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity4.this,Viberator.class));
            }
        });
    }
}