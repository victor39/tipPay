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

    public static Client clt = new Client();
    public static Treballador trb = new Treballador();
    public static Propietari prp = new Propietari();
    public static char var = 'a';
    String dniRecollir , contraRecollir;
    EditText adni , aContra;
    Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Iniciar Sessio");
        setContentView(R.layout.activity_iniciar_sessio);

        btnIniciar = findViewById(R.id.btIniciarSessio);
        adni = findViewById(R.id.textIniciarSessioINICIAR);
        aContra = findViewById(R.id.textContraseñaINICIAR);

    }

    public void iniciar(View view){
        dniRecollir = adni.getText().toString();
        contraRecollir = aContra.getText().toString();
        System.out.println(dniRecollir);
        System.out.println(contraRecollir);

        Persona.validarUsuari(IniciarSessio.this, dniRecollir, contraRecollir);
        if (var==('P')) {
            prp.buscarEmpresa(this, prp.getDni(), new VolleyCallBack() {
                @Override
                public void onSuccess(ArrayList empreses) {
                    ArrayList<Empresa> emps = empreses;
                    prp.setEmpresa(emps.get(0).getNIE());
                }
                @Override
                public void onSuccess() {
                }
            });
            Toast.makeText(IniciarSessio.this, "Has iniciat sessió com propietari", Toast.LENGTH_SHORT).show();
            Intent usuari = new Intent(this, iniciarEmpresa.class);
            startActivity(usuari);
        } else if (var ==('T')) {

            Toast.makeText(IniciarSessio.this, "Has iniciat sessió com treballador", Toast.LENGTH_SHORT).show();
            Intent gTreballadors = new Intent(this, IniciarTreballador.class);
            startActivity(gTreballadors);

        } else if (var == ('C')) {
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