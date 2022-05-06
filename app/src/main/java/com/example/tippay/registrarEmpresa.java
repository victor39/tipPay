package com.example.tippay;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import clases.Empresa;
import clases.Propietari;
import clases.Treballador;

public class registrarEmpresa extends AppCompatActivity {
    String nomEmpresa ,nieEmp,dniEmp,ubiEmp,nomProp,tipus,cp ,direccio,paypal,compteBanc;
    int ubi;
    TextView nomText;
    EditText email,nomEdit,contrasena,contrasena2;
    Button btregistrarEmp;
    ArrayList <Treballador> treb = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empresa);
        Bundle nom = getIntent().getExtras();

        ArrayList <Treballador> treb = new ArrayList<>();

        btregistrarEmp = findViewById(R.id.btRegistrarEmp);
        email = findViewById(R.id.registrarEmailEmpr);
        nomEdit = findViewById(R.id.registrarNomEmpre);
        contrasena = findViewById(R.id.registrarContraEmpr);
        contrasena2 = findViewById(R.id.registrarContraEmp2);

         //falta cp Y direccio PAYPAL
        nieEmp = nom.getString("nie");
        dniEmp = nom.getString("dni");
        ubiEmp = nom.getString("ubi");
        nomProp = nom.getString("nomProp");
        tipus = nom.getString("tipus");


        nomEmpresa = nom.getString("nomEmp");
        nomText = findViewById(R.id.textNomEmpresa);
        nomText.setText(nomEmpresa);

        //Propietari pro = new Propietari(dni, prop, cognom1, cognom2, datanaix, telefono, correu, codipostal, paypal, contrasena3);
       // pro.insert(registrarEmpresa.this);

        //Empresa emp = new Empresa(nieEmp,cp,ubi,pro,direccio,treb,compteBanc,paypal);
       // emp.insert(registrarEmpresa.this);
    }

    public void iniciarEmpresa(View view) {
       // Empresa emp = new Empresa(nieEmp,cp,ubiEmp,pro,direccio,treb,compteBanc);
        // emp.insert(this);
        Intent iniciarEmpresa = new Intent ( this , IniciarTreballador.class);
        startActivity(iniciarEmpresa);
    }

    public void returnRegistreEmpresa(View view) {
        Intent returnRegistre = new Intent ( this , registreEmpresa.class);
        startActivity(returnRegistre);

    }
}