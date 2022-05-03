package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
}
