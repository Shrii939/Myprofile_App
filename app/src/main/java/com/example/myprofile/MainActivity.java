package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        getSupportActionBar().hide();

//        Intent intent;
//        new Handler().postDelayed({
//                intent = new Intent(this, signup.class)
//                startActivity(intent)
//                finish()
//        }, 1500)

        new  Handler().postDelayed(() -> {
            Intent signupIntent = new Intent(this, signup.class);
            startActivity(signupIntent);
            finish();
        }, 1700);


    }
}

