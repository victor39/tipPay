package clases;

import android.app.Activity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {

    private int cp;
    private int cordenades;
    private Propietari propietari;
    private String direccio;
    private ArrayList<Treballador> treballadors;
    private String paypal;
    private String compte_bancari;

    public Empresa(int cp, int cordenades, Propietari propietari, String direccio, ArrayList<Treballador> treballadors, String paypal, String compte_bancari) {

        this.cp = cp;
        this.cordenades = cordenades;
        this.propietari = propietari;
        this.direccio = direccio;
        this.treballadors = treballadors;
        this.paypal = paypal;
        this.compte_bancari = compte_bancari;

    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
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

    public String getCompte_bancari() {
        return compte_bancari;
    }

    public void setCompte_bancari(String compte_bancari) {
        this.compte_bancari = compte_bancari;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "cp=" + cp +
                ", cordenades=" + cordenades +
                ", propietari=" + propietari +
                ", direccio='" + direccio + '\'' +
                ", paypal='" + paypal + '\'' +
                ", compte_bancari='" + compte_bancari + '\'' +
                '}';
    }

    public void insert(Activity act){

    }

    public void update(Activity act){

    }

    public void delete(Activity act){

    }

    //buscar todas las empresas por codigo postal
    public static ArrayList<Treballador> tots(Activity act, int cp){
        ArrayList<Treballador> treballadors = new ArrayList<Treballador>();
        return treballadors;
    }


}
