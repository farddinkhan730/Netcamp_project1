package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sms_App extends AppCompatActivity {
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms__app);
        e1=findViewById(R.id.txtphone);
        e2=findViewById(R.id.txtmsg);
        getSupportActionBar().setTitle("SMS APP");


    }
    public void btn_send(View view){
        int permisioncheck= ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if(permisioncheck== PackageManager.PERMISSION_GRANTED){
            MyMessage();
        }
        else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},0);
        }
    }
    public void MyMessage(){
        String phone=e1.getText().toString().trim();
        String msg=e2.getText().toString();
        if(!phone.equals("") || !msg.equals("")) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone, null, msg, null, null);
            Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Plz fill the fields", Toast.LENGTH_SHORT).show();
        }
    }
}