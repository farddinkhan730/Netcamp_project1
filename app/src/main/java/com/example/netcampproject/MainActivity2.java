package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        b1=findViewById(R.id.phone_services);
        b2=findViewById(R.id.Tourchser);
        b3=findViewById(R.id.more);
        b4=findViewById(R.id.media_player);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Phone Apps", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity2.this,Phone_services.class));

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Torch App", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity2.this,MainActivity3.class));

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Media Player", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity2.this, MainActivity4.class));


            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Media Player", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity2.this, Media_player.class));


            }
        });
    }
}