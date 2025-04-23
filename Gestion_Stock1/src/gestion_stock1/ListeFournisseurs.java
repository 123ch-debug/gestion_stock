/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;

//import java.util.ArrayList;
import java.io.Serializable;
import java.util.HashMap;
//import java.util.Map;

/**
 *
 * @author PC
 */
public class ListeFournisseurs implements Serializable {
    private HashMap<String, Fournisseur> listeFournisseurs;

    public ListeFournisseurs() {
        this.listeFournisseurs = new HashMap<>();
    }

    // Méthode pour ajouter un fournisseur
    public void ajouterFournisseur(Fournisseur fournisseur) {
        this.listeFournisseurs.put(fournisseur.getnomEntreprise(), fournisseur);
        System.out.println("Fournisseur ajouté : " + fournisseur.getnomEntreprise());
    }

    // Méthode pour supprimer un fournisseur par nom d'entreprise
    public void supprimerFournisseur(String nomEntreprise) {
        Fournisseur fournisseurSupprime = this.listeFournisseurs.remove(nomEntreprise);
        if (fournisseurSupprime != null) {
            System.out.println("Fournisseur supprimé : " + fournisseurSupprime.getnomEntreprise());
        } else {
            System.out.println("Aucun fournisseur trouvé avec le nom d'entreprise fourni.");
        }
    }

    // Méthode pour afficher les détails de tous les fournisseurs
    public void afficherFournisseurs() {
        if (listeFournisseurs.isEmpty()) {
            System.out.println("Il n'y a pas de fournisseurs dans cette liste.");
        } else {
            System.out.println("Liste des fournisseurs :");
            for (Fournisseur fournissseur : listeFournisseurs.values()) {
                System.out.println(fournissseur);
            }
        }
    }
    
    public void afficherDetailsFournisseur(String nomEntreprise) {
        Fournisseur fournisseur = this.listeFournisseurs.get(nomEntreprise);
        if (fournisseur != null) {
            fournisseur.afficherDetails();
        } else {
            System.out.println("Aucun fournisseur trouvé avec le nom d'entreprise fourni.");
        }
    }

    // Méthode pour ajouter un contact à un fournisseur
    public void ajouterContactFournisseur(String nomEntreprise, Contact contact) {
        Fournisseur fournisseur = this.listeFournisseurs.get(nomEntreprise);
        if (fournisseur != null) {
            fournisseur.ajouterContact(contact);
            System.out.println("Contact ajouté pour le fournisseur : " + fournisseur.getnomEntreprise());
        } else {
            System.out.println("Aucun fournisseur trouvé avec le nom d'entreprise fourni.");
        }
    }

    // Méthode pour supprimer un contact d'un fournisseur
    public void supprimerContactFournisseur(String nomEntreprise, Contact contact) {
        Fournisseur fournisseur = this.listeFournisseurs.get(nomEntreprise);
        if (fournisseur != null) {
            fournisseur.supprimerContact(contact);
            System.out.println("Contact supprimé pour le fournisseur : " + fournisseur.getnomEntreprise());
        } else {
            System.out.println("Aucun fournisseur trouvé avec le nom d'entreprise fourni.");
        }
    }

    // Getter pour obtenir un fournisseur
    public Fournisseur obtenirFournisseur(String nomEntreprise) {
        return this.listeFournisseurs.get(nomEntreprise);
    }

    // Getter pour obtenir la liste des fournisseurs
    public HashMap<String, Fournisseur> getListeFournisseurs() {
        return this.listeFournisseurs;
    }
}