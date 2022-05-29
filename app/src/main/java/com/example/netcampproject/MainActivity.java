package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        b1=findViewById(R.id.auth);
        b2=findViewById(R.id.real);
        b3=findViewById(R.id.gsignin);
        b4=findViewById(R.id.otp);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Enter all the details", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,Login.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,real_time_database_login.class);
                startActivity(i);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Login with Google", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,Google_login.class));
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Login with OTP", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,Otp.class));
                finish();
            }
        });
    }
}