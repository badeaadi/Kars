package com.example.kars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private EditText mEditTextPasswordConfirm;

    private static final String TAG = "EmailPassword";
    private String email;
    private String password;
    private String passwordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEditTextEmail = findViewById(R.id.email);
        mEditTextPassword = findViewById(R.id.password_register);
        mEditTextPasswordConfirm = findViewById(R.id.password_confirmation_register);

        configureBackButton();

        mAuth = FirebaseAuth.getInstance();


        configureRegisterButton();
    }
    private void configureBackButton() {
        Button mButtonRegister = findViewById(R.id.regLogin);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(myIntent);
            }
        });
    }

    private void configureRegisterButton() {
        Button mButtonRegister = findViewById(R.id.regRegister);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = mEditTextEmail.getText().toString();
                password = mEditTextPassword.getText().toString();
                passwordConfirm = mEditTextPasswordConfirm.getText().toString();

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                }
                                else {
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                            }
                        });
            }
        });
    }
    private void updateUI(FirebaseUser user) {

        Intent myIntent = new Intent(RegisterActivity.this, SaveCar.class);
        startActivity(myIntent);

    }
}
