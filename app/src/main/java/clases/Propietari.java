package clases;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Propietari extends Persona{

    Empresa empresa;

    public Propietari(String dni, String nom, String cognom1, String cognom2, LocalDate dataNaixement, String telf, String correu, String cp, String paypal, String compte_bancari, String contrasena, Empresa empresa) {
        super(dni, nom, cognom1, cognom2, dataNaixement, telf, correu, cp, paypal, compte_bancari, contrasena);
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return super.toString() + " Propietari{" +
                "empresa=" + empresa +
                '}';
    }

    //Buscar propietari per una empresa
    public static Propietari totsEmpresa(Activity act, Empresa emp){
        Propietari propietari = null;
        return propietari;
    }

    public void insert(Activity act){

        String dni = this.getDni();
        String nom = this.getNom();
        String cognom1 = this.getCognom1();
        String cognom2 = this.getCognom2();
        LocalDate datanaix = this.getDataNaixement();
        String telefono = this.getTelf();
        String correu = this.getCorreu();
        String codipostal = this.getCp();
        String paypal = this.getPaypal();
        String comptebancari = this.getCompte_bancari();
        String contrasena = this.getContrasena();

        try {
            String url = "https://ffames.cat/tippay/Propietari-insert.php";
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
                            params.put("contrasena", contrasena);
                            return params;
                        }
                    };
            //ejecutar y pasar parametros
            RequestQueue requestQueue = Volley.newRequestQueue(act);
            requestQueue.add(postRequest);
            System.out.println(telefono);
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
        String codipostal = this.getCp();
        String paypal = this.getPaypal();
        String comptebancari = this.getCompte_bancari();
        String contrasena = this.getContrasena();

        try {
            String url = "https://ffames.cat/tippay/Propietari-update.php";
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
                            params.put("contrasena", contrasena);
                            return params;
                        }
                    };
            //ejecutar y pasar parametros
            RequestQueue requestQueue = Volley.newRequestQueue(act);
            requestQueue.add(postRequest);
            System.out.println(telefono);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Activity act){
        String dni = this.getDni();

        try {
            String url = "https://ffames.cat/tippay/Propietari-delete.php";
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
                            return params;
                        }
                    };
            //ejecutar y pasar parametros
            RequestQueue requestQueue = Volley.newRequestQueue(act);
            requestQueue.add(postRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
