/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author PC
 */
public class Commande implements Serializable {
    private static int compteurId = 1; // Compteur pour générer des IDs uniques
    private int id;
    private String numeroClient;
    private HashMap<Article, Integer> articlesQuantites; // Pour stocker les articles et leurs quantités commandées
    private String statut;
    private Facture facture;

    public Commande(String numeroClient, String statut) {
        this.id = compteurId++; // Génère un ID unique
        this.numeroClient = numeroClient;
        this.articlesQuantites = new HashMap<>();
        this.statut = statut;
    }

    // Méthode pour ajouter un article à la commande
    public void ajouterArticle(Article article, int quantite) {
        articlesQuantites.put(article, quantite);
    }
    
    // Méthode pour obtenir la quantité commandée pour un article
    public int getQuantiteCommandee(Article article) {
        return articlesQuantites.getOrDefault(article, 0);
    }

    // Méthode pour supprimer un article de la commande
    public void supprimerArticle(Article article) {
        articlesQuantites.remove(article);
    }
    
    // Méthode pour restaurer les quantités en stock
    public void restaurerQuantites() {
        for (Article article : articlesQuantites.keySet()) {
            int quantiteCommandee = articlesQuantites.get(article);
            article.ajouterQuantite(quantiteCommandee);
        }
    }

    // Méthode pour obtenir la liste des articles commandés
    public ArrayList<Article> getArticlesCommandes() {
        return new ArrayList<>(articlesQuantites.keySet());
    }

    // Getters et Setters pour les autres attributs
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroClient() {
        return numeroClient;
    }

    public void setNumeroClient(String numeroClient) {
        this.numeroClient = numeroClient;
    }

    public HashMap<Article, Integer> getArticlesQuantites() {
        return articlesQuantites;
    }

    public void setArticlesQuantites(HashMap<Article, Integer> articlesQuantites) {
        this.articlesQuantites = articlesQuantites;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    // Méthode pour afficher les détails de la commande
    public void afficherDetailsCommande() {
        System.out.println("Commande ID: " + id);
        System.out.println("Numéro du client: " + numeroClient);
        System.out.println("Statut: " + statut);
        System.out.println("Articles commandés:");
        for (Article article : articlesQuantites.keySet()) {
            int quantiteCommandee = getQuantiteCommandee(article);
            System.out.println("ID: " + article.getId() + ", Quantité commandée: " + quantiteCommandee + ", Prix: " + article.getPrix());
        }
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", numeroClient='" + numeroClient + '\'' +
                ", articlesQuantites=" + articlesQuantites +
                ", statut='" + statut + '\'' +
                ", facture=" + facture +
                '}';
    }
}
