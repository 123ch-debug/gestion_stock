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
public class ListeClients implements Serializable {
    private HashMap<String, Client> listeClients;

    public ListeClients() {
        listeClients = new HashMap<>();
    }

    // Méthode pour ajouter un client
    public void ajouterClient(Client client) {
        listeClients.put(client.getNumeroClient(), client);
        //System.out.println("Client ajouté : " + client.getNumeroClient());
    }

    // Méthode pour supprimer un client par numéro de client
    public void supprimerClient(String numeroClient) {
        Client client = listeClients.remove(numeroClient);
        if (client != null) {
            System.out.println("Client supprimé : " + numeroClient);
        } else {
            System.out.println("Aucun client trouvé avec le numéro fourni.");
        }
    }

    // Méthode pour afficher les détails de tous les clients
    public void afficherClients() {
        if (listeClients.isEmpty()) {
            System.out.println("Il n'y a pas de clients dans cette liste.");
        } else {
            for (Client client : listeClients.values()) {
                System.out.println(client);
            }
        }
    }

    // Méthode pour obtenir un client par son numéro de client
    public Client obtenirClient(String numeroClient) {
        return listeClients.get(numeroClient);
    }
    
    public HashMap<String, Client> getListeClients() {
        return listeClients;
    }
}