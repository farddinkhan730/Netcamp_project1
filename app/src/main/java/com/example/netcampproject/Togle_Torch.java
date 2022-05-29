package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class Togle_Torch extends AppCompatActivity {
    CameraManager cameraManager;
    ToggleButton b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_togle__torch);
        getSupportActionBar().hide();
        cameraManager=(CameraManager) getSystemService(CAMERA_SERVICE);
        b1=findViewById(R.id.toggleButton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1.isChecked()==true){
                    try {
                        String s=cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(s, true);
                    }
                    catch (Exception e){

                    }
                }
                else {
                    try {
                        String s=cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(s, false);
                    }
                    catch (Exception e){

                    }
                }
            }
        });
    }
}