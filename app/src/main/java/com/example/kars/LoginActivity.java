package com.example.kars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        configureButton();

        mAuth = FirebaseAuth.getInstance();
    }
    @Override
    public void onStart () {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    private void updateUI (FirebaseUser currentUser){

        setContentView(R.layout.activity_login);
    }


    private void configureButton() {
        Button mButtonRegister = findViewById(R.id.logRegister);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(myIntent);
            }
        });
    }

}
