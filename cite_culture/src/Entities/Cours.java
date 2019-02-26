/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Farah
 */
public class Cours 
{
    private int id_cours;
    private String type;
    private int id_prof;
    private int nb_places;
    private String image;
    private int id_salle;
    private Date date;
    private String heure_debut;
    private String heure_fin;
    private float prix;

    
    public Cours(){
        
    }
    
     public Cours(String type, int id_prof, int nb_places, String image, int id_salle, Date date, String heure_debut, String heure_fin, float prix) {
       // this.id_cours = id_cours;
        this.type = type;
        this.id_prof = id_prof;
        this.nb_places = nb_places;
        this.image = image;
        this.id_salle = id_salle;
        this.date = date;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.prix = prix;
    }

    public int getId_cours() {
        return id_cours;
    }

    public String getType() {
        return type;
    }

    public int getId_prof() {
        return id_prof;
    }

    public int getNb_places() {
        return nb_places;
    }

   

    public int getId_salle() {
        return id_salle;
    }

    public Date getDate() {
        return date;
    }

   

    public String getHeure_debut() {
        return heure_debut;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public float getPrix() {
        return prix;
    }

    public String getImage() {
        return image;
    }
    

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public void setNb_places(int nb_places) {
        this.nb_places = nb_places;
    }

    
    

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeure_debut(String heure_debut) {
        this.heure_debut = heure_debut;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin = heure_fin;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Cours{" + "id_cours=" + id_cours + ", type=" + type + ", id_prof=" + id_prof + ", nb_places=" + nb_places + ", image=" + image + ", id_salle=" + id_salle + ", date=" + date + ", heure_debut=" + heure_debut + ", heure_fin=" + heure_fin + ", prix=" + prix + '}';
    }
    
    
}
