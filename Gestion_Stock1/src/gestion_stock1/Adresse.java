/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_stock1;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Adresse implements Serializable {
    public  String rue, ville;
    public  int codePostal,numero;
    
    public Adresse(int num, String rue, int codePostal, String ville){
        this.numero = num;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }
    public void setNum(int num){
        this.numero = num;
    }
    public void setRue(String rue){
        this.rue = rue;
    }
    public void setCodePostal(int code){
        this.codePostal = code;
    }
    public void setVille(String ville){
        this.ville = ville;
    }
    public int getNum(){
        return this.numero;
    }
    public String getRue(){
        return this.rue;
    }
    public int getCodePostal(){
        return this.codePostal;
    }
    public String getVille(){
        return this.ville;
    }
    public String toString() 
    {
        return "nom de la rue : "  + this.rue +
	" Numero de rue : " + this.numero +
	", code postal " + this.codePostal + " nom de la ville " + this.ville;
    }  
    
}
