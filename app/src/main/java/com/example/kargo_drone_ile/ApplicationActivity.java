package com.example.kargo_drone_ile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ApplicationActivity extends AppCompatActivity {

    Button cargoesPageBtn , missionPageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        cargoesPageBtn = findViewById(R.id.cargoesPageBtn);
        missionPageBtn = findViewById(R.id.missionPageBtn);

        cargoesPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ApplicationActivity.this , KargoActivity.class);
                startActivity(i);
                finish();
            }
        });
        missionPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ApplicationActivity.this , MissionActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}