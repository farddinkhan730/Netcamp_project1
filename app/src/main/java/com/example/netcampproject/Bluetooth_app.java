package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class Bluetooth_app extends AppCompatActivity {
    BluetoothManager bluetoothManager;
    ToggleButton b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_app);
        bluetoothManager=(BluetoothManager)getSystemService(BLUETOOTH_SERVICE);
        getSupportActionBar().setTitle("Bluetooth App");
        b1=findViewById(R.id.bluetoothbtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1.isChecked()==true){
                    bluetoothManager.getAdapter().enable();
                }
                else {
                    bluetoothManager.getAdapter().disable();
                }
            }
        });
    }
}