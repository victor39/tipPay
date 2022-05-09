package com.example.tippay;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class registreEmpresa extends AppCompatActivity {
    EditText  nieEmp,dniEmp,ubiEmp,nomEmp,nomProp,direccio, cpEmp,paypal;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre_empresa);


        nieEmp = findViewById(R.id.registreEmpresaNIE);
        nomEmp = findViewById(R.id.registreEmpresaNom);
        cpEmp = findViewById(R.id.registreEmpresaCP);
        ubiEmp = findViewById(R.id.registreEmpresaUbicacio);
        dniEmp = findViewById(R.id.TExtInput);
        nomProp = findViewById(R.id.registreEmpresaDireccio);
        direccio = findViewById(R.id.registreEmpresaDireccio);
        paypal = findViewById(R.id.registreEmpresaPAY);


    }
    public void registre2Empresa(View view) {
        Intent registreEmpresa2 = new Intent ( this , registrarEmpresa.class);
        bundle.putString("nie", String.valueOf(nieEmp.getText()));
        bundle.putString("nomEmp", String.valueOf(nomEmp.getText()));
        bundle.putString("cpEmp", String.valueOf(cpEmp.getText()));
        bundle.putString("ubi", String.valueOf(ubiEmp.getText()));
        bundle.putString("dni", String.valueOf(dniEmp.getText()));
        bundle.putString("nomProp", String.valueOf(nomProp.getText()));
        bundle.putString("direccio", String.valueOf(direccio.getText()));
        bundle.putString("paypal", String.valueOf(paypal.getText()));
        registreEmpresa2.putExtras(bundle);
        startActivity(registreEmpresa2);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void returnEmpresa(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);

    }
}