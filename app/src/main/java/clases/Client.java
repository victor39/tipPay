package clases;

import android.app.Activity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client extends Persona{

    ArrayList<Empresa> empresasFav;

    public Client(String dni, String nom, String cognom1, String cognom2, LocalDate dataNaixement, String telf, String correu, int cp, String paypal, String compte_bancari, ArrayList<Empresa> empresaFav) {
        super(dni, nom, cognom1, cognom2, dataNaixement, telf, correu, cp, paypal, compte_bancari);
        this.empresasFav = empresaFav;

    }

    public ArrayList<Empresa> getEmpresasFav() {
        return empresasFav;
    }

    public void setEmpresasFav(ArrayList<Empresa> empresasFav) {
        this.empresasFav = empresasFav;
    }

    public void insert(Activity act){

    }

    public void update(Activity act){

    }

    public void delete(Activity act){

    }
}
