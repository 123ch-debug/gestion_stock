/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

/**
 *
 * @author PC
 */
public class MenuFacture {
   private Data data;
    private static Scanner lectureClavier = new Scanner(System.in);

    public MenuFacture(Data data) {
        this.data = data;
    }

    public void afficherMenu() {
        byte choix;
        do {
            choix = menuFacture();
            switch (choix) {
                case 1:
                    ajouterFacture();
                    break;
                case 2:
                    supprimerFacture();
                    break;
                case 3:
                    afficherFactures();
                    break;
                case 4:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Cette option n'existe pas.");
            }
        } while (choix != 4);
    }

    private byte menuFacture() {
        System.out.println("1. Ajouter une facture");
        System.out.println("2. Supprimer une facture");
        System.out.println("3. Afficher les factures");
        System.out.println("4. Retour au menu principal");
        System.out.print("Votre choix : ");
        return lectureClavier.nextByte();
    }

    private void ajouterFacture() {
        lectureClavier.nextLine();  // Consommer le retour à la ligne restant
        System.out.print("Entrez le numéro de la facture : ");
        int numero = lectureClavier.nextInt();
        lectureClavier.nextLine();  // Consommer le retour à la ligne restant

        System.out.print("Entrez la date d'émission (dd/MM/yyyy) : ");
        String dateEmissionStr = lectureClavier.nextLine();
        Date dateEmission = convertStringToDate(dateEmissionStr);
        if (dateEmission == null) {
            System.out.println("Format de date invalide.");
            return;
        }

        System.out.print("Entrez le montant total : ");
        double montantTotal = lectureClavier.nextDouble();

        System.out.print("Entrez l'ID de la commande associée : ");
        int idCommande = lectureClavier.nextInt();
        Commande commande = data.getListeCommandes().obtenirCommande(idCommande);
        if (commande == null) {
            System.out.println("Commande non trouvée. Ajoutez d'abord la commande avant de créer la facture.");
            return;
        }
        lectureClavier.nextLine();  // Consommer le retour à la ligne restant
        // Créer une ArrayList contenant l'ID de la commande
        ArrayList<Integer> idCommandes = new ArrayList<>();
        idCommandes.add(idCommande);

       // Créer l'objet Facture en utilisant le constructeur approprié
        Facture facture = new Facture(numero, dateEmission, montantTotal, idCommandes);
        data.getListeFactures().ajouterFacture(facture);
        System.out.println("Facture ajoutée : " + facture);
    }

    private void supprimerFacture() {
        System.out.print("Entrez l'ID de la commande associée à la facture à supprimer : ");
        int idCommande = lectureClavier.nextInt();
        data.getListeFactures().supprimerFacture(idCommande);
        System.out.println("Facture supprimée.");
    }

    private void afficherFactures() {
        data.getListeFactures().afficherFactures();
    }

    // Méthode pour convertir une chaîne en Date
    private Date convertStringToDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Format de date incorrect. Utilisez dd/MM/yyyy.");
            return null;
        }
    }
}