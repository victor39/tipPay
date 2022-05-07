package clases;

import java.time.LocalDate;

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

    public Persona(String dni, String nom, String cognom1, String cognom2, String dataNaixement, String telf,
                   String correu, String cp, String paypal, String contrasena) {
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
                '}';
    }
}
