package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class eleccioCambrer extends AppCompatActivity {

    TextView text;
    Bundle recoger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccio_cambrer);

        recoger=getIntent().getExtras();
        String nom = recoger.getString("nom");
        text = findViewById(R.id.textEleccio);
        text.setText("Restaurant " + nom);


    }
    public void iniciar(View view){
        Intent volver = new Intent(this, eleccioCambrer.class);
        startActivity(volver);
    }
}