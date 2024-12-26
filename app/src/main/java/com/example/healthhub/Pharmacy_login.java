package com.example.healthhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pharmacy_login extends AppCompatActivity {
    EditText username;
    EditText Password;
    Button loginButton;
    TextView signUpText; // Add this to handle the "Register Now" navigation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pharmacy_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize the views
        username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signUpText = findViewById(R.id.signUpText); // Initialize the TextView

        // Handle login logic
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("user") && Password.getText().toString().equals("786")) {
                    Toast.makeText(Pharmacy_login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Pharmacy_login.this, "Login Failed - Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set up the "Register Now" TextView to navigate to the Register activity
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pharmacy_login.this, pharmacy_register.class);
                startActivity(intent);
            }
        });
    }
}
