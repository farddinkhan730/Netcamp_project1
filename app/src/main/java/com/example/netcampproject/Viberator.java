package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class Viberator extends AppCompatActivity {

    Vibrator v1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viberator);
        getSupportActionBar().hide();
        v1=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        b1=findViewById(R.id.vibmn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>26){
                    v1.vibrate(5000);
                }
                else {
                    v1.vibrate(5000);
                }
            }
        });

    }
}