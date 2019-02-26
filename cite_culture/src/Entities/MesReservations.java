/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author Farah
 */
public class MesReservations {
    
     private int id;
    private String nomC;
    private String prenomC;
     private String nomP;
    private String prenomP;
    private String mail;
    private Date date_cours;
    private float prix;
    private String salle;
    private String time;
    private String type;

    public MesReservations(){
        
    }
    
    
    public MesReservations(int id, String nomC, String prenomC, String nomP, String prenomP, String mail, Date date_cours, float prix, String salle, String time, String type) {
        this.id = id;
        this.nomC = nomC;
        this.prenomC = prenomC;
        this.nomP = nomP;
        this.prenomP = prenomP;
        this.mail = mail;
        this.date_cours = date_cours;
        this.prix = prix;
        this.salle = salle;
        this.time = time;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getNomC() {
        return nomC;
    }

    public String getPrenomC() {
        return prenomC;
    }

    public String getNomP() {
        return nomP;
    }

    public String getPrenomP() {
        return prenomP;
    }

    public String getMail() {
        return mail;
    }

    public Date getDate_cours() {
        return date_cours;
    }

    public float getPrix() {
        return prix;
    }

    public String getSalle() {
        return salle;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public void setPrenomC(String prenomC) {
        this.prenomC = prenomC;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDate_cours(Date date_cours) {
        this.date_cours = date_cours;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MesReservations{" + "id=" + id + ", nomC=" + nomC + ", prenomC=" + prenomC + ", nomP=" + nomP + ", prenomP=" + prenomP + ", mail=" + mail + ", date_cours=" + date_cours + ", prix=" + prix + ", salle=" + salle + ", time=" + time + ", type=" + type + '}';
    }
   
    
}
