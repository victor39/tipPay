package com.example.tippay;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import clases.Treballador;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {

    Connection connect;
    String ConnnectionResult = "";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String dni = "41533673C";
        String nom = "Adrià";
        String cognom1 = "Duran";
        String cognom2 = "Portell";
        LocalDate datanaix = LocalDate.of(1999, 05, 01);
        String telefono = "722572442";
        String correu = "aduran@inspalamos.cat";
        String codipostal = "17250";
        String paypal = "123345";
        String comptebancari = "ES1233456789";


        Treballador tre = new Treballador(dni, nom, cognom1, cognom2, datanaix, telefono, correu, codipostal, paypal, comptebancari);
        tre.insert(MainActivity.this);
    }

    public void IniciarSessio(View view) {
        Intent iniciarSessio = new Intent ( this , IniciarSessio.class);
        startActivity(iniciarSessio);
    }
    public void registrarEmpresa(View view) {
        Intent registrarEmpresa = new Intent ( this , registreEmpresa.class);
        startActivity(registrarEmpresa);
    }
    public void registrarPersona(View view) {
        Intent registrarPersona = new Intent ( this , registrePersona.class);
        startActivity(registrarPersona);
    }


    public void intento(View view) {
        try {
            Connexio con = new Connexio();
            connect = con.connexioClass();

            if (connect != null) {
                String query = "select * from persona";
            }
        }
        catch(Exception ex){

        }
    }
}