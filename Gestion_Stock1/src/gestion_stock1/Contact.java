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
public class Contact extends Personne implements Serializable {
    private String fonction;

    public Contact(String nom, String prenom, String email, String tel, int numeroRegistreNational, int num, String rue, int codePostal, String ville, String fonction) {
        super(nom, prenom, email, tel, numeroRegistreNational, num, rue, codePostal, ville);
        this.fonction = fonction;
    }

    // Getter pour fonction
    public String getFonction() {
        return this.fonction;
    }

    // Setter pour fonction
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    @Override
    public String toString() {
        return "Contact : " + super.toString() + "; Fonction : " + fonction;
    }
}
