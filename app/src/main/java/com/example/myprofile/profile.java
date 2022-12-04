package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends AppCompatActivity {

    TextView userName, FullName, USN, DateOFBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toast.makeText(this, "profile page", Toast.LENGTH_SHORT).show();
        userName = findViewById(R.id.usernameProfiler);
        FullName = findViewById(R.id.fullName);
        USN = findViewById(R.id.USN_profiler);
        DateOFBirth = findViewById(R.id.dateOfBirth);

        display();

    }

    @SuppressLint("SetTextI18n")
    public void display() {
        Bundle bundleProfiler = getIntent().getExtras();

        String username = bundleProfiler.getString("uid");
        String full_name = bundleProfiler.getString("fullname");
        String usn = bundleProfiler.getString("usn");
        String dob = bundleProfiler.getString("DOB");

        userName.setText("UserName: " + username);
        FullName.setText("Full Name: " + full_name);
        USN.setText("USN: " + usn);
        DateOFBirth.setText("Date Of Birth: " + dob);
    }

}