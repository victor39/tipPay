package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Gtips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gtips);

    }

    public void atras(View view) {
        Intent returnClient = new Intent(this, iniciarEmpresa.class);
        startActivity(returnClient);
    }
}