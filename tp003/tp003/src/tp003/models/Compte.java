/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp003.models;

/**
 *
 * @author WBVC0932
 */
public class Compte {
    private String numero;
    private String type;
    private double solde;
    private int client;

    public int getClient() {
        return client;
    }
    public void setClient(int client) {
        this.client=client;
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Compte(String numero, String type, double solde) {
        this.numero = numero;
        this.type = type;
        this.solde = solde;
    }

    public Compte() {
        this.solde=0;
    }
   
}
