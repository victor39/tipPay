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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Inteficies.VolleyCallBack;
import clases.Client;
import clases.Empresa;
import clases.Persona;
import clases.Propietari;
import clases.Treballador;

public class IniciarSessio extends AppCompatActivity {

    static Client clt = new Client();
    static Treballador trb = new Treballador();
    static Propietari prp = new Propietari();
    static char var = 'a';

    String nomUsuari ,dni, nom, cognom1, cognom2, datanaix, telefon, correu, cp, paypal, contrasena ,treballador,propietari,nie;
    EditText adni , aContra;
    Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Iniciar Sessio");
        setContentView(R.layout.activity_iniciar_sessio);

        btnIniciar=findViewById(R.id.btIniciarSessio);

        adni=findViewById(R.id.textIniciarSessioINICIAR);
        aContra=findViewById(R.id.textContraseñaINICIAR);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Persona.validarUsuari(IniciarSessio.this, );
            }
        });

    }

    public void iniciar (String response) {
        String[] separar = response.split("#");
        treballador = separar[0];
        propietari = separar[1];
        dni=separar[2];
        nom = separar[3];
        cognom1=separar[4];
        cognom2= separar[5];
        datanaix = separar[6];
        telefon = separar[7];
        correu = separar [8];
        cp = separar[9];
        paypal = separar[10];
        contrasena= separar[11];
        nomUsuari = separar[12];

        if (propietari.equalsIgnoreCase("1")) {

            prp = new Propietari(dni, nom, cognom1, cognom2, datanaix, telefon, correu, cp, paypal, contrasena, nomUsuari);

            prp.buscarEmpresa(this, nie, new VolleyCallBack() {
                @Override
                public void onSuccess(ArrayList empreses) {
                    ArrayList<Empresa> emps = empreses;

                    prp.setEmpresa(emps.get(0).getNIE());
                }
                @Override
                public void onSuccess() {

                }
            });

            var = 'P';
            Toast.makeText(IniciarSessio.this, "Has iniciat sessió com propietari", Toast.LENGTH_SHORT).show();
            Intent usuari = new Intent(this, iniciarEmpresa.class);
            startActivity(usuari);
        } else if (treballador.equalsIgnoreCase("1")) {
            trb = new Treballador(dni, nom, cognom1, cognom2, datanaix, telefon, correu, cp, paypal, contrasena, nomUsuari);
            var = 'T';
            Toast.makeText(IniciarSessio.this, "Has iniciat sessió com treballador", Toast.LENGTH_SHORT).show();
            Intent gTreballadors = new Intent(this, IniciarTreballador.class);
            startActivity(gTreballadors);

        } else if (treballador.equalsIgnoreCase("0")) {
            clt = new Client(dni, nom, cognom1, cognom2, datanaix, telefon, correu, cp, paypal, contrasena, null,nomUsuari);
            var = 'C';
            Toast.makeText(IniciarSessio.this, "Has iniciat sessió com Client", Toast.LENGTH_SHORT).show();
            Intent usuari = new Intent(this, principalClient.class);
            startActivity(usuari);

        }


    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void returnIniciar(View view) {
        Intent returnIniciar = new Intent(this, MainActivity.class);
        startActivity(returnIniciar);
    }
}