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
public class ListeCommandeFourni implements Serializable {
    private HashMap< String, CommandeFournisseur> listeCommandesFournisseurs;

    public ListeCommandeFourni() {
        listeCommandesFournisseurs = new HashMap<>();
    }

    // Méthode pour ajouter une commande fournisseur
    public void ajouterCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
        listeCommandesFournisseurs.put(commandeFournisseur.getNomEntreprise(), commandeFournisseur);
        System.out.println("Commande fournisseur ajoutée : ID " + commandeFournisseur.getId());
    }

    // Méthode pour supprimer une commande fournisseur par ID
    public void supprimerCommandeFournisseur(int idCommande) {
        CommandeFournisseur commandeFournisseur = listeCommandesFournisseurs.remove(idCommande);
        if (commandeFournisseur != null) {
            System.out.println("Commande fournisseur supprimée : ID " + idCommande);
        } else {
            System.out.println("Aucune commande fournisseur trouvée avec l'ID fourni.");
        }
    }

    // Méthode pour afficher les détails de toutes les commandes fournisseurs
    public void afficherCommandesFournisseur() {
        if (listeCommandesFournisseurs.isEmpty()) {
            System.out.println("Il n'y a pas de commandes fournisseurs dans cette liste.");
        } else {
            System.out.println("Liste des commandes fournisseurs :");
            for (CommandeFournisseur commandeFournisseur : listeCommandesFournisseurs.values()) {
                System.out.println(commandeFournisseur);
            }
        }
    }
    

    // Méthode pour obtenir une commande fournisseur par son ID
    public CommandeFournisseur obtenirCommandeFournisseur(int idCommande) {
        return listeCommandesFournisseurs.get(idCommande);
    }
    
     public HashMap<String, CommandeFournisseur> getListeCommandeFourni() {
        return listeCommandesFournisseurs;
    }
}