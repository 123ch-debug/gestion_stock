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
public class Data implements Serializable {
    private ListeClients listeClients;
    private ListeFournisseurs listeFournisseurs;
    private ListeEmploye listeEmployes;
    private ListeArticle listeArticles;
    private ListeCommande listeCommandes;
    private ListeFacture listeFactures;
    private ListeCommandeFourni listeCommandesFourni;

    // Constructeur par défaut
    public Data() {
        this.listeClients = new ListeClients();
        this.listeFournisseurs = new ListeFournisseurs();
        this.listeEmployes = new ListeEmploye();
        this.listeArticles = new ListeArticle();
        this.listeCommandes = new ListeCommande();
        this.listeCommandesFourni = new ListeCommandeFourni();
        listeFactures = new ListeFacture();
    }

    // Getters et setters pour chaque liste
    public ListeClients getListeClients() {
        return listeClients;
    }

    public void setListeClients(ListeClients listeClients) {
        this.listeClients = listeClients;
    }

    public ListeFournisseurs getListeFournisseurs() {
        return listeFournisseurs;
    }

    public void setListeFournisseurs(ListeFournisseurs listeFournisseurs) {
        this.listeFournisseurs = listeFournisseurs;
    }

    public ListeEmploye getListeEmployes() {
        return listeEmployes;
    }

    public void setListeEmployes(ListeEmploye listeEmployes) {
        this.listeEmployes = listeEmployes;
    }

    public ListeArticle getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(ListeArticle listeArticles) {
        this.listeArticles = listeArticles;
    }

    public ListeCommande getListeCommandes() {
        return listeCommandes;
    }

    public void setListeCommandes(ListeCommande listeCommandes) {
        this.listeCommandes = listeCommandes;
    }
    
    public ListeCommandeFourni getListeCommandeFourni() {
        return listeCommandesFourni;
    }

    public void setListeCommandes(ListeCommandeFourni listeCommandesFourni) {
        this.listeCommandesFourni = listeCommandesFourni;
    }
    
    public ListeFacture getListeFactures() {
        return listeFactures;
    }
    
     public void setListeFactures(ListeFacture listeFactures) {
        this.listeFactures = listeFactures;
    }
}