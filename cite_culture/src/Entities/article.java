/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author acer
 */
public class article {
     private int id ;
    private String titre_article ;
    private String sujet_article ;
    private String nom_auteur ;
    private String adresse_mail ;
     private String contenu ;
    private Date date;
    private String etat;
    
    public article() {
    }

    public article(String titre_article, String sujet_article, String nom_auteur, String adresse_mail, String contenu) {
       
        this.titre_article = titre_article;
        this.sujet_article = sujet_article;
        this.nom_auteur = nom_auteur;
        this.adresse_mail = adresse_mail;
        this.contenu=contenu;
        
    }

    public String getTitre_article() {
        return titre_article;
    }

    public String getSujet_article() {
        return sujet_article;
    }

    public String getNom_auteur() {
        return nom_auteur;
    }

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public Date getDate() {
        return date;
    }

    public void setTitre_article(String titre_article) {
        this.titre_article = titre_article;
    }

    public void setSujet_article(String sujet_article) {
        this.sujet_article = sujet_article;
    }

    public void setNom_auteur(String nom_auteur) {
        this.nom_auteur = nom_auteur;
    }

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getContenu() {
        return contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    

    @Override
    public String toString() {
        return "article{" + "type_article=" + titre_article + ", sujet_article=" + sujet_article + ", nom_auteur=" + nom_auteur + ", contenu=" + contenu + ", adresse_mail=" + adresse_mail + ", date=" + date + '}';
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
        final article other = (article) obj;
        if (!Objects.equals(this.titre_article, other.titre_article)) {
            return false;
        }
        if (!Objects.equals(this.sujet_article, other.sujet_article)) {
            return false;
        }
        if (!Objects.equals(this.nom_auteur, other.nom_auteur)) {
            return false;
        }
        if (!Objects.equals(this.adresse_mail, other.adresse_mail)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    
}
