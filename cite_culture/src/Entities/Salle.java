/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Nitro
 */
public class Salle {
    private int id_salle;
    private String type;
    private String designation;
    private String etat;
    private int limit;

    public Salle() {
    }

    public Salle(String type, String designation, String etat, int limit) {
        this.type = type;
        this.designation = designation;
        this.etat = etat;
        this.limit = limit;
    }

   

    public int getId_salle() {
        return id_salle;
    }

    public String getType() {
        return type;
    }

    public String getEtat() {
        return etat;
    }

    public int getLimit() {
        return limit;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Salle{" + "id_salle=" + id_salle + ", type=" + type + ", designation=" + designation + ", etat=" + etat + ", limit=" + limit + '}';
    }

   

    
}
