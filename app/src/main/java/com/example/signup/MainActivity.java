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

    EditText usernameInput, passwordInput;
    Button buttonSub;

    String CHANNEL_ID = "Sign up ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        usernameInput = findViewById(R.id.editTextTextEmailAddress);
        passwordInput = findViewById(R.id.editTextTextPassword);
        buttonSub = findViewById(R.id.submitBtn);

        private void createNotificationChannel() {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = getString(R.string.channel_name);
                String description = getString(R.string.channel_description);
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            }
        }


        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String username = usernameInput.getText().toString().trim();
               String password = passwordInput.getText().toString().trim();

           if(username.isEmpty() || password.isEmpty()) {
           Toast.makeText(MainActivity.this, "Enter both username and password", Toast.LENGTH_SHORT).show();
           NotificationCompat.Builder builder1 = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                   .setSmallIcon(R.id.logo)
                   .setContentTitle(notifTitle)
                   .setContentText(failText)
                   .setPriority(NotificationCompat.PRIORITY_DEFAULT);
           } else {
               Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
               NotificationCompat.Builder builder2 = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                       .setSmallIcon(R.id.logo)
                       .setContentTitle(notifTitle)
                       .setContentText(successText)
                       .setPriority(NotificationCompat.PRIORITY_DEFAULT);
           }
           }


            });
    }
}