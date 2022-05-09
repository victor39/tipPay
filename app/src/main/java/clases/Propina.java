package clases;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Propina {

    String client;
    String empresa;
    String treballador;
    double propina;
    String data;

    public Propina(String client, String treballador, String empresa, double propina, String data) {
        this.client = client;
        this.empresa = empresa;
        this.treballador = treballador;
        this.propina = propina;
        this.data = data;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String dniClient) {
        this.client = dniClient;
    }

    public String getEmpresa() { return empresa; }

    public void setEmpresa(String nieEmpresa) {
        this.empresa = nieEmpresa;
    }

    public String getTreballador() {
        return treballador;
    }

    public void setTreballador(String dniTreballador) {
        this.treballador = dniTreballador;
    }

    public String getData(){return data;}

    public void setData(String data){this.data = data;}

    public double getPropina() {
        return propina;
    }

    public void setPropina(double propina) {
        this.propina = propina;
    }

    @Override
    public String toString() {
        return "Propina{" +
                "client=" + client +
                ", empresa=" + empresa +
                ", treballador=" + treballador +
                ", propina=" + propina +
                ", data=" + data +
                '}';
    }

    public void insert(Activity act){

        String dniClient = this.client;
        String nie = this.empresa;
        String dniTreballador = this.treballador;
        Double propina = this.propina;

        try {
            String url = "https://ffames.cat/tippay/Client-insert.php";
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
                            params.put("dniClient", dniClient);
                            params.put("dniTreballador", dniTreballador);
                            params.put("nie", nie);
                            params.put("propina", propina + "");
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
