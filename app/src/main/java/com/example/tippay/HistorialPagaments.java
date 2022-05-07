package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;

public class HistorialPagaments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_pagaments);

        emplenarTaula();

    }

    protected void emplenarTaula(){

        TableLayout stk = (TableLayout) findViewById(R.id.table_main);


    }
}