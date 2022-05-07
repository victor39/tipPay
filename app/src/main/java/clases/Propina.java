package clases;

import android.app.Activity;

import java.util.ArrayList;

public class Propina {
    Client client;
    Empresa empresa;
    Treballador treballador;
    double propina;
    String data;

    public Propina(Client client, Empresa empresa, Treballador treballador, double propina, String data) {
        this.client = client;
        this.empresa = empresa;
        this.treballador = treballador;
        this.propina = propina;
        this.data = data;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Treballador getTreballador() {
        return treballador;
    }

    public void setTreballador(Treballador treballador) {
        this.treballador = treballador;
    }

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
