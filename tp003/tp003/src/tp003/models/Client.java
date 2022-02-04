/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp003.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WBVC0932
 */
public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private List<Compte> listCompte = new ArrayList<Compte>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Compte> getListCompte() {
        return listCompte;
    }

    public void setListCompte(List<Compte> listCompte) {
        this.listCompte = listCompte;
    }

    public Client(int id, String nom, String prenom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

     public Client( String nom, String prenom, String adresse) {
     
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
    public Client() {
    }
    public void affichier() {
    System.out.println("Numero :"+this.id+ " Nom :"+this.nom+ " Prenom :"+this.prenom
    +" Adrsese:"+ this.adresse);
    for(Compte c:this.listCompte) {
    System.out.println("Compte :"+c.getNumero()+" Type :"+
            c.getType()+" solde :"+c.getSolde());
       }
    }
    
}
