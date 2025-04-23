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
public class ListeCommande implements Serializable{
    private HashMap<Integer, Commande> listeCommandes;

    public ListeCommande() {
        listeCommandes = new HashMap<>();
    }

    // Méthode pour ajouter une commande
    public void ajouterCommande(Commande commande) {
        listeCommandes.put(commande.getId(), commande);
        System.out.println("Commande ajoutée : ID " + commande.getId());
    }

    // Méthode pour supprimer une commande par ID
    public void supprimerCommande(int idCommande) {
        Commande commande = listeCommandes.remove(idCommande);
        if (commande != null) {
            System.out.println("Commande supprimée : ID " + idCommande);
        } else {
            System.out.println("Aucune co"
                    + "mmande trouvée avec l'ID fourni.");
        }
    }

    // Méthode pour afficher les détails de toutes les commandes
    public void afficherCommandes() {
        if (listeCommandes.isEmpty()) {
            System.out.println("Il n'y a pas de commandes dans cette liste.");
        } else {
            System.out.println("Liste des commandes :");
            for (Commande commande : listeCommandes.values()) {
                System.out.println(commande);
            }
        }
    }

    // Méthode pour obtenir une commande par son ID
    public Commande obtenirCommande(int idCommande) {
        return listeCommandes.get(idCommande);
    }
}