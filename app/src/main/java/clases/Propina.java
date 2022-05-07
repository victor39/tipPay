package clases;

import android.app.Activity;

import java.util.ArrayList;

public class Propina {

    String dniClient;
    String nieEmpresa;
    String dniTreballador;
    double propina;
    String data;

    public Propina(String dniClient, String dniTreballador, String nieEmpresa, double propina, String data) {
        this.dniClient = dniClient;
        this.nieEmpresa = nieEmpresa;
        this.dniTreballador = dniTreballador;
        this.propina = propina;
        this.data = data;
    }

    public String getClient() {
        return dniClient;
    }

    public void setClient(String dniClient) {
        this.dniClient = dniClient;
    }

    public String getEmpresa() {
        return nieEmpresa;
    }

    public void setEmpresa(String nieEmpresa) {
        this.nieEmpresa = nieEmpresa;
    }

    public String getTreballador() {
        return dniTreballador;
    }

    public void setTreballador(String dniTreballador) {
        this.dniTreballador = dniTreballador;
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
                "client=" + dniClient +
                ", empresa=" + nieEmpresa +
                ", treballador=" + dniTreballador +
                ", propina=" + propina +
                ", data=" + data +
                '}';
    }

    public void insert(Activity act){

    }

    public void update(Activity act){

    }

    public void delete(Activity act){

    }

    //buscar todas las propinas que ha recibido una empresa
    public static ArrayList<Propina> totsEmpresa(Activity act, Empresa emp) {
        ArrayList<Propina> propines = new ArrayList<Propina>();
        return propines;
    }

    //buscar todas las propinas que ha hecho un cliente
    public static ArrayList<Propina> totsClient(Activity act, Client cli) {
        ArrayList<Propina> propines = new ArrayList<Propina>();
        return propines;
    }

    //buscar todas las propinas que ha recibido un trabajador
    public static ArrayList<Propina> totsTreballador(Activity act, Treballador tre) {
        ArrayList<Propina> propines = new ArrayList<Propina>();
        return propines;
    }
}
