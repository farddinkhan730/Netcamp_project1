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

public class Login extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    EditText e1,e2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        b1=findViewById(R.id.otpbutton);
        e1=findViewById(R.id.ologin);
        e2=findViewById(R.id.ootp);
        e2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        firebaseAuth=FirebaseAuth.getInstance();
        b2=findViewById(R.id.twobtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                    if (s1.isEmpty()) {
                        Toast.makeText(Login.this, "Plz fill all the fields", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else {
                        if (s2.isEmpty()) {
                            Toast.makeText(Login.this, "Plzz fill all the fields", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else {
                            firebaseAuth.signInWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Login.this, "Login Succesfull", Toast.LENGTH_SHORT).show();
                                   startActivity(new Intent(Login.this,MainActivity2.class));
                                   finish();
                                    } else {
                                        Toast.makeText(Login.this, "You are not registered with us", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(Login.this, Registration.class);
                                        startActivity(i);
                                        finish();
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
                Intent i=new Intent(Login.this,Registration.class);
                startActivity(i);
                finish();
            }
        });


    }
}