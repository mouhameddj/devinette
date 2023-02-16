package com.example.devinette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    // creating a variable
    // for our text view..
    private TextView userNameTV;

    // button for logout
    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        logoutBtn = findViewById(R.id.idBtnLogout);

        // initializing our variables
        userNameTV = findViewById(R.id.idTVUserName);

        // getting data from intent.
        String name = getIntent().getStringExtra("username");

        // setting data to our text view.
        userNameTV.setText(name);

        // initializing click listener for logout button
        logoutBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {



                        Intent i = new Intent(Home.this, MainActivity.class);
                               i.putExtra("Nom", userNameTV.getText().toString());

                        startActivity(i);
                            finish();
                    }
                });}}