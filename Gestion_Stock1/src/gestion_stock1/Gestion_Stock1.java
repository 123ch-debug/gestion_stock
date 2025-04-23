/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion_stock1;
import java.util.*;


/**
 *
 * @author PC
 */
public class Gestion_Stock1 {
    private static Scanner lectureClavier = new Scanner(System.in);
    private static Data data;
    
    public static void main(String[] args) {
        byte choix;
        Fichier F = new Fichier();

        if (F.ouvrir("Lecture")) {
            data = F.lire();
            F.fermer();
        }

        if (data == null) {
            data = new Data();
        }

        do {
            choix = menuPrincipal();
            switch (choix) {
                case 1:
                    new MenuArticle(data).afficherMenu();
                    break;
                case 2:
                    new MenuClient(data).afficherMenu();
                    break;
                case 3:
                    new MenuFournisseur(data).afficherMenu();
                    break;
                case 4:
                    new MenuCommande(data).afficherMenu();
                    break;
                case 5:
                    new MenuCommandeFourni(data).afficherMenu();
                    break;
                case 6:
                    new MenuFacture(data).afficherMenu();
                    break;
                case 7:
                    System.out.println("Sauvegarde des données dans stock.dat");
                    F.ouvrir("Ecriture");
                    F.ecrire(data);
                    F.fermer();
                    sortir();
                    break;
                default:
                    System.out.println("Cette option n'existe pas.");
            }
        } while (choix != 7);
    }

    public static byte menuPrincipal() {
        System.out.println("1. Gestion des articles");
        System.out.println("2. Gestion des clients");
        System.out.println("3. Gestion des fournisseurs");
        System.out.println("4 Gestion des commandes clients");
        System.out.println("5 Gestion des commandes fournisseurs");
        System.out.println("6 Gestion des Factures");
        System.out.println("7. Sauvegarder et sortir");
        System.out.print("Votre choix : ");
        return lectureClavier.nextByte();
    }

    public static void sortir() {
        System.out.println("Au revoir et à bientôt");
        System.exit(0);
    }
}