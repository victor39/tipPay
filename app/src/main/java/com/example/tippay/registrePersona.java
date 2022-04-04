package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class registrePersona extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre_persona);
    }
    public void clickRegistreUsuari(View view) {
        Intent registreUsuari = new Intent ( this , registreUsuari.class);
        startActivity(registreUsuari);
    }
}