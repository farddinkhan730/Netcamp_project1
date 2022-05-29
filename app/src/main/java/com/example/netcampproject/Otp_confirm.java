package com.example.netcampproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Otp_confirm extends AppCompatActivity {
    EditText e1;
    Button b1;
    FirebaseAuth firebaseAuth;
    String phone;
    String otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_confirm);
        getSupportActionBar().hide();
        e1=findViewById(R.id.ootp);
        b1=findViewById(R.id.ologin);
        phone=getIntent().getStringExtra("mobile".toString());
        firebaseAuth=FirebaseAuth.getInstance();
        genotp();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().isEmpty()){
                    Toast.makeText(Otp_confirm.this, "Plz fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(e1.getText().toString().length()!=6){
                        Toast.makeText(Otp_confirm.this, "Give Valid otp", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otp, e1.getText().toString());
                        signInwithPhoneAuthCredential(credential);
                    }
                }
            }
        });
    }
    private void genotp(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS, this
                , new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp=s; //s has otp
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signInwithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(Otp_confirm.this, "Wrong OTP", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    private void signInwithPhoneAuthCredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Otp_confirm.this, "Database updated", Toast.LENGTH_SHORT).show();
                    Intent j=new Intent(Otp_confirm.this,MainActivity2.class);
                    startActivity(j);
                    finish();
                }
                else {
                    Toast.makeText(Otp_confirm.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}