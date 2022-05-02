package com.example.tippay;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class registreUsuari extends AppCompatActivity {
    String adni, aNom, aCognom,aCognom2,aNaix,aTelefon,aCorreu,aCP ,aCompteBancari ;
    EditText nom,correu ,contraseña,contraseña2;
    Button btSeguent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras =getIntent().getExtras();
         adni = extras.getString("dni");
         aNom = extras.getString("nom");
         aCognom = extras.getString("cognom");
         aCognom2 = extras.getString("cognom2");
         aNaix = extras.getString("dataNaix");
         aTelefon = extras.getString("telefon");
         aCorreu = extras.getString("correu");
         aCP = extras.getString("Cp");
         aCompteBancari = extras.getString("CompteBancari");


         nom = findViewById(R.id.registreUsuariNom);
         correu = findViewById(R.id.registreUsuariEmail);
         contraseña = findViewById(R.id.registreUsuariContra);
         contraseña2 = findViewById(R.id.registreUsuariContra2);
         /*if (contraseña.equals(contraseña2)){
             // si meto el onClick , no funciona :S
         }*/
        setContentView(R.layout.activity_registre_usuari);
        btSeguent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarUsuari("https://ffames.cat/tippay/Treballador-insert.php");
            }
        });
    }

    public void validarUsuari(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.isEmpty()) {

                } else {
                    Toast.makeText(registreUsuari.this, "Usuario o contraseña incorrecta ", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //llençar l'error per veure que falla
                Toast.makeText(registreUsuari.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                    parametros.put("Dni",adni);
                    parametros.put("Nom",aNom);
                    parametros.put("Cognom",aCognom);
                    parametros.put("Cognom2",aCognom2);
                    parametros.put("dataNaix",aNaix);
                    parametros.put("Telefon",aTelefon);
                    parametros.put("correu",aCorreu);
                    parametros.put("CP",aCP);
                    parametros.put("CompteBancari",aCompteBancari);

                return parametros;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void registrarUsuari(View view) {
        Intent registrarUsuari = new Intent(this, registrePersona.class);
        startActivity(registrarUsuari);
    }

    public void sessioIniciada(View view) {
        Intent sessioIniciada = new Intent(this, IniciarSessio.class);
        startActivity(sessioIniciada);
    }

    public void returnMain(View view) {
        Intent returnMain = new Intent(this, MainActivity.class);
        startActivity(returnMain);

    }
}