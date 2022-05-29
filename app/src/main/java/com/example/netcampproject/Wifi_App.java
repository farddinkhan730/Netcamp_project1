package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class Wifi_App extends AppCompatActivity {
    ToggleButton b1;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi__app);
        b1=findViewById(R.id.wifibtn);
        getSupportActionBar().setTitle("WIFI APP");
        wifiManager=(WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1.isChecked()==true){
                    wifiManager.setWifiEnabled(true);
                }
                else {
                    wifiManager.setWifiEnabled(false);
                }
            }
        });

    }
}