package com.example.tippay;

import static clases.Empresa.todasCP;
import static clases.Empresa.totsTreballadors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Inteficies.VolleyCallBack;
import clases.Empresa;
import clases.Treballador;

public class eleccioCambrer extends AppCompatActivity {

    TextView text;
    Bundle recoger;
    Spinner sp ;
    String nie,nom ;
    Button buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccio_cambrer);

        recoger = getIntent().getExtras();
        nom = recoger.getString("nom");
        nie = recoger.getString("nie");
        System.out.println(nom);
        text = findViewById(R.id.textEleccio);
        text.setText("Restaurant " + nom);
        buscar = findViewById(R.id.btnBuscar);
        System.out.println("eleccio cambrer " + nie);
    }
        public void emplenar(View view) {
            Empresa emp = new Empresa();
            emp.totsTreballadors(eleccioCambrer.this, nie, new VolleyCallBack() {
                @Override
                public void onSuccess(ArrayList treballadors) {
                    rellenarSpinner(treballadors);
                }

                @Override
                public void onSuccess() {
                }
            });

    }
    public void iniciar(View view){
        Intent volver = new Intent(this, eleccioCambrer.class);
        startActivity(volver);
    }
    public void rellenarSpinner(ArrayList treballadors){
        ArrayList <Treballador> treb= treballadors;
        sp= findViewById(R.id.spinner);
        ArrayAdapter<Treballador> adapter = new ArrayAdapter<Treballador>(this, android.R.layout.simple_list_item_1,treb);
        sp.setAdapter(adapter);
    }

}