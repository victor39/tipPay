package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registrePersona extends AppCompatActivity {
    EditText adni, aNom, aCognom,aCognom2,aNaix,aTelefon,aCorreu,aCP ,aCompteBancari ;
    Button btSeguent;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre_persona);

        btSeguent = findViewById(R.id.btSeguentRegistre);
        adni = findViewById(R.id.registreDNI);
        aNom = findViewById(R.id.registreNom);
        aCognom = findViewById(R.id.registreCognom);
        aCognom2 = findViewById(R.id.registreCognom2);
        aNaix = findViewById(R.id.registreDataNaix);
        aTelefon = findViewById(R.id.registreTelef);
        aCorreu = findViewById(R.id.registreCorreu);
        aCP = findViewById(R.id.registreDataNaix);
        aCompteBancari = findViewById(R.id.registreCompteBancari);

    }

    public void seguent(View view) {
        Intent seguent = new Intent(this, registreUsuari.class);
        bundle.putString("dni", String.valueOf(adni.getText()));
        bundle.putString("nom", String.valueOf(aNom.getText()));
        bundle.putString("cognom", String.valueOf(aCognom.getText()));
        bundle.putString("cognom2", String.valueOf(aCognom2.getText()));
        bundle.putString("dataNaix", String.valueOf(aNaix.getText()));
        bundle.putString("telefon", String.valueOf(aTelefon.getText()));
        bundle.putString("correu", String.valueOf(aCorreu.getText()));
        bundle.putString("Cp", String.valueOf(aCP.getText()));
        bundle.putString("CompteBancari", String.valueOf(aCompteBancari.getText()));
        seguent.putExtras(bundle);
        startActivity(seguent);

    }

    public void returnPersona(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);

    }
}



