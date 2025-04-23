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
public class ListeFacture implements Serializable {
    private HashMap<Integer, Facture> factures;

    public ListeFacture() {
        factures = new HashMap<>();
    }

    // Méthode pour ajouter une facture
    public void ajouterFacture(Facture facture) {
        for (int idCommande : facture.getIdCommandes()) {
            factures.put(idCommande, facture);
        }
        System.out.println("Facture ajoutée : Numéro " + facture.getNumero() + " pour les commandes ID " + facture.getIdCommandes());
    }

    // Méthode pour supprimer une facture par ID de commande
    public void supprimerFacture(int idCommande) {
        Facture facture = factures.remove(idCommande);
        if (facture != null) {
            System.out.println("Facture supprimée : Numéro " + facture.getNumero() + " pour la commande ID " + idCommande);
        } else {
            System.out.println("Aucune facture trouvée pour la commande ID " + idCommande);
        }
    }

    // Méthode pour obtenir une facture par ID de commande
    public Facture obtenirFacture(int idCommande) {
        return factures.get(idCommande);
    }

    // Méthode pour afficher toutes les factures
    public void afficherFactures() {
        if (factures.isEmpty()) {
            System.out.println("Il n'y a pas de factures dans cette liste.");
        } else {
            System.out.println("Liste des factures :");
            for (Facture facture : factures.values()) {
                System.out.println(facture);
            }
        }
    }
}