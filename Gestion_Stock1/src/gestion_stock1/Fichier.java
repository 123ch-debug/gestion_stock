/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;
import java.io.*;
/**
 *
 * @author PC
 */
public class Fichier {
    private ObjectOutputStream ofW;
    private ObjectInputStream ofR;
    private char mode;
    private String nomDuFichier = "stock.dat";

    /*public Fichier(String nomDuFichier) {
        this.nomDuFichier = nomDuFichier;
    }*/

    public boolean ouvrir(String s) {
        try {
            mode = (s.toUpperCase()).charAt(0);
            if ((mode == 'R') || (mode == 'L')) {
                ofR = new ObjectInputStream(new FileInputStream(nomDuFichier));
            } else if ((mode == 'W') || (mode == 'E')) {
                ofW = new ObjectOutputStream(new FileOutputStream(nomDuFichier));
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public Data lire() {
        try {
            Data tmp = (Data) ofR.readObject();
            return tmp;
        } catch (IOException e) {
            System.out.println(nomDuFichier + " : Erreur de lecture ");
        } catch (ClassNotFoundException e) {
            System.out.println(nomDuFichier + " n'est pas du bon format ");
        }
        return null;
    }

    public void fermer() {
        try {
            if ((mode == 'R') || (mode == 'L')) {
                if (ofR != null) ofR.close();
            } else if ((mode == 'W') || (mode == 'E')) {
                if (ofW != null) ofW.close();
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la fermeture du fichier : " + e.getMessage());
        }
    }

    public void ecrire(Data tmp) {
        try {
            if (tmp != null) ofW.writeObject(tmp);
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
}