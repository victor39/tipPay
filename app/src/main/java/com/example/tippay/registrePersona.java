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

public class registrePersona extends AppCompatActivity {
    EditText adni,aContra , aNom , aCognom , aAdreca , aCP, aPoblacio , aTelefon ,aProvincia;
    Button btSeguent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre_persona);

        btSeguent=findViewById(R.id.btSeguent);

        adni=findViewById(R.id.textIniciarSessioINICIAR);
        aContra=findViewById(R.id.registreContraseña);
        aNom=findViewById(R.id.registreNom);
        aCognom=findViewById(R.id.registreCognom);
        aAdreca=findViewById(R.id.registreAdreca);
        aCP=findViewById(R.id.registreCP);
        aPoblacio=findViewById(R.id.registrePoblacio);
        aTelefon=findViewById(R.id.registreTelefon);
        aProvincia=findViewById(R.id.registreProvincia);


        btSeguent.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    validarUsuari("https://ffames.cat/tippay/Treballador-select.php");
                }
            });

        }

        public void validarUsuari(String URL){
            StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                //mirarem si l'dni i contraseña son correctas
                public void onResponse(String response) {
                    if(response.isEmpty()){
                        System.out.println("esta aqui?");
                    }else{
                        Toast.makeText(registrePersona.this, "Usuario o contraseña incorrecta ", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }

                }
            },new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error){
                    //llençar l'error per veure que falla
                    Toast.makeText(registrePersona.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Nullable
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parametros = new HashMap<String,String>();
                   /* parametros.put("Dni",adni.getText().toString());
                    parametros.put("Contraseña",aContra.getText().toString());
                    parametros.put("Nom",aNom.getText().toString());
                    parametros.put("Cognom",aCognom.getText().toString());
                    parametros.put("Adreca",aAdreca.getText().toString());
                    parametros.put("CP",aCP.getText().toString());
                    parametros.put("Poblacio",aPoblacio.getText().toString());
                    parametros.put("Telefon",aTelefon.getText().toString());
                    parametros.put("Provincia",aProvincia.getText().toString());
 */
                    return parametros;


                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
    }
    public void clickRegistreUsuari(View view) {
        Intent registreUsuari = new Intent ( this , registreUsuari.class);
        startActivity(registreUsuari);
    }
}