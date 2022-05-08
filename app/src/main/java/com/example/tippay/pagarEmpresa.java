package com.example.tippay;

import static clases.Empresa.todasCP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Inteficies.VolleyCallBack;
import clases.Empresa;

public class pagarEmpresa extends AppCompatActivity  {
    String resultat;
    Spinner spEmpresas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar_empresa);
        Button btn = findViewById(R.id.btBuscarCP);
        spEmpresas = findViewById(R.id.spEmpresas);


    }


    public void rellenarSpinner(ArrayList empresas){
        ArrayList <Empresa> empre= empresas;
        Spinner spEmpresas = findViewById(R.id.spEmpresas);
        ArrayList <String> noms = new ArrayList<>();
        for (int i = 0; i < empre.size() ; i++){
            noms.add(empre.get(i).getNom());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,noms);
        spEmpresas.setAdapter(adapter);
    }
    public void buscar (View view){
        EditText cp = findViewById(R.id.textCP);
        todasCP(pagarEmpresa.this,cp.getText().toString(), new VolleyCallBack() {
            @Override
            public void onSuccess(ArrayList empresas) {
                rellenarSpinner(empresas);
            }
        });
    }
    public void eleccioCambrer(View view) {
        Bundle eleccio = null;
        resultat = spEmpresas.getSelectedItem().toString();
        eleccio.putString("eleccio", resultat);
        Intent inici = new Intent(this, eleccioCambrer.class);
        inici.putExtras(eleccio);
        startActivity(inici);
    }
    public void volver(View view) {
        Intent volver = new Intent(this, principalClient.class);
        startActivity(volver);
    }

}