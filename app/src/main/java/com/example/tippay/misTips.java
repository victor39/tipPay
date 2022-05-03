package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class misTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_tips);

    }
    public void returnTips(View view) {
        Intent returnTips = new Intent(this, IniciarTreballador.class);
        startActivity(returnTips);
    }
}