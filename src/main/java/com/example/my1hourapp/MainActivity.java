package com.example.my1hourapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 1. Class-Level Primitive State Fields
    private int count = 0;
    private static final String KEY_COUNT = "saved_counter_integer"; // Immutable Bundle Key

    // 2. Class-Level UI Field Pointers (Refactored Object Scoping)
    private Button countBtn;
    private Button resetBtn;
    private TextView countTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 3. Synchronous View Binding
        countBtn = findViewById(R.id.CountBtn);
        countTextView = findViewById(R.id.Count);
        resetBtn = findViewById(R.id.ResetBtn);

        // 4. Lifecycle Serialization Restorations
        if (savedInstanceState != null) {
            // Re-assign the local tracker to the historical cached value
            count = savedInstanceState.getInt(KEY_COUNT, 0);
            countTextView.setText(String.valueOf(count));
        }

        // 5. Interface Mutation Event Listeners
        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                countTextView.setText(String.valueOf(count)); // Performance Optimization: Explicit parsing
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                countTextView.setText(String.valueOf(count));
            }
        });
    }

    // 6. Hook Into Destruction Cycle to Save State Data
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Serialize the integer value to a key-value bundle array mapping
        outState.putInt(KEY_COUNT, count);
    }
}