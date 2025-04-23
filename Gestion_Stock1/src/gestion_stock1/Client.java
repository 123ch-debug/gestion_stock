/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/**
 *
 * @author PC
 */
public class Client extends Personne implements Serializable {
    private static final Set<String> numClientsExistants = new HashSet<>();
    private String numeroClient;
    private String numeroTVA;  

    public Client(String nom, String prenom, String email, String tel, int numeroRegistreNational, int num, String rue, int codePostal, String ville, String numeroTVA) {
        super(nom, prenom, email, tel, numeroRegistreNational, num, rue, codePostal, ville);
        this.numeroClient = genererNumeroClient();
        this.numeroTVA = numeroTVA;  
    }
    
     public void setNumeroClient(String numeroClient) {
        this.numeroClient = numeroClient;
    }

    public String getNumeroClient() {
        return this.numeroClient;
    }
    
    public String getNumeroTVA() {
        return numeroTVA;
    }

    public void setNumeroTVA(String numeroTVA) {
        this.numeroTVA = numeroTVA;
    }
    
   @Override
    public String toString() {
        return "Client : " + super.toString() + "; Numéro Client : " + numeroClient;
    }
    
    private static String genererNumeroClient() {
        Random random = new Random();
        String numeroClient;
        do {
            numeroClient = String.format("%03d", random.nextInt(1000));
        } while (numClientsExistants.contains(numeroClient));
        numClientsExistants.add(numeroClient);
        return numeroClient;
    }
}
