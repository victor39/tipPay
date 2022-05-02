package com.example.tippay;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import java.util.HashMap;
import java.util.Map;

public class registrarEmpresa extends AppCompatActivity {
    String nomEmpresa ,nieEmp,dniEmp,ubiEmp,nomProp,tipus;
    TextView nomText;
    EditText email,nomEdit,contrasena,contrasena2;
    Button btregistrarEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empresa);
        Bundle nom =getIntent().getExtras();

        btregistrarEmp = findViewById(R.id.btRegistrarEmp);
        email = findViewById(R.id.registrarEmailEmpr);
        nomEdit = findViewById(R.id.registrarNomEmpre);
        contrasena = findViewById(R.id.registrarContraEmpr);
        contrasena2 = findViewById(R.id.registrarContraEmp2);

        nieEmp = nom.getString("nie");
        dniEmp = nom.getString("dni");
        ubiEmp = nom.getString("ubi");
        nomProp = nom.getString("nomProp");
        tipus = nom.getString("tipus");

         nomEmpresa = nom.getString("nomEmp");
         nomText = findViewById(R.id.textNomEmpresa);
         nomText.setText(nomEmpresa);

        btregistrarEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarUsuari("https://ffames.cat/tippay/Empresa-insert.php");
            }
        });
    }

    public void validarUsuari(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.isEmpty()) {

                } else {
                    Toast.makeText(registrarEmpresa.this, "Usuario o contraseña incorrecta ", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //llençar l'error per veure que falla
                Toast.makeText(registrarEmpresa.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("nie",nieEmp);
                parametros.put("dni",dniEmp);
                parametros.put("ubi",ubiEmp);
                parametros.put("nomProp",nomProp);
                parametros.put("tipus",tipus);
                parametros.put("nomEmp",nomEmpresa);
                // los de este activity:
                parametros.put("contrasena",contrasena.getText().toString());
                parametros.put("contrasena2",contrasena2.getText().toString());
                parametros.put("email",email.getText().toString());
                parametros.put("nom",nomEdit.getText().toString());

                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void iniciarEmpresa(View view) {
        Intent iniciarEmpresa = new Intent ( this , IniciarTreballador.class);
        startActivity(iniciarEmpresa);
    }

    public void returnRegistreEmpresa(View view) {
        Intent returnRegistre = new Intent ( this , registreEmpresa.class);
        startActivity(returnRegistre);

    }
}