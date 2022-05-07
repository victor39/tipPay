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

import java.util.HashMap;
import java.util.Map;

import clases.Client;
import clases.Propietari;
import clases.Treballador;

public class IniciarSessio extends AppCompatActivity {

    static Client clt = new Client();
    static Treballador trb = new Treballador();
    static Propietari prp = new Propietari();
    static char var = 'a';

    String nomUsuari ,dni, nom, cognom1, cognom2, datanaix, telefon, correu, cp, paypal, contrasena ,treballador,propietari;
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
                validarUsuari("https://ffames.cat/tippay/Usuari-validar.php");
            }
        });

    }
    public void validarUsuari(String URL){
        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            //mirarem si l'dni i contraseña son correctas
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    iniciar(response);
                    //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(IniciarSessio.this, "Usuario o contraseña incorrecta ", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error){
                //llençar l'error per veure que falla
                Toast.makeText(IniciarSessio.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        }){
            @Nullable
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String,String>();
                parametros.put("Dni",adni.getText().toString());
                parametros.put("Contrasena",aContra.getText().toString());

                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void iniciar (String response) {
        System.out.println(response);
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
            prp = new Propietari(dni, nom, cognom1, cognom2, datanaix, telefon, correu, cp, paypal, contrasena);
            var = 'P';
            Toast.makeText(IniciarSessio.this, "Has iniciat sessió com propietari", Toast.LENGTH_SHORT).show();
            Intent usuari = new Intent(this, iniciarEmpresa.class);
            startActivity(usuari);
        } else if (treballador.equalsIgnoreCase("1")) {
            trb = new Treballador(dni, nom, cognom1, cognom2, datanaix, telefon, correu, cp, paypal, contrasena);
            var = 'T';
            Toast.makeText(IniciarSessio.this, "Has iniciat sessió com treballador", Toast.LENGTH_SHORT).show();
            Intent gTreballadors = new Intent(this, IniciarTreballador.class);
            startActivity(gTreballadors);

        } else if (treballador.equalsIgnoreCase("0")) {
            clt = new Client(dni, nom, cognom1, cognom2, datanaix, telefon, correu, cp, paypal, contrasena, null,nomUsuari);
            var = 'c';
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