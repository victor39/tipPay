package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class registreEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre_empresa);
    }
    public void registre2Empresa(View view) {
        Intent registreEmpresa2 = new Intent ( this , registrarEmpresa.class);
        startActivity(registreEmpresa2);
    }
}