/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import java.util.Objects;

/**
 *
 * @author Amine
 */
public class Reclamation {

    private int id_reclamation;
    private String type;
    private String text;
     private String username_client;
     private String nom_client;
    private String prenom_client;
    private int telephone;
     private String email_client;
     private String etat;

    public Reclamation(int id_reclamation, String type, String text, String username_client, String nom_client, String prenom_client, int telephone, String email_client , String etat) {
        this.id_reclamation = id_reclamation;
        this.type = type;
        this.text = text;
        this.username_client = username_client;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.telephone = telephone;
        this.email_client = email_client;
        this.etat=etat;
    }

   

    public Reclamation(int id_reclamation, String type, String text, String username_client , String etat) {
        this.id_reclamation = id_reclamation;
        this.type = type;
        this.text = text;
        this.username_client = username_client;
        this.etat= etat;
    }
    
    public Reclamation(String type, String text, String etat) {
        this.type = type;
        this.text = text;
        this.etat=etat;
    }

    public Reclamation(String type, String text) {
        this.type = type;
        this.text = text;
    }
    

    public int getId_reclamation() {
        return id_reclamation;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public String getUsername_client() {
        return username_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getEmail_client() {
        return email_client;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUsername_client(String username_client) {
        this.username_client = username_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setEmail_client(String email_client) {
        this.email_client = email_client;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

   

   

   

   
   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id_reclamation;
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.text);
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (this.id_reclamation != other.id_reclamation) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", type=" + type + ", text=" + text + ", username_client=" + username_client + ", nom_client=" + nom_client + ", prenom_client=" + prenom_client + ", telephone=" + telephone + ", email_client=" + email_client + ", etat=" + etat + '}';
    }

    

}
