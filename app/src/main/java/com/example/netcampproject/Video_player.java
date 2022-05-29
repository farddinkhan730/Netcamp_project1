package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video_player extends AppCompatActivity {
    VideoView v1;
    MediaController m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        getSupportActionBar().setTitle("Video Player App");
        getSupportActionBar().hide();
        v1=findViewById(R.id.videoView);
        m1=new MediaController(this);
        v1.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.dar);
        v1.setMediaController(m1);
        m1.setAnchorView(v1);
        v1.start();
    }
}