/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author PC
 */
public class Article implements Serializable {
    private static final Set<Integer> idsExistants = new HashSet<>();
    private int id;
    private String designation;
    private int quantite;
    private double prix;
    private int codeBarres;

    // Constructeur
    public Article(String designation, int quantite, double prix, int codeBarres) {
        this.id = genererIdUnique();
        this.designation = designation;
        this.quantite = quantite;
        this.prix = prix;
        this.codeBarres = codeBarres;
    }
    
    private static int genererIdUnique() {
        Random random = new Random();
        int id;
        do {
            id = random.nextInt(1000000); // Génère un ID entre 0 et 999999
        } while (idsExistants.contains(id));
        idsExistants.add(id);
        return id;
    }
    
    public void deduireQuantite(int quantiteDeduite) {
        if (quantiteDeduite <= quantite) {
            this.quantite -= quantiteDeduite;
        } else {
            throw new IllegalArgumentException("Quantité déduite supérieure à la quantité en stock.");
        }
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getCodeBarres() {
        return codeBarres;
    }

    public void setCodeBarres(int codeBarres) {
        this.codeBarres = codeBarres;
    }
    
    // Méthode pour ajouter des quantités
    public void ajouterQuantite(int quantiteAjoutee) {
        if (quantiteAjoutee > 0) {
            this.quantite += quantiteAjoutee;
            System.out.println(quantiteAjoutee + " unités ajoutées. Nouvelle quantité : " + this.quantite);
        } else {
            System.out.println("La quantité à ajouter doit être positive.");
        }
    }

    // Méthode pour retirer des quantités
    public void retirerQuantite(int quantiteRetiree) {
        if (quantiteRetiree > 0 && quantiteRetiree <= this.quantite) {
            this.quantite -= quantiteRetiree;
            System.out.println(quantiteRetiree + " unités retirées. Nouvelle quantité : " + this.quantite);
        } else {
            System.out.println("Quantité à retirer invalide. Vérifiez la quantité disponible en stock.");
        }
    }

    
    // Méthode pour afficher les détails de l'article
    public void afficherDetails() {
        System.out.println("ID: " + this.id);
        System.out.println("Désignation: " + this.designation);
        System.out.println("Quantité: " + this.quantite);
        System.out.println("Prix: " + this.prix + " euros");
        System.out.println("Code-barres: " + this.codeBarres);
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", designation=" + designation + ", quantite=" + quantite + ", prix=" + prix + ", codeBarres=" + codeBarres + '}';
    }
}
