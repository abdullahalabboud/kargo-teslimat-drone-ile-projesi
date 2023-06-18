package com.example.kargo_drone_ile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class KargoActivity extends AppCompatActivity {
    Button mapBtn , qrBtn , saveBtn;
    TextInputEditText editTextCargoName , editTextTakerName , editTextPhone ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kargo);

        mapBtn = findViewById(R.id.mapPointBtn);
        qrBtn = findViewById(R.id.checkQRBtn);
        saveBtn = findViewById(R.id.saveCargoBtn);

        editTextCargoName = findViewById(R.id.editTxtCargoName);
        editTextTakerName = findViewById(R.id.editTxtTakerName);
        editTextPhone = findViewById(R.id.editTxtPhoneNumber);
    }
}