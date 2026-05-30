package com.example.my1hourapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserInfo extends AppCompatActivity {

    // Step 1: Declare UI variables here
    private EditText txtName, txtPhNo, txtEmail, txtDepartment;
    private Button BtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Step 2: Initialize your UI components below the system window listener
        txtName = findViewById(R.id.TxtName);
        txtPhNo = findViewById(R.id.TxtPhNo);
        txtEmail = findViewById(R.id.TxtEmail);
        txtDepartment = findViewById(R.id.TxtDepartment);
        BtnSave = findViewById(R.id.BtnSave);

        // Step 3: Set up the click handler for your save button
        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Read text inputs and trim whitespace
                String name = txtName.getText().toString().trim();
                String phone = txtPhNo.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();
                String department = txtDepartment.getText().toString().trim();

                // Step 4: Validate inputs sequentially
                if (name.isEmpty()) {
                    txtName.setError("Name cannot be left blank");
                    txtName.requestFocus();
                } else if (phone.isEmpty()) {
                    txtPhNo.setError("Phone number is required");
                    txtPhNo.requestFocus();
                } else if (email.isEmpty()) {
                    txtEmail.setError("Email address is required");
                    txtEmail.requestFocus();
                } else if (department.isEmpty()) {
                    txtDepartment.setError("Department is required");
                    txtDepartment.requestFocus();
                } else {
                    // Success! Display the native pop-up alert confirmation
                    String successAlert = "Saved successfully for: " + name;
                    Toast.makeText(UserInfo.this, successAlert, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}