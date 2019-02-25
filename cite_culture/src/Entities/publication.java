/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author acer
 */
public class publication {
     private int ref ;
     private String titre;
     private String sujet ;
     private String nom_publication ;
     private String nom_auteur ;
     private String date_publication ;
     private String contenu_pub ;
     private String email;

    public publication() {
    }
    public publication(publication x)
    {
        this.ref=x.getRef();
        this.titre=x.getTitre();
        this.sujet=x.getSujet();
        this.nom_publication=x.getNom_publication();
        this.nom_auteur=x.getNom_auteur();
        this.date_publication=x.getDate_publication();
        this.contenu_pub=x.getContenu_pub();
        this.email=x.getEmail();
    }
   
     
     

    public publication( String titre, String sujet, String nom_publication, String nom_auteur, String contenu_pub, String email) {
       
        this.titre = titre;
        this.sujet = sujet;
        this.nom_publication = nom_publication;
        this.nom_auteur = nom_auteur;
       
        this.contenu_pub = contenu_pub;
        this.email = email;
    }

    public int getRef() {
        return ref;
    }

    public String getTitre() {
        return titre;
    }

    public String getSujet() {
        return sujet;
    }

    public String getNom_publication() {
        return nom_publication;
    }

    public String getNom_auteur() {
        return nom_auteur;
    }

    public String getDate_publication() {
        return date_publication;
    }

    public String getContenu_pub() {
        return contenu_pub;
    }

    public String getEmail() {
        return email;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setNom_publication(String nom_publication) {
        this.nom_publication = nom_publication;
    }

    public void setNom_auteur(String nom_auteur) {
        this.nom_auteur = nom_auteur;
    }

    public void setDate_publication(String date_publication) {
        this.date_publication = date_publication;
    }

    public void setContenu_pub(String contenu_pub) {
        this.contenu_pub = contenu_pub;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     
     

    
    
    
}
