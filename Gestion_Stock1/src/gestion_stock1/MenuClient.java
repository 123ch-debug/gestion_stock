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
public class MenuClient {
    private Data data;
    private static Scanner lectureClavier = new Scanner(System.in);

    public MenuClient(Data data) {
        this.data = data;
        //this.lectureClavier = new Scanner(System.in);
    }

    public void afficherMenu() {
        byte choix;
        do {
            choix = menuClient();
            switch (choix) {
                case 1:
                    ajouterClient();
                    break;
                case 2:
                    supprimerClient();
                    break;
                case 3:
                    afficherClients();
                    break;
                case 4:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Cette option n'existe pas.");
            }
        } while (choix != 4);
    }

    private byte menuClient() {
        System.out.println("1. Ajouter un client");
        System.out.println("2. Supprimer un client");
        System.out.println("3. Afficher les clients");
        System.out.println("4. Retour au menu principal");
        System.out.print("Votre choix : ");
        return lectureClavier.nextByte();
    }

    private void ajouterClient() {
        lectureClavier.nextLine();  // Consommer le retour à la ligne restant
        System.out.print("Entrez le prénom du client : ");
        String prenom = lectureClavier.nextLine();
        System.out.print("Entrez le nom du client : ");
        String nom = lectureClavier.nextLine();
        System.out.print("Entrez l'email du client : ");
        String email = lectureClavier.nextLine();
        System.out.print("Entrez le numéro de téléphone du client : ");
        String tel = lectureClavier.nextLine();
        System.out.print("Entrez le numéro de registre national du client : ");
        int numeroRegistreNational = lectureClavier.nextInt();
        lectureClavier.nextLine();  // Consommer le retour à la ligne restant
        System.out.print("Entrez le numéro de la rue : ");
        int num = lectureClavier.nextInt();
        lectureClavier.nextLine();  // Consommer le retour à la ligne restant
        System.out.print("Entrez le nom de la rue : ");
        String rue = lectureClavier.nextLine();
        System.out.print("Entrez le code postal : ");
        int codePostal = lectureClavier.nextInt();
        lectureClavier.nextLine();  // Consommer le retour à la ligne restant
        System.out.print("Entrez la ville : ");
        String ville = lectureClavier.nextLine();
        System.out.print("Entrez le numéro de TVA : ");
        String numeroTVA = lectureClavier.nextLine();
        
        Client client = new Client(nom, prenom, email, tel, numeroRegistreNational, num, rue, codePostal, ville, numeroTVA);
        data.getListeClients().ajouterClient(client);
        System.out.println("Client ajouté : " + client);
    }

    private void supprimerClient() {
        System.out.print("Entrer le numéro du client à supprimer : ");
        String numeroClient = lectureClavier.next();
        data.getListeClients().supprimerClient(numeroClient);
        System.out.println("Client supprimé.");
    }

    private void afficherClients() {
        data.getListeClients().afficherClients();
    }

}
