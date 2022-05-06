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

public class Empresa {

    private String NIE;
    private String nom;
    private String cp;
    private int cordenades;
    private Propietari propietari;
    private String direccio;
    private ArrayList<Treballador> treballadors;
    private String paypal;

    public Empresa(String NIE, String nom, String cp, int cordenades, Propietari propietari, String direccio, ArrayList<Treballador> treballadors, String paypal) {

        this.NIE = NIE;
        this.nom = nom;
        this.cp = cp;
        this.cordenades = cordenades;
        this.propietari = propietari;
        this.direccio = direccio;
        this.treballadors = treballadors;
        this.paypal = paypal;
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

    public int getCordenades() {
        return cordenades;
    }

    public void setCordenades(int cordenades) {
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
        return "Empresa{" +
                "NIE='" + NIE + '\'' +
                ", nom='" + nom + '\'' +
                ", cp='" + cp + '\'' +
                ", cordenades=" + cordenades +
                ", propietari=" + propietari +
                ", direccio='" + direccio + '\'' +
                ", paypal='" + paypal + '\'' +
                '}';
    }

    public void insert(Activity act){

        String NIE = this.NIE;
        String nom = this.nom;
        String cp = this.cp;
        int cordenades = this.cordenades;
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

    public void update(Activity act){

        String NIE = this.NIE;
        String nom = this.nom;
        String cp = this.cp;
        int cordenades = this.cordenades;
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

    //buscar todas las empresas por codigo postal
    public static ArrayList<Treballador> tots(Activity act, int cp){
        ArrayList<Treballador> treballadors = new ArrayList<Treballador>();
        return treballadors;
    }


}
