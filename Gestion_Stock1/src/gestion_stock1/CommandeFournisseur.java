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
public class CommandeFournisseur implements Serializable {
    private static int compteurId = 1; // Compteur pour générer des IDs uniques
    private int id;
    private String nomEntreprise;
    private ArrayList<Article> articles;
    private String statut;
    private Facture facture;
    private HashMap<Integer, Integer> quantitesCommandees; // Ajouté

    public CommandeFournisseur(String nomEntreprise, String statut) {
       this.id = compteurId++; // Génère un ID unique
        this.nomEntreprise = nomEntreprise;
        this.articles = new ArrayList<>();
        this.statut = statut;
        this.quantitesCommandees = new HashMap<>(); // Initialisé
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }
    
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

   // Méthode pour ajouter un article à la commande
    public void ajouterArticle(Article article, int quantite) {
        if (quantitesCommandees.containsKey(article.getId())) {
            int nouvelleQuantite = quantitesCommandees.get(article.getId()) + quantite;
            quantitesCommandees.put(article.getId(), nouvelleQuantite);
        } else {
            articles.add(article);
            quantitesCommandees.put(article.getId(), quantite);
        }
    }

    // Méthode pour supprimer un article de la commande
    public void supprimerArticle(Article article) {
        articles.remove(article);
        quantitesCommandees.remove(article.getId());
    }
    
    // Méthode pour obtenir la liste des articles commandés
    public ArrayList<Article> getArticlesCommandes() {
        return articles;
    }
     // Méthode pour obtenir la quantité commandée pour un article
    public int getQuantiteCommandee(Article article) {
        return quantitesCommandees.getOrDefault(article.getId(), 0);
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
        System.out.println("Nom de l'entreprise: " + nomEntreprise);
        System.out.println("Statut: " + statut);
        System.out.println("Articles commandés:");
        for (Article article : articles) {
            int quantiteCommandee = getQuantiteCommandee(article);
            System.out.println("ID: " + article.getId() + ", Quantité commandée: " + quantiteCommandee + ", Prix: " + article.getPrix());
        }
    }

    @Override
    public String toString() {
        return "CommandeFournisseur{" + "id=" + id + ", nomEntreprise=" + nomEntreprise + ", articles=" + articles + ", statut=" + statut + ", facture=" + facture + ", quantitesCommandees=" + quantitesCommandees + '}';
    }
   
}
