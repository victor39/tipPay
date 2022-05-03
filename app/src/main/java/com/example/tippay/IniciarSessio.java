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

public class IniciarSessio extends AppCompatActivity {

    EditText adni , aContra;

    Button btnIniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sessio);

        btnIniciar=findViewById(R.id.btIniciarSessio);

        adni=findViewById(R.id.textIniciarSessioINICIAR);
        aContra=findViewById(R.id.textContraseñaINICIAR);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarUsuari("https://ffames.cat/tippay/validar.php");
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
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(IniciarSessio.this, "Usuario o contraseña incorrecta ", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
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
        String [] separar = response.split("#");
        String treballador = separar[0];
        String propietari = separar [1];
        
        if (treballador.equalsIgnoreCase("1")) {
            Intent gTreballadors = new Intent(this, IniciarTreballador.class);
            startActivity(gTreballadors);
        } else if (treballador.equalsIgnoreCase("0")) {
            Intent usuari = new Intent(this, principalClient.class);
            startActivity(usuari);
        } else if (propietari.equalsIgnoreCase("1")) {
            Intent usuari = new Intent(this, IniciarTreballador.class);
            startActivity(usuari);
        }

    }
    public void returnIniciar(View view) {
        Intent returnIniciar = new Intent(this, MainActivity.class);
        startActivity(returnIniciar);
    }
}