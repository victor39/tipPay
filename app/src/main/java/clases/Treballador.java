package clases;
import android.app.Activity;
import android.app.Application;
import android.widget.TextView;

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

import Inteficies.VolleyCallBack;

public class Treballador extends Persona{

    public Treballador(String dni, String nom, String cognom1, String cognom2, String dataNaixement, String telf, String correu, String cp, String paypal, String contrasena) {
        super(dni, nom, cognom1, cognom2, dataNaixement, telf, correu, cp, paypal, contrasena);
    }

    public Treballador() {
    }

    static public void propinesTreballador(Activity act, String dni, final VolleyCallBack callBack){

        ArrayList<Propina> propinas = new ArrayList<>();

        try {
            String url = "https://ffames.cat/tippay/Client-buscarTotsPropines.php";
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

    public void insert(Activity act){

        String dni = this.getDni();
        String nom = this.getNom();
        String cognom1 = this.getCognom1();
        String cognom2 = this.getCognom2();
        String datanaix = this.getDataNaixement();
        String telefono = this.getTelf();
        String correu = this.getCorreu();
        String codipostal = this.getCp();
        String paypal = this.getPaypal();
        String contrasena = this.getContrasena();

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
                            params.put("contrasena", contrasena);
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

    static void updateNouTreballador(Activity act, String dni){;

        try {
            String url = "https://ffames.cat/tippay/Treballador-updateNou.php";
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

    static void updateVellTreballador(Activity act, String dni){

        try {
            String url = "https://ffames.cat/tippay/Treballador-updateVell.php";
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

    public void delete(Activity act){
        String dni = this.getDni();

        try {
            String url = "https://ffames.cat/tippay/Treballador-delete.php";
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
