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

public class PharmasistLogin extends AppCompatActivity {
    EditText username;
    EditText Password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pharmasist_login);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Correctly initialize the views
        username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("user") && Password.getText().toString().equals("786")) {
                    Toast.makeText(PharmasistLogin.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PharmasistLogin.this, "Login Failed - Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Inside your MainActivity class
//        TextView signUpText = findViewById(R.id.signUpText); // ID from your XML for the "Sign Up" text
//
//        signUpText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Navigate to SignUpActivity
//                Intent intent = new Intent(PharmasistLogin.this, Register.class);
//                startActivity(intent);
//            }
//        });

    }


}