/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author moham
 */
public class Ticket {
    
    
    
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private Date date_reservation;
    private float prix;
    private String siege;
    private String Qr;
    private int nb_place;
    private String time;
    private String titre;
    private Date date;

    

    public Ticket() {
    }

   /* public Ticket(int id, String nom, String prenom, String mail, Date date_reservation, float prix, String siege, String Qr, int nb_place) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.date_reservation = date_reservation;
        this.prix = prix;
        this.siege = siege;
        this.Qr = Qr;
        this.nb_place = nb_place;
    }*/
  public Ticket(int id, String nom, String prenom, String mail, Date date_reservation, float prix, String siege, String Qr, int nb_place, String time, String titre, Date date) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.date_reservation = date_reservation;
        this.prix = prix;
        this.siege = siege;
        this.Qr = Qr;
        this.nb_place = nb_place;
        this.time = time;
        this.titre = titre;
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }

    public String getQr() {
        return Qr;
    }

    public void setQr(String Qr) {
        this.Qr = Qr;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", date_reservation=" + date_reservation + ", prix=" + prix + ", siege=" + siege + ", Qr=" + Qr + ", nb_place=" + nb_place + ", time=" + time + ", titre=" + titre + ", date=" + date + '}';
    }

 
    
    
   
    
    
}
