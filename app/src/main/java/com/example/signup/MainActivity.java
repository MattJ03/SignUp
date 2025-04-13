package com.example.signup;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput, passwordInput;
    Button buttonSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.editTextTextEmailAddress);
        passwordInput = findViewById(R.id.editTextTextPassword);
        buttonSub = findViewById(R.id.submitBtn);

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String username = usernameInput.getText().toString().trim();
               String password = passwordInput.getText().toString().trim();

           if(username.isEmpty() || password.isEmpty()) {
           Toast.makeText(MainActivity.this, "Enter both username and password", Toast.LENGTH_SHORT).show();
           } else {
               Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
           }
           }


            });
    }
}