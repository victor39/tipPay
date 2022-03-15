package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    Connection connect;
    String ConnnectionResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void intento(View view) {
        try {
            Connexio con = new Connexio();
            connect = con.connexioClass();

            if (connect != null) {
                String query = "select * from persona";
            }
        }
        catch(Exception ex){

        }
    }
}