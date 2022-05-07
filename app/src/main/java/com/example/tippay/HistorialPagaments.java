package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import clases.Client;
import clases.Propina;

public class HistorialPagaments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_pagaments);

        ArrayList<Propina> propinas = new ArrayList<>();
        //if(IniciarSessio)
        //Client.propinesClient(propinas, );

    }

    protected void enrere(View view){
        Intent enrere = new Intent(this, IniciarTreballador.class);
        startActivity(enrere);
    }

    protected void emplenarTaula(ArrayList<Propina> propinas){

        TableRow.LayoutParams paramsExample = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT,1f);

        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);

        TextView tv0 = new TextView(this);
        tv0.setText("DATA");
        tv0.setTextColor(Color.BLACK);
        tv0.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv0.setLayoutParams(paramsExample);
        tbrow0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText("BENEFICIARI");
        tv1.setTextColor(Color.BLACK);
        tv1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv1.setLayoutParams(paramsExample);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText("QUANTITAT");
        tv2.setTextColor(Color.BLACK);
        tv2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv2.setLayoutParams(paramsExample);
        tbrow0.addView(tv2);

        stk.addView(tbrow0);

        for(int i = 0; i < 10; i++){ //4 cambiar por numero de rows que saque el select
            TableRow tbrow = new TableRow (this);

            TextView t1v = new TextView(this);
            t1v.setText("05/05/2022"); //data de pagament
            t1v.setTextColor(Color.BLACK);
            t1v.setGravity(Gravity.CENTER);
            t1v.setLayoutParams(paramsExample);
            tbrow.addView(t1v);

            TextView t2v = new TextView(this);
            t2v.setText("Eixida"); // empresa o persona
            t2v.setTextColor(Color.BLACK);
            t2v.setGravity(Gravity.CENTER);
            t2v.setLayoutParams(paramsExample);
            tbrow.addView(t2v);

            TextView t3v = new TextView(this);
            t3v.setText("5'5 €"); //pagament
            t3v.setTextColor(Color.BLACK);
            t3v.setGravity(Gravity.CENTER);
            t3v.setLayoutParams(paramsExample);
            tbrow.addView(t3v);

            stk.addView(tbrow);
        }

    }
}