package com.example.kars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.kars.R.*;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SaveCar extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private Button to_vignette;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(layout.activity_save_car);
        mAuth = FirebaseAuth.getInstance();


        final FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null)
            return;
        mDatabase = FirebaseDatabase.getInstance().getReference();

        to_vignette = findViewById(id.button_to_vignette);
        to_vignette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SaveCar.this, VignetteActivity.class);
                startActivity(myIntent);
            }
        });

        Button toLocation = findViewById(id.button);
        toLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SaveCar.this, MapsActivity.class);
                startActivity(myIntent);
            }
        });

    }
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_car, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == menu.save_car)  {
            //TODO Save
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
