package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();
        b1=findViewById(R.id.btntorch);
        b2=findViewById(R.id.ltorch);
        b3=findViewById(R.id.Aceler);
        b4=findViewById(R.id.vibrat);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "Torch App", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity3.this,Button_tourch.class));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "Torch App", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity3.this,Torch_Light_sensor.class));

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "Torch App", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity3.this,Torch_Acelerometer.class));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "Torch App", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity3.this,Togle_Torch.class));
            }
        });
    }
}