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

import Inteficies.VolleyCallBack;

public class Propietari extends Persona{

    public Propietari(String dni, String nom, String cognom1, String cognom2, String dataNaixement, String telf, String correu, String cp, String paypal, String contrasena) {
        super(dni, nom, cognom1, cognom2, dataNaixement, telf, correu, cp, paypal, contrasena);

    }

    public Propietari() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + " Propietari{" + '}';
    }

    //Buscar propietari per una empresa
    public static Propietari totsEmpresa(Activity act ){
        Propietari propietari = null;
        return propietari;
    }

    static public void propinesPropietari(Activity act, String dni, final VolleyCallBack callBack){

        ArrayList<Propina> propinas = new ArrayList<>();

        try {
            String url = "https://ffames.cat/tippay/Empresa-buscarTotsPropines.php";
            StringRequest postRequest = new
                    //crear constructor
                    StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //devuelve el resultado de la consulta
                                    //si hay un error de sintaxis en la consulta del php lo devolvera aqui
                                    String resultado = response;

                                    String[] res = resultado.split("=");

                                    for (int i = 0; i < res.length; i++){

                                        String[] valores = res[i].split("#");

                                        Propina p = new Propina(valores[0], valores[1], valores[2], Double.parseDouble(valores[3]), valores[4]);
                                        propinas.add(p);
                                    }

                                    callBack.onSuccess(propinas);
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
                                    System.out.println(response);
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
                            System.out.println(dni+nom+cognom1+cognom2+datanaix+telefono+correu+codipostal+paypal+contrasena);
                            return params;
                        }
                    };
            //ejecutar y pasar parametros
            RequestQueue requestQueue = Volley.newRequestQueue(act);
            requestQueue.add(postRequest);
            System.out.println(postRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateNouPropietari(Activity act){

        String dni = this.getDni();

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
            System.out.println("entra");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void buscarPropietari(Activity act){

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
            String url = "https://ffames.cat/tippay/Propietari-buscar.php";
            StringRequest postRequest = new
                    //crear constructor
                    StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //devuelve el resultado de la consulta
                                    //si hay un error de sintaxis en la consulta del php lo devolvera aqui
                                    String resultado = response;
                                    String total [] = resultado.split("#");
                                    for(int i = 0; i <= total.length; i = i + i)
                                    {

                                    }

                                    System.out.println(total[0] + " " + total[1]);
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    //si hay un error lo muestra
                                    error.printStackTrace();
                                }
                            }
                    ){

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

}
