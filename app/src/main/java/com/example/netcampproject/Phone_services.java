package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Phone_services extends AppCompatActivity {

    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_services);
        b1=findViewById(R.id.Ca);
        b2=findViewById(R.id.msg);
        b3=findViewById(R.id.wifibutton);
        b4=findViewById(R.id.bluebutton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Phone_services.this, "Calling App", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Phone_services.this,Call.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Phone_services.this, "Message App" , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Phone_services.this,Sms_App.class));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Phone_services.this, "WIFI APP", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Phone_services.this,Wifi_App.class));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Phone_services.this, "Bluetooth App", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Phone_services.this,Bluetooth_app.class));
            }
        });

    }
}