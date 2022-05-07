package clases;

import android.app.Activity;

import java.util.ArrayList;

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
