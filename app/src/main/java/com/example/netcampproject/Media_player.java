package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class Media_player extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ToggleButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        b1=findViewById(R.id.toggleButton2);
        getSupportActionBar().hide();
        mediaPlayer=MediaPlayer.create(this,R.raw.r);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1.isChecked()==true) {
                    mediaPlayer.start();
                }
                else {
                    mediaPlayer.pause();
                }
            }
        });
    }
}