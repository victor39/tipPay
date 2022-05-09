package com.example.tippay;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class iniciarEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Inici Empresa");
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

    public void volver(View view) {
        Intent volver = new Intent ( this , IniciarSessio.class);
        startActivity(volver);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void inici(View view) {
        Intent volver = new Intent ( this , MainActivity.class);
        startActivity(volver);
    }
}