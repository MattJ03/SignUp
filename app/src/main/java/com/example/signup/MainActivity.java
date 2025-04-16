package com.example.signup;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String CHANNEL_ID = "Signup_channel";
    EditText emailAddress, password;
    Button subButton;

    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

     NotificationHelper.createNotificationChannel(this);

    emailAddress = findViewById(R.id.editTextTextEmailAddress);
    password = findViewById(R.id.editTextTextPassword);
    subButton = findViewById(R.id.submitBtn);

    subButton.setOnClickListener(view -> {
        if(emailAddress.toString().isEmpty() || password.toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Sign up failed", Toast.LENGTH_SHORT).show();
            NotificationHelper.sendNotification(MainActivity.this, CHANNEL_ID, "sign up", "sign up failed");

        } else {
            Toast.makeText(MainActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();
            NotificationHelper.sendNotification(MainActivity.this, CHANNEL_ID, "Signed up", "Sign up successful");
        }
    });
    }
}