package com.example.womensshelter;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

//import android.annotation.SuppressLint;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class secActivity extends AppCompatActivity {

    EditText etphn;
    Button btnCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        etphn = findViewById(R.id.txv1);
        btnCall = findViewById(R.id.button);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String mob = etphn.getText().toString();
                if (ActivityCompat.checkSelfPermission(secActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(secActivity.this, "You Have to granted to make at call", Toast.LENGTH_SHORT).show();
                    requestPermissionsToCall();

                } else {
                    if (mob.isEmpty()) {
                        Toast.makeText(secActivity.this, "Mobile number cannot be empty", Toast.LENGTH_SHORT).show();
                        etphn.setText("1097.");
                    } else {
                        callIntent.setData(Uri.parse("tel:" + mob));
                        startActivity(callIntent);
                    }
                }
            }
        });
    }

    private void requestPermissionsToCall() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
    }

    private class CALL_PHONE {
    }
}




