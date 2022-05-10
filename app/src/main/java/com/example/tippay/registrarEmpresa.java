package com.example.tippay;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import clases.Empresa;
import clases.Propietari;

public class registrarEmpresa extends AppCompatActivity {
    String nomEmp ,nieEmp,dniEmp,nomProp,cpEmp,direccio,paypal;
    String ubi;
    EditText email,contrasena,contrasena2,nomP;
    Button btRetornaEmpresa;
    TextView mostrar;

    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empresa);
        Bundle nom = getIntent().getExtras();

        mostrar = findViewById(R.id.textNomEmpresa);

        // valores de este activity
        btRetornaEmpresa = findViewById(R.id.btnReturnregistreEmpre);
        email = findViewById(R.id.registrarEmailEmpr);
        nomP = findViewById(R.id.validarNomProp);
        contrasena = findViewById(R.id.registrarContraEmpr);
        contrasena2 = findViewById(R.id.registrarContraEmp2);

        //valores devuelva registre
        nieEmp = nom.getString("nie");
        nomEmp = nom.getString("nomEmp");
        cpEmp = nom.getString("cpEmp");
        ubi = nom.getString("ubi");
        dniEmp = nom.getString("dni");
        nomProp = nom.getString("nomProp");
        direccio = nom.getString("direccio");
        paypal = nom.getString("paypal");

        mostrar.setText("RESTAURANT : " + nomEmp);
    }

    public void iniciarEmpresa(View view) {

        if (contrasena.getText().toString().equals(contrasena2.getText().toString())) {
            Propietari prp = new Propietari(IniciarSessio.clt.getDni(), IniciarSessio.clt.getNom(), IniciarSessio.clt.getCognom1(), IniciarSessio.clt.getCognom2(), IniciarSessio.clt.getDataNaixement(), IniciarSessio.clt.getTelf(), IniciarSessio.clt.getCorreu(),
                    IniciarSessio.clt.getCp(), IniciarSessio.clt.getPaypal(), IniciarSessio.clt.getContrasena(), IniciarSessio.clt.getNomUsuari());
            IniciarSessio.var = 'P';
            prp.updateNouPropietari(registrarEmpresa.this);
            System.out.println("nom : " + nomEmp);
            Empresa emp = new Empresa(nieEmp, nomEmp, cpEmp, ubi, prp, direccio, null, paypal);
            emp.insert(registrarEmpresa.this);
            Intent iniciarEmpresa = new Intent(this, IniciarTreballador.class);
            startActivity(iniciarEmpresa);
        } else
            Toast.makeText(registrarEmpresa.this, "Tornar a omplir la contraseña", Toast.LENGTH_SHORT).show();
            contrasena.setText("");
            contrasena2.setText("");
    }

    public void returnRegistreEmpresa(View view) {
        Intent returnRegistre = new Intent ( this , registreEmpresa.class);
        startActivity(returnRegistre);


    }
}