package clases;

import android.app.Activity;

import java.time.LocalDate;
import java.util.ArrayList;

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

    }

    public void update(Activity act){

    }

    public void delete(Activity act){

    }

}
