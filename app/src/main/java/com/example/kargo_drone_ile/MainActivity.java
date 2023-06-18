package com.example.kargo_drone_ile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button loginPageBtn , registerPageBtn ;
    ProgressBar mainLoadingPage;

    FirebaseAuth mAuth;


    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i = new Intent(getApplicationContext() , ApplicationActivity.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        loginPageBtn = findViewById(R.id.loginPageBtn);
        registerPageBtn = findViewById(R.id.registerPageBtn);
//         don't show progress bar before pass to pages buttons
        mainLoadingPage = findViewById(R.id.mainLoadingProgressBar);
        mainLoadingPage.setVisibility(View.INVISIBLE);

        loginPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainLoadingPage.setVisibility(View.GONE);
                try {
                    Intent i = new Intent(getApplicationContext() , Login.class);
                    startActivity(i);
                    finish();

                }
                catch (Exception e){
                    System.out.print(e.toString());
                }

            }
        });
        registerPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext() , Register.class);
                startActivity(i);
                mainLoadingPage.setVisibility(View.GONE);
                finish();
            }
        });

    }
}