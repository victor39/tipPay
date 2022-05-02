package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class registreEmpresa extends AppCompatActivity {
    EditText  nieEmp,dniEmp,ubiEmp,nomEmp,nomProp,tipus;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre_empresa);

        nieEmp = findViewById(R.id.registreEmpresaNIE);
        dniEmp = findViewById(R.id.registreEmpresaDNI);
        ubiEmp = findViewById(R.id.registreEmpresaUbicacio);
        nomEmp = findViewById(R.id.registreEmpresaNom);
        nomProp = findViewById(R.id.registreEmpreNomPropietari);
        tipus = findViewById(R.id.registreEmpresaTipusLocal);

    }
    public void registre2Empresa(View view) {
        Intent registreEmpresa2 = new Intent ( this , registrarEmpresa.class);
        bundle.putString("nie", String.valueOf(nieEmp.getText()));
        bundle.putString("dni", String.valueOf(dniEmp.getText()));
        bundle.putString("ubi", String.valueOf(ubiEmp.getText()));
        bundle.putString("nomEmp", String.valueOf(nomEmp.getText()));
        bundle.putString("nomProp", String.valueOf(nomProp.getText()));
        bundle.putString("tipus", String.valueOf(tipus.getText()));
        registreEmpresa2.putExtras(bundle);

        startActivity(registreEmpresa2);
    }
    public void returnEmpresa(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);

    }
}