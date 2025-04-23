/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class MenuCommande {
    private Data data;
    private static Scanner lectureClavier = new Scanner(System.in);
    
    public MenuCommande(Data data) {
        this.data = data;
    }

    public void afficherMenu() {
        byte choix;
        do {
            choix = menuCommande();
            switch (choix) {
                case 1:
                    ajouterCommande();
                    break;
                case 2:
                    supprimerCommande();
                    break;
                case 3:
                    afficherCommandes();
                    break;
                case 4:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Cette option n'existe pas.");
            }
        } while (choix != 4);
    }

    private byte menuCommande() {
        System.out.println("1. Ajouter une commande");
        System.out.println("2. Supprimer une commande");
        System.out.println("3. Afficher les commandes");
        System.out.println("4. Retour au menu principal");
        System.out.print("Votre choix : ");
        return lectureClavier.nextByte();
    }

    private void ajouterCommande() {
        
        lectureClavier.nextLine();  // Consommer le retour à la ligne restant
        System.out.print("Entrez l'ID du client : ");
        String numeroClient = lectureClavier.nextLine();
        if (!clientExiste(numeroClient)) {
            System.out.println("Client non trouvé. Ajoutez d'abord le client avant de créer la commande.");
            return;
        }
        
        System.out.print("Entrez le statut de la commande : ");
        String statut = lectureClavier.nextLine();


        Commande commande = new Commande(numeroClient, statut);
        
        // Ajout d'articles à la commande
        boolean continuer = true;
        while (continuer) {
            System.out.print("Entrez l'ID de l'article (ou 'fin' pour terminer) : ");
            String input = lectureClavier.nextLine();
            if (input.equalsIgnoreCase("fin")) {
                continuer = false;
                break;
            }
            int idArticle = Integer.parseInt(input);
            Article article = data.getListeArticles().getArticle(idArticle);
            if (article == null) {
                System.out.println("Article non trouvé. Ajoutez d'abord l'article avant de l'ajouter à la commande.");
                continue;
            }
            System.out.print("Entrez la quantité de l'article : ");
            int quantite = lectureClavier.nextInt();
            lectureClavier.nextLine();  // Consommer le retour à la ligne restant
            if (quantite > article.getQuantite()) {
                System.out.println("Quantité en stock insuffisante. Stock actuel : " + article.getQuantite());
                continue;
            }
            // Ajoutez l'article avec la quantité commandée
            commande.ajouterArticle(article, quantite);
            article.deduireQuantite(quantite); // Déduire la quantité commandée du stock disponible

            // Afficher la quantité commandée
            System.out.println("Quantité commandée : " + quantite);
        }
        // Afficher les articles commandés
        afficherArticlesCommandes(commande);
        data.getListeCommandes().ajouterCommande(commande);
        System.out.println("Commande ajoutée : " + commande);
        
         // Générer et ajouter la facture
        Facture facture = Facture.genererFacture(commande);
        commande.setFacture(facture);
        data.getListeFactures().ajouterFacture(facture);
        System.out.println("Facture générée et ajoutée : " + facture);
    }
    // Méthode pour vérifier si un client existe
    private boolean clientExiste(String numeroClient) {
        return data.getListeClients().obtenirClient(numeroClient) != null;
    }
    
    private void supprimerCommande() {
    System.out.print("Entrez l'ID de la commande à supprimer : ");
    int idCommande = lectureClavier.nextInt();
    Commande commande = data.getListeCommandes().obtenirCommande(idCommande);
    if (commande != null) {
        commande.restaurerQuantites(); // Restaurer les quantités en stock
        data.getListeCommandes().supprimerCommande(idCommande);
        System.out.println("Commande supprimée et quantités en stock restaurées.");
    } else {
        System.out.println("Commande non trouvée.");
    }
}
    
    private void afficherCommandes() {
        data.getListeCommandes().afficherCommandes();
    }

    // Méthode pour afficher les articles commandés avec leurs quantités
    private void afficherArticlesCommandes(Commande commande) {
        System.out.println("Articles commandés :");
        for (Article article : commande.getArticlesCommandes()) {
            int quantiteCommandee = commande.getQuantiteCommandee(article);
            System.out.println("ID: " + article.getId() + ", Quantité commandée: " + quantiteCommandee + ", Prix: " + article.getPrix());
        }
    }
    
}
