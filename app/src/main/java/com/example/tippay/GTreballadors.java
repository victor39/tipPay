package com.example.tippay;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import Inteficies.VolleyCallBack;
import clases.Empresa;
import clases.Propina;
import clases.Treballador;

public class GTreballadors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gtreballadors);

        System.out.println("EMPRESA " + IniciarSessio.prp.getEmpresa());

        Empresa.totsTreballadors(this, IniciarSessio.prp.getEmpresa(), new VolleyCallBack() {
            @Override
            public void onSuccess(ArrayList treballadors) {
                emplenarTaula(treballadors);
            }
            @Override
            public void onSuccess(){

            }
        });

    }

    protected void emplenarTaula(ArrayList<Treballador> treballadors){

        TableRow.LayoutParams paramsExample = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT,1f);

        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);

        TextView tv0 = new TextView(this);
        tv0.setText("DNI");
        tv0.setTextColor(Color.BLACK);
        tv0.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv0.setLayoutParams(paramsExample);
        tbrow0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText("NOM");
        tv1.setTextColor(Color.BLACK);
        tv1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv1.setLayoutParams(paramsExample);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText("");
        tv2.setTextColor(Color.BLACK);
        tv2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv2.setLayoutParams(paramsExample);
        tbrow0.addView(tv2);

        stk.addView(tbrow0);

        for(int i = 0; i < treballadors.size(); i++){
            TableRow tbrow = new TableRow (this);

            TextView t1v = new TextView(this);
            t1v.setText(treballadors.get(i).getDni()); //data de pagament
            t1v.setTextColor(Color.BLACK);
            t1v.setGravity(Gravity.CENTER);
            t1v.setLayoutParams(paramsExample);
            tbrow.addView(t1v);

            TextView t2v = new TextView(this);
            t2v.setText(treballadors.get(i).getNom()); // treballador o persona
            t2v.setTextColor(Color.BLACK);
            t2v.setGravity(Gravity.CENTER);
            t2v.setLayoutParams(paramsExample);
            tbrow.addView(t2v);

            Button bt0 = new Button(this);
            bt0.setText("Acomiadar");
            bt0.setLayoutParams(paramsExample);
            bt0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    acomiadar(t1v.getText().toString());
                }
            });

            tbrow.addView(bt0);

            stk.addView(tbrow);
        }

    }

    public void acomiadar(String dni){

        System.out.println(dni);

        Treballador.updateVellTreballador(this, dni);
        Empresa.acomiadarTreballador(this, dni, IniciarSessio.prp.getEmpresa(), new VolleyCallBack() {
            @Override
            public void onSuccess(ArrayList propinas) {

            }

            @Override
            public void onSuccess() {
                finish();
                startActivity(getIntent());
            }
        });

    }

    public void afegirTreballador(View view){

        EditText txt = findViewById(R.id.dniTreb);

        if(txt.getText().toString() != ""){

            Treballador.updateNouTreballador(this, txt.getText().toString());
            Empresa.contractarTreballador(this, txt.getText().toString(), IniciarSessio.prp.getEmpresa(), new VolleyCallBack() {
                @Override
                public void onSuccess(ArrayList propinas) {

                }

                @Override
                public void onSuccess() {
                    finish();
                    startActivity(getIntent());
                }
            });
        }

    }
}