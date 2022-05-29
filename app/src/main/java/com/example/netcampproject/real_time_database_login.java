package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class real_time_database_login extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_real_time_database_login);
        e1=findViewById(R.id.realname2);
        e2=findViewById(R.id.realemail2);
        e3=findViewById(R.id.realpass2);
        e4=findViewById(R.id.realphone2);
        b1=findViewById(R.id.realregis2);
        firebaseDatabase=FirebaseDatabase.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference=firebaseDatabase.getReference("user");
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();

                if(s4.length()!=10){
                    Toast.makeText(real_time_database_login.this, "Plz enter correct phone number", Toast.LENGTH_SHORT).show();
                }
                else {
                    user user=new user(s1,s2,s3,s4);
                    databaseReference.child(s2).setValue(user);
                    Toast.makeText(real_time_database_login.this, "data base save", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}