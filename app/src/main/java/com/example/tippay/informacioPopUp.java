package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;

public class informacioPopUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacio_pop_up);
        this.setTitle("Informacio");

        //accedir a las medidas finestra
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);
        //fer variables per seleccionar els qe volem
        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;
        // assignem ancho , casi totalitat pantalla i alto , nomes el 50%
        getWindow().setLayout((int)(ancho * 0.85), (int)(alto * 0.7));

    }

}