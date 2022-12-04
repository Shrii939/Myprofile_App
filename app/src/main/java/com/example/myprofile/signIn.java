package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signIn extends AppCompatActivity {
    EditText Username, Password;
    Button sin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Username = findViewById(R.id.uname);
        Password = findViewById(R.id.psswd);
        sin = findViewById(R.id.signInBtn);
        sin.setOnClickListener(view -> sign_In(view));
    }

    public void sign_In(View v) {
        Bundle bundleSI = getIntent().getExtras();
        String userame = bundleSI.getString("uid");
        String passwd = bundleSI.getString("password");

        if (Username.getText().toString().equals(userame) && Password.getText().toString().equals(passwd)) {
            Toast.makeText(this, "Sign In Successful", Toast.LENGTH_SHORT).show();

            Intent profileIntent = new Intent(this, profile.class);
            profileIntent.putExtras(bundleSI);
            startActivity(profileIntent);
            finish();
        }else if(!(Password.getText().toString().equals(passwd))){
            Toast.makeText(this,"password did not match", Toast.LENGTH_SHORT).show();
        }else if(!(Username.getText().toString().equals(userame))){
            Toast.makeText(this, "username is wrong", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
