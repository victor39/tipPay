package clases;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tippay.IniciarSessio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Inteficies.VolleyCallBack;

public class Persona {

    private String dni;
    private String nom;
    private String cognom1;
    private String cognom2;
    private String dataNaixement;
    private String telf;
    private String correu;
    private String cp;
    private String paypal;
    private String contrasena;
    private String nomUsuari;

    public Persona(String dni, String nom, String cognom1, String cognom2, String dataNaixement, String telf,
                   String correu, String cp, String paypal, String contrasena,String nomUsuari) {
        super();
        this.dni = dni;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.dataNaixement = dataNaixement;
        this.telf = telf;
        this.correu = correu;
        this.cp = cp;
        this.paypal = paypal;
        this.contrasena = contrasena;
        this.nomUsuari = nomUsuari;
    }

    public Persona (){
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public String getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(String dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPaypal() {
        return paypal;
    }

    public void setPaypal(String paypal) {
        this.paypal = paypal;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String NomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }



    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nom='" + nom + '\'' +
                ", cognom1='" + cognom1 + '\'' +
                ", cognom2='" + cognom2 + '\'' +
                ", dataNaixement=" + dataNaixement +
                ", telf='" + telf + '\'' +
                ", correu='" + correu + '\'' +
                ", cp='" + cp + '\'' +
                ", paypal='" + paypal + '\'' +
                ", nomUsuari='" + nomUsuari + '\'' +
                '}';
    }

    static public void validarUsuari(Activity act, String dni, String psw, final VolleyCallBack callBack){
        try {
            String url = "https://ffames.cat/tippay/Usuarui-validar.php";
            StringRequest postRequest = new
                    //crear constructor
                    StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //devuelve el resultado de la consulta
                                    //si hay un error de sintaxis en la consulta del php lo devolvera aqui
                                    String resultado = response;
                                    System.out.println(resultado);
                                    String[] valores = resultado.split("#");
                                    Treballador tre = new Treballador(valores[2], valores[4], valores[5], valores[6], valores[7],valores[8], valores[9], valores[10], valores[11],valores[12], valores[2]);

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
                            params.put("psw", psw);
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

}
