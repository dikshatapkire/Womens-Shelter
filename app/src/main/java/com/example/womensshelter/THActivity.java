package com.example.womensshelter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class THActivity extends AppCompatActivity {

    Button btAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thactivity);
        btAlert = findViewById(R.id.btn);
        btAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         startService(new Intent(THActivity.this, MyService.class));
                Toast.makeText(THActivity.this, "Alert!!!!!!!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}