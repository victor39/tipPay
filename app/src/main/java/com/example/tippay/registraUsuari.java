package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import clases.Client;
import clases.Treballador;

public class registraUsuari extends AppCompatActivity {

    String contra ,adni, aNom, aCognom,aCognom2,aNaix,aTelefon,aCorreu,aCP ,aPayPal ,data;
    EditText nomUsuari,correu ,contraseña,contraseña2;
    Bundle extras = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra_usuari);

        Bundle extras = getIntent().getExtras();
        adni = extras.getString("dni");
        aNom = extras.getString("nom");
        aCognom = extras.getString("cognom");
        aCognom2 = extras.getString("cognom2");
        aNaix = extras.getString("dataNaix");
        aTelefon = extras.getString("telefon");
        aCorreu = extras.getString("correu");
        aCP = extras.getString("Cp");
        aPayPal = extras.getString("PayPal");
        data = extras.getString("dataNaix");

        nomUsuari = findViewById(R.id.registreUsuariNomUsuari);
        correu = findViewById(R.id.registreUsuariEmail);
        contraseña = findViewById(R.id.registreUsuariContra);
        contraseña2 = findViewById(R.id.registreUsuariContra2);



    }
    public void sessioIniciada(View view) {
        if((contraseña.getText().toString().equals(contraseña2.getText().toString()))){
            contra = contraseña.getText().toString();
            System.out.println(contra);
            Intent sessioIniciada = new Intent(this, principalClient.class);
            extras.putString("nom", String.valueOf(nomUsuari.getText()));
            startActivity(sessioIniciada);

            Client clt = new Client(adni, aNom, aCognom, aCognom2,data,aTelefon, aCorreu,aCP, aPayPal,contra,null,nomUsuari.getText().toString());
            clt.insert(registraUsuari.this);
            Toast toast1 = Toast.makeText(getApplicationContext(),"Usuari afegit /n Benvingut " + nomUsuari, Toast.LENGTH_SHORT);toast1.show();
            System.out.println("Usuari afegit");
        }else {
            Toast toast2 = Toast.makeText(getApplicationContext(),"Tornar a omplir contraseña", Toast.LENGTH_SHORT);toast2.show();
            System.out.println("Contraseña erronea");
            contraseña.setText("");
            contraseña2.setText("");
        }
    }

    public void returnMain(View view) {
        Intent returnMain = new Intent(this, MainActivity.class);
        startActivity(returnMain);
    }

}