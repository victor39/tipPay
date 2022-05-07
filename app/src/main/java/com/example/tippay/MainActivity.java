package com.example.tippay;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import clases.Empresa;
import clases.Propietari;
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
        this.setTitle("Principal");

        String dni = "56";
        String nom = "jo";
        String cognom1 = "tu";
        String cognom2 = "el";
        String datanaix  = "05/03/1991";
        String telefono = "25";
        String correu = "aduran@inspalamos.cat";
        String codipostal = "17250";
        String paypal = "123345";
        String contrasena = "psw";

        Propietari pro = new Propietari(dni, nom, cognom1, cognom2, datanaix, telefono, correu, codipostal, paypal, contrasena);
        pro.insert(MainActivity.this);

        ArrayList <Treballador> treb = new ArrayList<>();
        String nieEmp = "3445";
        String nomb = "nom";
        String cp = "344";
        int ubi = 434;
        String direccio = "direccio";

        Empresa emp = new Empresa(nieEmp,nomb, cp,ubi,pro,direccio,treb,paypal);
        emp.insert(MainActivity.this);

        pro.buscarPropietari(MainActivity.this);

        //Treballador tre = new Treballador(dni, nom, cognom1, cognom2, datanaix, telefono, correu, codipostal, paypal, contrasena);
       // tre.insert(MainActivity.this);
       // tre.update(MainActivity.this);
        //tre.delete(MainActivity.this);
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
    public void informacio(View view) {
        //Intent informacio = new Intent ( this , informacioPopUp.class);
        //startActivity(informacio);
    }
    public void sortir(View view){
        Toast.makeText(MainActivity.this, "Has tancat la aplicació", Toast.LENGTH_SHORT).show();
        finishAffinity();
    }

}