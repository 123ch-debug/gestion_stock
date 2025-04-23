/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author PC
 */
public class Fournisseur implements Serializable {
    private String nomEntreprise;
    private String numeroTVA;
    private ArrayList<Contact> contacts;

    public Fournisseur(String nomEntreprise, String numeroTVA) {
        this.nomEntreprise = nomEntreprise;
        this.numeroTVA = numeroTVA;
        this.contacts = new ArrayList<>();
    }

    // Getters
    public String getnomEntreprise() {
        return nomEntreprise;
    }

    public String getNumeroTVA() {
        return numeroTVA;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    // Setters
    public void setnomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public void setNumeroTVA(String numeroTVA) {
        this.numeroTVA = numeroTVA;
    }

    public void ajouterContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void supprimerContact(Contact contact) {
        this.contacts.remove(contact);
    }
    
     public void afficherContacts() {
        System.out.println("Contacts du fournisseur " + nomEntreprise + ":");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
     
    public void afficherDetails() {
        System.out.println("Fournisseur : " + nomEntreprise + "; Numéro TVA : " + numeroTVA);
        System.out.println("Contacts :");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }


    @Override
    public String toString() {
        return "Fournisseur : Nom Entreprise: " + nomEntreprise + "; Numéro TVA : " + numeroTVA + "; Contacts : " + contacts;
    }
}

