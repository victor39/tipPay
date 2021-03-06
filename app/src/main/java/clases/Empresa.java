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

public class Empresa {

    private String NIE;
    private String nom;
    private String cp;
    private String cordenades;
    private Propietari propietari;
    private String direccio;
    private ArrayList<Treballador> treballadors;
    private String paypal;

    public Empresa(String NIE, String nom, String cp, String cordenades, Propietari propietari, String direccio, ArrayList<Treballador> treballadors, String paypal) {

        this.NIE = NIE;
        this.nom = nom;
        this.cp = cp;
        this.cordenades = cordenades;
        this.propietari = propietari;
        this.direccio = direccio;
        this.treballadors = treballadors;
        this.paypal = paypal;
    }

    public Empresa() {
    }

    public String getNIE() {
        return NIE;
    }

    public void setNIE(String NIE) {
        this.NIE = NIE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCordenades() {
        return cordenades;
    }

    public void setCordenades(String cordenades) {
        this.cordenades = cordenades;
    }

    public Propietari getPropietari() {
        return propietari;
    }

    public void setPropietari(Propietari propietari) {
        this.propietari = propietari;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getPaypal() {
        return paypal;
    }

    public void setPaypal(String paypal) {
        this.paypal = paypal;
    }


    @Override
    public String toString() {
        return nom + "/" + NIE;
    }

    public void insert(Activity act ){

        String NIE = this.NIE;
        String nom = this.nom;
        String cp = this.cp;
        String cordenades = this.cordenades;
        String propietari = this.propietari.getDni();
        String direccio = this.direccio;
        ArrayList<Treballador> treballadors;
        String paypal = this.paypal;

        try {
            String url = "https://ffames.cat/tippay/Empresa-insert.php";
            StringRequest postRequest = new
                    //crear constructor
                    StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //devuelve el resultado de la consulta
                                    //si hay un error de sintaxis en la consulta del php lo devolvera aqui
                                    System.out.println(response);
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
                            params.put("NIE", NIE);
                            params.put("nom",nom);
                            params.put("cp", cp);
                            params.put("cordenades", cordenades + "");
                            params.put("propietari", propietari);
                            params.put("direccio", direccio);
                            params.put("paypal", paypal);
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

    //borrar
    public void update(Activity act){

        String NIE = this.NIE;
        String nom = this.nom;
        String cp = this.cp;
        String cordenades = this.cordenades;
        String propietari = this.propietari.getDni();
        String direccio = this.direccio;
        ArrayList<Treballador> treballadors;
        String paypal = this.paypal;


        try {
            String url = "https://ffames.cat/tippay/Empresa-update.php";
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
                            params.put("NIE", NIE);
                            params.put("nom", nom);
                            params.put("cp", cp);
                            params.put("cordenades", cordenades + "");
                            params.put("propietari", propietari);
                            params.put("direccio", direccio);
                            params.put("paypal", paypal);
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

    //borrar
    public void delete(Activity act){

        String NIE = this.NIE;
        try {
            String url = "https://ffames.cat/tippay/Empresa-delete.php";
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
                            params.put("NIE", NIE);
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

    //buscar todas los trabajadores de una empresa
    public static void totsTreballadors(Activity act, String nie, final VolleyCallBack callBack){
        ArrayList<Treballador> treballadors = new ArrayList<Treballador>();

        try {
            String url = "https://ffames.cat/tippay/Empresa-buscarTotsTreballadors.php";
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
                                    String[] res = resultado.split("=");

                                    for (int i = 0; i < res.length; i++){
                                        String[] valores = res[i].split("#");
                                        Treballador tre = new Treballador(valores[2], valores[4], valores[5], valores[6], valores[7],valores[8], valores[9], valores[10], valores[11],valores[12], valores[3]);
                                        treballadors.add(tre);

                                    }
                                    callBack.onSuccess(treballadors);
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
                            params.put("nie", nie);
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

    //todas las empresas por cp
    public static void todasCP(Activity act, String cp, final VolleyCallBack callBack){
        ArrayList<Empresa> empreses = new ArrayList<Empresa>();

        try {
            String url = "https://ffames.cat/tippay/Empresa-buscarCP.php";
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

                                    String[] res = resultado.split("=");

                                    for (int i = 0; i < res.length; i++){
                                        Propietari pro = new Propietari();
                                        ArrayList<Treballador> treballadors = new ArrayList<Treballador>();
                                        String[] valores = res[i].split("#");
                                        Empresa emp = new Empresa(valores[0], valores[1], valores[2], valores[3], pro,valores[5], treballadors, valores[6]);
                                        empreses.add(emp);
                                    }
                                    callBack.onSuccess(empreses);
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
                            params.put("codipostal", cp);
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

    //activar treballador
    public void nouTreballador(Activity act, String dni ){

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

    //desactivar treballador
    public void vellTreballador(Activity act, String dni ){
        String NIE = this.NIE;

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

    //alta nou treballador EmpresaTreballador-insup.php
    public void altaNouTreballador(Activity act, String dni ){
        String nie = this.getNIE();
        try {
            String url = "https://ffames.cat/tippay/EmpresaTreballador-insup.php";
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


    //baixa nou treballador EmpresaTreballador-insup.php
    public void baixaNouTreballador(Activity act, String dni ){
        String nie = this.getNIE();
        try {
            String url = "https://ffames.cat/tippay/EmpresaTreballador-insupBaixa.php";
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

    public static void acomiadarTreballador(Activity act, String dni, String nie, VolleyCallBack callBack){
        ArrayList<Empresa> empreses = new ArrayList<Empresa>();

        try {
            String url = "https://ffames.cat/tippay/EmpresaTreballador-insupBaixa.php";
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

                                    callBack.onSuccess();
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
                            params.put("nie", nie);
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

    public static void contractarTreballador(Activity act, String dni, String nie, VolleyCallBack callBack){
        ArrayList<Empresa> empreses = new ArrayList<Empresa>();

        try {
            String url = "https://ffames.cat/tippay/EmpresaTreballador-insup.php";
            StringRequest postRequest = new
                    //crear constructor
                    StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //devuelve el resultado de la consulta
                                    //si hay un error de sintaxis en la consulta del php lo devolvera aqui
                                    String resultado = response;
                                    System.out.println("Resposta " + response);

                                    callBack.onSuccess();
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
                            params.put("nie", nie);
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
