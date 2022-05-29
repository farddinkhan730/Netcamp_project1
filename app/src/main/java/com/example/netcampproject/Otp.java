package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class Otp extends AppCompatActivity {
    EditText e1;
    Button b1;
    CountryCodePicker ccp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        getSupportActionBar().hide();
        e1 = findViewById(R.id.editTextPhone);
        b1 = findViewById(R.id.otpbutton);
        ccp = findViewById(R.id.ccpc);
        ccp.registerCarrierNumberEditText(e1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().length() != 10) {
                    Toast.makeText(Otp.this, "Please Check Your Number", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(Otp.this, Otp_confirm.class);
                    i.putExtra("mobile", ccp.getFullNumberWithPlus().trim());
                    startActivity(i);
                }
            }
        });
    }
}