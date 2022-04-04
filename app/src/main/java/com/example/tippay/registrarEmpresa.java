package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class registrarEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empresa);
    }
    public void iniciarEmpresa(View view) {
        Intent iniciarEmpresa = new Intent ( this , IniciarTreballador.class);
        startActivity(iniciarEmpresa);
    }
}