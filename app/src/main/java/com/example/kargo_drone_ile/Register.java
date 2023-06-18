package com.example.kargo_drone_ile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Register extends AppCompatActivity {

    TextInputEditText editTextEmail , editTextPass;
    Button registerBtn;
    /*define firebase authentication */
    FirebaseAuth mAuth;
    ProgressBar registerProgressBar;
    TextView loginTxt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        /*define the email and pass and button xml elements from xml activity ... */
        editTextEmail = findViewById(R.id.email);
        editTextPass = findViewById(R.id.password);
        registerBtn = findViewById(R.id.btn_register);
        registerProgressBar = findViewById(R.id.registerProgressBar);
        loginTxt = findViewById(R.id.loginTxt);

        /* get instance */
        mAuth = FirebaseAuth.getInstance();


        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext() , Login.class);
                startActivity(i);
                finish();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*define email and passwork and get values from xml values of email and password */
                String email , password ;
                email = editTextEmail.getText().toString();
                password = editTextPass.getText().toString();
                /* on click start run progress bar */
                registerProgressBar.setVisibility(View.VISIBLE);

                /*ckeck if email or pass is empty */
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Register.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Register.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return ;
                }
                mAuth.createUserWithEmailAndPassword(email , password).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                /* end progress bar mission */
                                registerProgressBar.setVisibility(View.GONE);
                                if(task.isSuccessful()){
                                    Toast.makeText(Register.this, "Create New User Successfully ", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(Register.this, "Can't Create New User", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });
    }
}