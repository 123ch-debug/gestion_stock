/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author PC
 */
public class Facture implements Serializable {
    private int numero;
    private Date dateEmission;
    private double montantTotal;
    private ArrayList<Integer> idCommandes;

    public Facture(int numero, Date dateEmission, double montantTotal, ArrayList<Integer> idCommandes) {
        this.numero = numero;
        this.dateEmission = dateEmission;
        this.montantTotal = montantTotal;
        this.idCommandes = idCommandes;
    }

    // Getters et Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public ArrayList<Integer> getIdCommandes() {
        return idCommandes;
    }

    public void setIdCommandes(ArrayList<Integer> idCommandes) {
        this.idCommandes = idCommandes;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "numero=" + numero +
                ", dateEmission=" + dateEmission +
                ", montantTotal=" + montantTotal +
                ", idCommandes=" + idCommandes +
                '}';
    }

    // Méthode pour générer une facture à partir d'une commande
    public static Facture genererFacture(Commande commande) {
        int numero = generateFactureNumber();
        Date dateEmission = new Date();
        double montantTotal = calculerMontantTotal(commande);
        ArrayList<Integer> idCommandes = new ArrayList<>();
        idCommandes.add(commande.getId());
        return new Facture(numero, dateEmission, montantTotal, idCommandes);
    }

    // Méthode pour calculer le montant total d'une commande
    private static double calculerMontantTotal(Commande commande) {
        double montantTotal = 0;
        for (Article article : commande.getArticlesCommandes()) {
            montantTotal += commande.getQuantiteCommandee(article) * article.getPrix();
        }
        
        return montantTotal;
    }
    // Méthode pour générer un numéro de facture unique
    private static int generateFactureNumber() {
        // Implémentez une logique pour générer un numéro de facture unique
        return (int) (Math.random() * 10000);
    }
    
}