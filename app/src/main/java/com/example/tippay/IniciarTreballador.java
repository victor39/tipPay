package com.example.tippay;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class IniciarTreballador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_treballador);
        this.setTitle("Iniciar Treballador");
        
    }

    public void historialTreballador(View view) {
        Intent historialTreballador = new Intent(this, HistorialPagaments.class);
        startActivity(historialTreballador);
    }
    public void favoritos(View view) {
        Intent favoritos = new Intent(this, favoritos.class);
        startActivity(favoritos);
    }
    public void misTips(View view) {
        Intent favoritos = new Intent(this, misTips.class);
        startActivity(favoritos);
    }
    public void QR(View view) {
        Intent qr = new Intent(this, favoritos.class);
        startActivity(qr);
    }
    public void pagar(View view) {
        Intent pagar = new Intent(this, favoritos.class);
        startActivity(pagar);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void atras(View view) {
        Intent atras = new Intent(this, MainActivity.class);
        startActivity(atras);
    }
}