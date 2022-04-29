package clases;
import android.app.Activity;
import android.app.Application;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Treballador extends Persona{

    public Treballador(String dni, String nom, String cognom1, String cognom2, LocalDate dataNaixement, String telf, String correu, int cp, String paypal, String compte_bancari) {
        super(dni, nom, cognom1, cognom2, dataNaixement, telf, correu, cp, paypal, compte_bancari);
    }

    public static ArrayList<Treballador> tots(Activity act){
        ArrayList<Treballador> treballadors = new ArrayList<Treballador>();

        try {
            String url = "https://ffames.cat/tippay/treballador-tots.php";
            StringRequest postRequest = new
                    //crear constructor
                    StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //devuelve el resultado de la consulta
                                    //si hay un error de sintaxis en la consulta del php lo devolvera aqui
                                    String resultado = response;
                                    //while llenando

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    //si hay un error lo muestra
                                    error.printStackTrace();

                                }
                            }
                    ) {
                        //generar clave-valor
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<>();
                            // the POST parameters:
                            return params;
                        }
                    };
            //ejecutar y pasar parametros
            Volley.newRequestQueue(act).add(postRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //una linea por trabajador
        //while hasta que se acaben las
        return treballadors;
    }

    public void insert(Activity act){

        String dni = this.getDni();
        String nom = this.getNom();
        String cognom1 = this.getCognom1();
        String cognom2 = this.getCognom2();
        LocalDate datanaix = this.getDataNaixement();
        String telefono = this.getTelf();
        String correu = this.getCorreu();
        int codipostal = this.getCp();
        String paypal = this.getPaypal();
        String comptebancari = this.getCompte_bancari();
        try {
            String url = "https://ffames.cat/tippay/Treballador-insert.php";
            StringRequest postRequest = new
                    //crear constructor
                    StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //devuelve el resultado de la consulta
                                    //si hay un error de sintaxis en la consulta del php lo devolvera aqui

                                    String resultado = response;


                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    //si hay un error lo muestra
                                    error.printStackTrace();
                                    System.out.println("manel");
                                }
                            }
                    ) {

                        //generar clave-valor
                        @Override
                        protected Map<String, String> getParams() {

                            Map<String, String> params = new HashMap<>();
                            // the POST parameters:
                            params.put("dni", dni);
                            params.put("nom", nom);
                            params.put("cognom1", cognom1);
                            params.put("cognom2", cognom2);
                            params.put("datanaix", datanaix.toString());
                            params.put("telefono", telefono);
                            params.put("correu", correu);
                            params.put("codipostal", codipostal+"");
                            params.put("paypal", paypal);
                            params.put("comptebancari", comptebancari);
                            return params;
                        }
                    };
            //ejecutar y pasar parametros

            Volley.newRequestQueue(act.getApplicationContext()).add(postRequest);
            System.out.println("HOLA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Activity act){
        String dni = this.getDni();
        String nom = this.getNom();
        String cognom1 = this.getCognom1();
        String cognom2 = this.getCognom2();
        LocalDate datanaix = this.getDataNaixement();
        String telefono = this.getTelf();
        String correu = this.getCorreu();
        int codipostal = this.getCp();
        String paypal = this.getPaypal();
        String comptebancari = this.getCompte_bancari();
        try {
            String url = "https://ffames.cat/tippay/treballador-insert.php";
            StringRequest postRequest = new
                    //crear constructor
                    StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //devuelve el resultado de la consulta
                                    //si hay un error de sintaxis en la consulta del php lo devolvera aqui
                                    String resultado = response;

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    //si hay un error lo muestra
                                    error.printStackTrace();

                                }
                            }
                    ) {
                        //generar clave-valor
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<>();
                            // the POST parameters:
                            params.put("dni", dni);
                            params.put("nom", nom);
                            params.put("cognom1", cognom1);
                            params.put("cognom2", cognom2);
                            params.put("datanaix", datanaix.toString());
                            params.put("telefono", telefono);
                            params.put("correu", correu);
                            params.put("codipostal", codipostal+"");
                            params.put("paypal", paypal);
                            params.put("comptebancari", comptebancari);
                            return params;
                        }
                    };
            //ejecutar y pasar parametros
            Volley.newRequestQueue(act.getApplicationContext()).add(postRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Activity act){

    }

}