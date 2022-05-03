package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class iniciarEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_empresa);
    }
    public void gestionarTreballadors(View view) {
        Intent gTreballadors = new Intent ( this , GTreballadors.class);
        startActivity(gTreballadors);
    }
    public void gestionarTips(View view) {
        Intent gTips = new Intent ( this , Gtips.class);
        startActivity(gTips);
    }


}