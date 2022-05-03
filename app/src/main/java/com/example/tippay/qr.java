package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class qr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
    }
    public void paypal(View view) {
        Intent volver = new Intent(this,PayPal.class);
        startActivity(volver);
    }
    public void volverQR(View view) {
        Intent volver = new Intent(this,IniciarTreballador.class);
        startActivity(volver);
    }
}