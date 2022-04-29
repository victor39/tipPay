package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class registreUsuari extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre_usuari);
    }

    public void registrarUsuari(View view) {
        Intent registrarUsuari = new Intent(this, registrePersona.class);
        startActivity(registrarUsuari);
    }

    public void sessioIniciada(View view) {
        Intent sessioIniciada = new Intent(this, IniciarSessio.class);
        startActivity(sessioIniciada);
    }
}