package com.example.netcampproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Call extends AppCompatActivity {
    private static final int REQUEST_CALL=1;
    private EditText e1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        getSupportActionBar().setTitle("Calling App");

        e1=findViewById(R.id.pcall);
        b1=findViewById(R.id.call);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makecall();
            }
        });
    }
    private void makecall(){
        String number=e1.getText().toString();
        if(number.trim().length()>0){

            if(ContextCompat.checkSelfPermission(Call.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(Call.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);

            }
            else {
                String dial="tel:" +number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==REQUEST_CALL){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                makecall();
            }
            else {
                Toast.makeText(this, "Permision denide", Toast.LENGTH_SHORT).show();
            }
        }
    }
}