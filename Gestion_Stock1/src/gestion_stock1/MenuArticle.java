/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;
import java.util.*;

/**
 *
 * @author PC
 */
public class MenuArticle {
    private Data data;
    private Scanner lectureClavier = new Scanner(System.in);
    
    public MenuArticle(Data data) {
        this.data = data;
    }

    public void afficherMenu() {
        byte choix;
        do {
            choix = menuArticle();
            switch (choix) {
                case 1:
                    ajouterArticle();
                    break;
                case 2:
                    supprimerArticle();
                    break;
                case 3:
                    afficherArticles();
                    break;
                case 4:
                    ajouterQuantiteArticle();
                    break;
                case 5:
                    retirerQuantiteArticle();
                    break;
                case 6:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Cette option n'existe pas.");
            }
        } while (choix != 6);
    }

    private byte menuArticle() {
        System.out.println("1. Ajouter un article");
        System.out.println("2. Supprimer un article");
        System.out.println("3. Afficher les articles");
        System.out.println("4. Ajouter une quantité à un article");
        System.out.println("5. Retirer une quantité à un article");
        System.out.println("6. Retour au menu principal");
        System.out.print("Votre choix : ");
        return lectureClavier.nextByte();
    }

     private void ajouterArticle() {
        lectureClavier.nextLine(); // Consomme le retour à la ligne
        System.out.print("Entrez la désignation de l'article : ");
        String designation = lectureClavier.nextLine();
        System.out.print("Entrez la quantité de l'article : ");
        int quantite = lectureClavier.nextInt();
        lectureClavier.nextLine(); // Consomme le retour à la ligne
        System.out.print("Entrez le prix de l'article : ");
        double prix = lectureClavier.nextDouble();
        lectureClavier.nextLine(); // Consomme le retour à la ligne
        System.out.print("Entrez le code-barres de l'article : ");
        int codeBarres = lectureClavier.nextInt();
        lectureClavier.nextLine(); // Consomme le retour à la ligne
        
        Article article = new Article(designation, quantite, prix, codeBarres);
        data.getListeArticles().ajouterArticle(article);
        System.out.println("Article ajouté : " + article);
        
        
    }

    private void supprimerArticle() {
        System.out.print("Entrer l'id de l'article à supprimer : ");
        int id = lectureClavier.nextInt();
        data.getListeArticles().supprimerArticle(id);
        System.out.println("article supprimé.");
    }

    private void afficherArticles() {
        data.getListeArticles().afficherArticles();
    }
    
    private void ajouterQuantiteArticle() {
        System.out.print("Entrez l'ID de l'article : ");
        int id = lectureClavier.nextInt();
        Article article = data.getListeArticles().getArticle(id);
        if (article != null) {
            System.out.print("Entrez la quantité à ajouter : ");
            int quantiteAjoutee = lectureClavier.nextInt();
            article.ajouterQuantite(quantiteAjoutee);
        } else {
            System.out.println("Aucun article trouvé avec l'ID fourni.");
        }
    }
    
    private void retirerQuantiteArticle() {
        System.out.print("Entrez l'ID de l'article : ");
        int id = lectureClavier.nextInt();
        Article article = data.getListeArticles().getArticle(id);
        if (article != null) {
            System.out.print("Entrez la quantité à retirer : ");
            int quantiteRetiree = lectureClavier.nextInt();
            article.retirerQuantite(quantiteRetiree);
        } else {
            System.out.println("Aucun article trouvé avec l'ID fourni.");
        }
    }

}

