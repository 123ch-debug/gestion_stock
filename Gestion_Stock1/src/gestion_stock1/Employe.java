/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Employe implements Serializable {
    private int idEmploye;
    private String nom;
    private String prenom;
    //private String email;
   // private String tel;
    private Adresse adresse;
    private String poste;
    private double salaire;

    // Constructeur
    public Employe(int idEmploye, String nom, String prenom, String email, String tel, int num, String rue, int codePostal, String ville, String poste, double salaire) {
        this.idEmploye = idEmploye;
        this.nom = nom;
        this.prenom = prenom;
        //this.email = email;
        //this.tel = tel;
        this.adresse = new Adresse(num, rue, codePostal, ville);
        this.poste = poste;
        this.salaire = salaire;
    }

    // Getters et Setters
    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

   /* public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }*/

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "idEmploye=" + idEmploye +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                //", email='" + email + '\'' +
                //", tel='" + tel + '\'' +
                ", adresse=" + adresse +
                ", poste='" + poste + '\'' +
                ", salaire=" + salaire +
                '}';
    }
}
