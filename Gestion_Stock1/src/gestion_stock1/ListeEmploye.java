/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class ListeEmploye implements Serializable {
    private ArrayList<Employe> listeEmployes;

    public ListeEmploye() {
        listeEmployes = new ArrayList<>();
    }

    public void ajouterEmploye(Employe employe) {
        listeEmployes.add(employe);
        System.out.println("Employé ajouté : " + employe.getNom() + " " + employe.getPrenom());
    }

    public void supprimerEmploye(int idEmploye) {
        Employe employeASupprimer = null;
        for (Employe employe : listeEmployes) {
            if (employe.getIdEmploye() == idEmploye) {
                employeASupprimer = employe;
                break;
            }
        }
        if (employeASupprimer != null) {
            listeEmployes.remove(employeASupprimer);
            System.out.println("Employé supprimé : " + employeASupprimer.getNom() + " " + employeASupprimer.getPrenom());
        } else {
            System.out.println("Aucun employé trouvé avec l'ID fourni.");
        }
    }

    public void afficherEmployes() {
        if (listeEmployes.isEmpty()) {
            System.out.println("Il n'y a pas d'employés dans cette liste.");
        } else {
            System.out.println("Liste des employés :");
            for (Employe employe : listeEmployes) {
                System.out.println(employe);
            }
        }
    }

}
