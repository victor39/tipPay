package clases;

import java.time.LocalDate;

public class Persona {

    private String dni;
    private String nom;
    private String cognom1;
    private String cognom2;
    private LocalDate dataNaixement;
    private String telf;
    private String correu;
    private int cp;
    private String paypal;
    private String compte_bancari;

    public Persona(String dni, String nom, String cognom1, String cognom2, LocalDate dataNaixement, String telf,
                   String correu, int cp, String paypal, String compte_bancari) {
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
        this.compte_bancari = compte_bancari;
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

    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(LocalDate dataNaixement) {
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

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
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
                ", compte_bancari='" + compte_bancari + '\'' +
                '}';
    }
}
