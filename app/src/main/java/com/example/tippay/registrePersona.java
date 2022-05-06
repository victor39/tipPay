package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registrePersona extends AppCompatActivity {
    EditText adni, aNom, aCognom,aCognom2,aNaix,aTelefon,aCorreu,aCP ,aPayPal ;
    Button btSeguent,informacio;
    Bundle valores = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Registre");
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
        aCP = findViewById(R.id.registreCP);
        aPayPal = findViewById(R.id.registrePAYPAL);

    }
    public void seguent(View view) {
        Intent seguent = new Intent(this, registraUsuari.class);
        valores.putString("dni", String.valueOf(adni.getText()));
        valores.putString("nom", String.valueOf(aNom.getText()));
        valores.putString("cognom", String.valueOf(aCognom.getText()));
        valores.putString("cognom2", String.valueOf(aCognom2.getText()));
        valores.putString("dataNaix", String.valueOf(aNaix.getText()));
        valores.putString("telefon", String.valueOf(aTelefon.getText()));
        valores.putString("correu", String.valueOf(aCorreu.getText()));
        valores.putString("Cp", String.valueOf(aCP.getText()));
        valores.putString("PayPal", String.valueOf(aPayPal.getText()));
        seguent.putExtras(valores);
        startActivity(seguent);

    }

    public void returnPersona(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);

    }

    public void info(View view) {
        Intent main = new Intent(this, informacioPopUp.class);
        startActivity(main);
    }
}



