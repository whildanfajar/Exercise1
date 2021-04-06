package com.example.exercise1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class Register extends AppCompatActivity {
    EditText usr, email, alamat, pwd,repwd;
    Button btnrgs, btnbatal;
    CheckBox jenisklm, agama;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        usr = findViewById(R.id.eNama);
        email = findViewById(R.id.edEmail);
        alamat = findViewById(R.id.eAlamat);
        pwd = findViewById(R.id.zPass);
        repwd = findViewById(R.id.edrepass);
        btnrgs = findViewById(R.id.btDaftar);
        btnbatal = findViewById(R.id.btBatal);

        btnrgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usr.getText().toString().isEmpty() ||
                        email.getText().toString().isEmpty() ||
                        alamat.getText().toString().isEmpty() ||
                        pwd.getText().toString().isEmpty() ||
                        repwd.getText().toString().isEmpty() ||
                        jenisklm.getText().toString().isEmpty()||
                        agama.getText().toString().isEmpty())
                {
                    Snackbar.make(view, "Fill in the blank data", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    if (pwd.getText().toString().equals(repwd.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "registration is successful",
                                Toast.LENGTH_LONG).show();
                        Intent i =new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Snackbar.make(view, "password and repassword must be same",
                                Snackbar.LENGTH_LONG).show();
                    }
                }

            }
        });
        btnbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}

