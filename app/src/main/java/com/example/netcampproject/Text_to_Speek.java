package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class Text_to_Speek extends AppCompatActivity {
    TextToSpeech textToSpeech;
    EditText e1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to__speek);
        getSupportActionBar().setTitle("Text to Speak App");
        e1=findViewById(R.id.editText);
        b1=findViewById(R.id.speek);
        textToSpeech=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.ENGLISH);
                textToSpeech.setSpeechRate(0.9f);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(e1.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });

    }
}