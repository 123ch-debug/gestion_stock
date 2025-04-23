/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author PC
 */
public class ListeArticle implements Serializable {
    private HashMap<Integer, Article> articles;
   //private int quantite;

    public ListeArticle() {
        articles = new HashMap<>();
    }

    // Méthode pour ajouter un article
    public void ajouterArticle(Article article) {
        articles.put(article.getId(), article);
        //System.out.println("Article ajouté : " + article.getDesignation());
    }

    // Méthode pour supprimer un article par ID
    public void supprimerArticle(int id) {
        Article articleASupprimer = articles.get(id);
        if (articleASupprimer != null) {
            articles.remove(id);
            System.out.println("Article supprimé : " + articleASupprimer.getDesignation());
        } else {
            System.out.println("Aucun article trouvé avec l'ID fourni.");
        }
    }
    
    // Méthode pour obtenir un article par ID
    public Article getArticle(int id) {
        return articles.get(id);
    }
    
    
    
    // Méthode pour afficher les détails de tous les articles
    public void afficherArticles() {
        if (articles.isEmpty()) {
            System.out.println("Aucun article dans le stock.");
        } else {
            for (Article article : articles.values()) {
                article.afficherDetails();
                System.out.println();
            }
        }
    }
}
