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
public class MenuFournisseur {
    private Data data;
    private static Scanner lectureClavier = new Scanner(System.in);

    public MenuFournisseur(Data data) {
        this.data = data;
        //this.lectureClavier = new Scanner(System.in);
    }

    public void afficherMenu() {
        byte choix;
        do {
            choix = menuFournisseur();
            switch (choix) {
                case 1:
                    ajouterFournisseur();
                    break;
                case 2:
                    supprimerFournisseur();
                    break;
                case 3:
                    afficherFournisseurs();
                    break;
                case 4:
                    ajouterContactFournisseur();
                    break;
                case 5:
                    supprimerContactFournisseur();
                    break;
                case 6:
                    afficherDetailsFournisseur();
                    break;
                case 7:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Cette option n'existe pas.");
            }
        } while (choix != 7);
    }

    private byte menuFournisseur() {
        System.out.println("1. Ajouter un fournisseur");
        System.out.println("2. Supprimer un fournisseur");
        System.out.println("3. Afficher les fournisseurs");
        System.out.println("4. Ajouter un contact à un fournisseur");
        System.out.println("5. Supprimer un contact d'un fournisseur");
        System.out.println("6. afficherDetailsFournisseur();");
        System.out.println("7. Retour au menu principal");
        System.out.print("Votre choix : ");
        return lectureClavier.nextByte();
    }

    private void ajouterFournisseur() {
        System.out.print("Entrer le nom de l'entreprise du fournisseur : ");
        lectureClavier.nextLine(); // Consume newline left-over
        String nomEntreprise = lectureClavier.nextLine();
        System.out.print("Entrer le numéro de TVA du fournisseur : ");
        String numeroTVA = lectureClavier.nextLine();
        Fournisseur fournisseur = new Fournisseur(nomEntreprise, numeroTVA);
        data.getListeFournisseurs().ajouterFournisseur(fournisseur);
        System.out.println("Fournisseur ajouté : " + fournisseur);
    }

    private void supprimerFournisseur() {
        System.out.print("Entrer le nom de l'entreprise du fournisseur à supprimer : ");
        lectureClavier.nextLine(); // Consume newline left-over
        String nomEntreprise = lectureClavier.nextLine();
        data.getListeFournisseurs().supprimerFournisseur(nomEntreprise);
        System.out.println("Fournisseur supprimé.");
    }

    private void afficherFournisseurs() {
        data.getListeFournisseurs().afficherFournisseurs();
    }

    private void ajouterContactFournisseur() {
        System.out.print("Entrer le nom de l'entreprise du fournisseur : ");
        lectureClavier.nextLine(); // Consume newline left-over
        String nomEntreprise = lectureClavier.nextLine();
        Fournisseur fournisseur = data.getListeFournisseurs().obtenirFournisseur(nomEntreprise);
        if (fournisseur != null) {
            System.out.print("Entrer le nom du contact : ");
            String nom = lectureClavier.nextLine();
            System.out.print("Entrer le prénom du contact : ");
            String prenom = lectureClavier.nextLine();
            System.out.print("Entrer l'email du contact : ");
            String email = lectureClavier.nextLine();
            System.out.print("Entrer le téléphone du contact : ");
            String tel = lectureClavier.nextLine();
            System.out.print("Entrer le numéro de registre national du contact : ");
            int numeroRegistreNational = Integer.parseInt(lectureClavier.nextLine());
            System.out.print("Entrer le numéro de rue du contact : ");
            int num = Integer.parseInt(lectureClavier.nextLine());
            System.out.print("Entrer la rue du contact : ");
            String rue = lectureClavier.nextLine();
            System.out.print("Entrer le code postal du contact : ");
            int codePostal = Integer.parseInt(lectureClavier.nextLine());
            System.out.print("Entrer la ville du contact : ");
            String ville = lectureClavier.nextLine();
            System.out.print("Entrer la fonction du contact : ");
            String fonction = lectureClavier.nextLine();
            Contact contact = new Contact(nom, prenom, email, tel, numeroRegistreNational, num, rue, codePostal, ville, fonction);
            fournisseur.ajouterContact(contact);
            System.out.println("Contact ajouté pour le fournisseur : " + nomEntreprise);
        } else {
            System.out.println("Aucun fournisseur trouvé avec le nom d'entreprise fourni.");
        }
    }

    private void supprimerContactFournisseur() {
        System.out.print("Entrer le nom de l'entreprise du fournisseur : ");
        lectureClavier.nextLine(); // Consume newline left-over
        String nomEntreprise = lectureClavier.nextLine();
        Fournisseur fournisseur = data.getListeFournisseurs().obtenirFournisseur(nomEntreprise);
        if (fournisseur != null) {
            System.out.print("Entrer l'email du contact à supprimer : ");
            String email = lectureClavier.nextLine();
            Contact contactASupprimer = null;
            for (Contact contact : fournisseur.getContacts()) {
                if (contact.getEmail().equals(email)) {
                    contactASupprimer = contact;
                    break;
                }
            }
            if (contactASupprimer != null) {
                fournisseur.supprimerContact(contactASupprimer);
                System.out.println("Contact supprimé pour le fournisseur : " + nomEntreprise);
            } else {
                System.out.println("Aucun contact trouvé avec l'email fourni.");
            }
        } else {
            System.out.println("Aucun fournisseur trouvé avec le nom d'entreprise fourni.");
        }
    }

     private void afficherDetailsFournisseur() {
        System.out.print("Entrer le nom de l'entreprise du fournisseur à afficher : ");
        String nomEntreprise = lectureClavier.next();
        data.getListeFournisseurs().afficherDetailsFournisseur(nomEntreprise);
    }
}