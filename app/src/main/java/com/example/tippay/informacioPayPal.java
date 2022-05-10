package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;

public class informacioPayPal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacio_pay_pal);

        this.setTitle("Enregistrament Pay Pal");

        //accedir a las medidas finestra
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);
        //fer variables per seleccionar els qe volem
        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;
        // assignem ancho , casi totalitat pantalla i alto , nomes el 50%
        getWindow().setLayout((int)(ancho * 0.70), (int)(alto * 0.5));

    }
}