package com.example.healthhub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class Register extends AppCompatActivity {


    EditText fullname , pharmacyname ,username,password,email,address,contact;
    TextView loginRedirectText;
    Button registerButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        fullname = findViewById(R.id.fullname);
        pharmacyname = findViewById(R.id.pharmacyname);
        username= findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        contact = findViewById(R.id.contact);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        registerButton = findViewById(R.id.register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use unique variable names to avoid conflicts
                String inputFullName = fullname.getText().toString().trim();
                String inputPharmacyName = pharmacyname.getText().toString().trim();
                String inputUsername = username.getText().toString().trim(); // Adjust to match the XML ID
                String inputPassword = password.getText().toString().trim(); // Adjust to match the XML ID
                String inputEmail = email.getText().toString().trim();       // Adjust to match the XML ID
                String inputAddress = address.getText().toString().trim();   // Adjust to match the XML ID
                String inputContact = contact.getText().toString().trim();   // Adjust to match the XML ID

                // Check if any field is empty
                if (inputFullName.isEmpty() || inputPharmacyName.isEmpty() || inputUsername.isEmpty() ||
                        inputPassword.isEmpty() || inputEmail.isEmpty() || inputAddress.isEmpty() ||
                        inputContact.isEmpty()) {
                    Toast.makeText(Register.this, "Registration Failed - All fields must be filled", Toast.LENGTH_SHORT).show();
                } else {
                    // Save the data (e.g., using SharedPreferences or a database)
                    SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("FullName", inputFullName);
                    editor.putString("PharmacyName", inputPharmacyName);
                    editor.putString("Username", inputUsername);
                    editor.putString("Password", inputPassword); // Hash this for better security in production
                    editor.putString("Email", inputEmail);
                    editor.putString("Address", inputAddress);
                    editor.putString("Contact", inputContact);
                    editor.apply();

                    Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to SignUpActivity
                Intent intent = new Intent(Register.this, PharmasistLogin.class);
                startActivity(intent);
            }
        });



    }

}