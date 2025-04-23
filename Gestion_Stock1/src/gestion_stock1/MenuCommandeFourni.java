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
public class MenuCommandeFourni {
    private Data data;
    private static Scanner lectureClavier = new Scanner(System.in);
    
    public MenuCommandeFourni(Data data) {
        this.data = data;
    }

    public void afficherMenu() {
        byte choix;
        do {
            choix = menuCommandeFournisseur();
            switch (choix) {
                case 1:
                    ajouterCommandeFournisseur();
                    break;
                case 2:
                    supprimerCommandeFournisseur();
                    break;
                case 3:
                    afficherCommandesFournisseur();
                    break;
                case 4:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Cette option n'existe pas.");
            }
        } while (choix != 4);
    }

    private byte menuCommandeFournisseur() {
        System.out.println("1. Ajouter une commande fournisseur");
        System.out.println("2. Supprimer une commande fournisseur");
        System.out.println("3. Afficher les commandes fournisseurs");
        System.out.println("4. Retour au menu principal");
        System.out.print("Votre choix : ");
        return lectureClavier.nextByte();
    }

    private void ajouterCommandeFournisseur() {
        lectureClavier.nextLine();  // Consommer le retour à la ligne restant
        System.out.print("Entrez le nom de l'entreprise du fournisseur : ");
        String nomEntreprise = lectureClavier.nextLine();
         if (!fournisseurExiste(nomEntreprise)) {
            System.out.println("fournisseur non trouvé. Ajoutez d'abord le fournisseur avant de créer la commande.");
            return;
        }
        
        System.out.print("Entrez le statut de la commande fournisseur : ");
        String statut = lectureClavier.nextLine();

        CommandeFournisseur commandeFournisseur = new CommandeFournisseur(nomEntreprise, statut);
        
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
            
            //article.deduireQuantite(quantite); // Déduire la quantité commandée du stock disponible

            // Afficher la quantité commandée
            System.out.println("Quantité commandée : " + quantite);
        }
        // Afficher les articles commandés
        afficherArticlesCommandes(commandeFournisseur);
        data.getListeCommandeFourni().ajouterCommandeFournisseur(commandeFournisseur);
        System.out.println("Commande fournisseur ajoutée : " + commandeFournisseur);
        
        /* // Générer et ajouter la facture
        Facture facture = Facture.genererFacture(commande);
        commande.setFacture(facture);
        data.getListeFactures().ajouterFacture(facture);
        System.out.println("Facture générée et ajoutée : " + facture);*/
        
    }
    
    // Méthode pour vérifier si un fournisseur existe
    private boolean fournisseurExiste(String nomEntreprise) {
        return data.getListeFournisseurs().obtenirFournisseur(nomEntreprise) != null;
    }

    private void supprimerCommandeFournisseur() {
        System.out.print("Entrez l'ID de la commande fournisseur à supprimer : ");
        int idCommande = lectureClavier.nextInt();
        data.getListeCommandeFourni().supprimerCommandeFournisseur(idCommande);
        System.out.println("Commande fournisseur supprimée.");
    }

    private void afficherCommandesFournisseur() {
        data.getListeCommandeFourni().afficherCommandesFournisseur();
    }
    
    // Méthode pour afficher les articles commandés avec leurs quantités
    private void afficherArticlesCommandes(CommandeFournisseur commandeFournisseur) {
        System.out.println("Articles commandés :");
        for (Article article : commandeFournisseur.getArticlesCommandes()) {
            int quantiteCommandee = commandeFournisseur.getQuantiteCommandee(article);
            System.out.println("ID: " + article.getId() + ", Quantité commandée: " + quantiteCommandee + ", Prix: " + article.getPrix());
        }
    }
}
