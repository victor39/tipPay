package com.example.tippay;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registrePersona extends AppCompatActivity {
    EditText adni, aNom, aCognom,aCognom2,aNaix,aTelefon,aCP ,aPayPal ;
    Button btSeguent,informacio;
    Bundle valores = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Registre");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre_persona);

        btSeguent = findViewById(R.id.btSeguentRegistre);
        adni = findViewById(R.id.registreDNI);
        aNom = findViewById(R.id.registreNom);
        aCognom = findViewById(R.id.registreCognom);
        aCognom2 = findViewById(R.id.registreCognom2);
        aNaix = findViewById(R.id.registreDataNaix);
        aTelefon = findViewById(R.id.registreTelef);
        //aCorreu = findViewById(R.id.registreCorreu);
        aCP = findViewById(R.id.registreCP);
        aPayPal = findViewById(R.id.registrePAYPAL);
    }
    public void seguent(View view) {
        if(validarDNI(adni.getText().toString())== true){
            System.out.println("no va? ");
            Intent seguent = new Intent(this, registraUsuari.class);
            valores.putString("dni", String.valueOf(adni.getText()));
            valores.putString("nom", String.valueOf(aNom.getText()));
            valores.putString("cognom", String.valueOf(aCognom.getText()));
            valores.putString("cognom2", String.valueOf(aCognom2.getText()));
            valores.putString("dataNaix", String.valueOf(aNaix.getText()));
            valores.putString("telefon", String.valueOf(aTelefon.getText()));
            //valores.putString("correu", String.valueOf(aCorreu.getText()));
            valores.putString("Cp", String.valueOf(aCP.getText()));
            valores.putString("PayPal", String.valueOf(aPayPal.getText()));
            seguent.putExtras(valores);
            startActivity(seguent);

        }else{
            Toast toast1 = Toast.makeText(getApplicationContext(),"DNI ERROR !", Toast.LENGTH_SHORT);toast1.show();
            adni.setText("");
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void returnPersona(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);

    }
    public void info(View view) {
        Intent main = new Intent(this, informacioPopUp.class);
        startActivity(main);
    }
    static boolean validarDNI(String dni) {
        int contadorNumero;
        int contadorTabla;
        char[] letraDni = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
                'H', 'L', 'C', 'K', 'E' };
        char[] numero = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        boolean letra = false;
        contadorNumero = 0;
        if (dni.length() == 9) {
            for (int i = 0; i < 8; i++) {

                for (int j = 0; j < numero.length; j++) {
                    if (dni.charAt(i) == numero[j]) {
                        contadorNumero++;
                    }
                }
            }
        }
        contadorTabla = 0;
        while (letra == false && contadorNumero == 8) {
            if (dni.charAt(8) == letraDni[contadorTabla]) {
                letra = true;
            } else {
                contadorTabla++;
            }

        }
        return letra;
    }
}



