package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Button_tourch extends AppCompatActivity {
    Button b1,b2;
    CameraManager cameraManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_tourch);
        getSupportActionBar().hide();
        b1=findViewById(R.id.Torchonbtn);
        b2=findViewById(R.id.torchoffbtn);
        cameraManager=(CameraManager)getSystemService(CAMERA_SERVICE);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s=cameraManager.getCameraIdList()[0];
                    cameraManager.setTorchMode(s,true);
                }
                catch (CameraAccessException e){

                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s=cameraManager.getCameraIdList()[0];
                    cameraManager.setTorchMode(s,false);
                }
                catch (CameraAccessException e){

                }
            }
        });
    }
}