package com.example.netcampproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
    EditText e1,e2,e3;
    FirebaseAuth firebaseAuth;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
        b1=findViewById(R.id.editrem);
        b2=findViewById(R.id.fourbtn);
        firebaseAuth=FirebaseAuth.getInstance();
        e1=findViewById(R.id.rname1);
        e2=findViewById(R.id.remail1);
        e3=findViewById(R.id.rpass1);
        e3.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                if(s1.isEmpty() || s2.isEmpty()){
                    Toast.makeText(Registration.this, "Plz fill the all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    if(s3.isEmpty()){
                        Toast.makeText(Registration.this, "Plz fill the all fields", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else {
                        firebaseAuth.createUserWithEmailAndPassword(s2,s3).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(Registration.this, "Database Updated", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(Registration.this, "Database is NOt updated  ", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }

                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Registration.this,Login.class);
                startActivity(i);
                finish();
            }
        });
    }
}