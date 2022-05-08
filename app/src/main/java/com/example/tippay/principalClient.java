package com.example.tippay;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class principalClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_client);

    }
        public void historialClient(View view) {
            Intent historialClient = new Intent(this, HistorialPagaments.class);
            startActivity(historialClient);
        }
        public void favoritosClient(View view) {
            Intent favoritos = new Intent(this, favoritos.class);
            startActivity(favoritos);
        }
        public void registrarEmpresa(View view) {
        Intent registrarEmpresa = new Intent ( this , registreEmpresa.class);
        startActivity(registrarEmpresa);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void inici(View view) {
        Intent rInici = new Intent ( this , MainActivity.class);
        startActivity(rInici);
    }

    public void anarPagar(View view) {
        Intent pagar = new Intent ( this , pagarEmpresa.class);
        startActivity(pagar);
    }
}
