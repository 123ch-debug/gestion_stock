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
public class Personne implements Serializable{
    
    protected String nom;
    protected String prenom;
    protected String email;
    protected Adresse adresse;
    protected String tel;
    protected int numeroRegistreNational; 

    public Personne(String nom, String prenom, String email, String tel, int numeroRegistreNational, int num, String rue, int codePostal, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.numeroRegistreNational = numeroRegistreNational; 
        this.adresse = new Adresse(num, rue, codePostal, ville);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setNumeroRegistreNational(int numeroRegistreNational) {
        this.numeroRegistreNational = numeroRegistreNational;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTel() {
        return this.tel;
    }

    public int getNumeroRegistreNational() {
        return this.numeroRegistreNational;
    }

    public String toString() {
        return nom + " " + prenom + " ; " + email + "; tel : " + tel + ";\n adresse : " + adresse + "; Numéro de registre national : " + numeroRegistreNational;
    }
    
}

