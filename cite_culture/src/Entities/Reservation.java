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
public class Reservation {
    
    
    
    private Date date_reservation;
   private float prix;
    private String siege;
    private String Qr;
    private int nb_place;
    private int id_user;
    private int id_event;
    private int id;

    public Reservation() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

   
    
    
    
    public Reservation( float prix, String siege, String Qr, int nb_place, int id_user, int id_event) {
        //this.date_reservation = date_reservation;
        this.prix = prix;
        this.siege = siege;
        this.Qr = Qr;
        this.nb_place = nb_place;
        this.id_user = id_user;
        this.id_event = id_event;
        
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    @Override
    public String toString() {
        return "Reservation{" + "date_reservation=" + date_reservation + ", prix=" + prix + ", siege=" + siege + ", Qr=" + Qr + ", nb_place=" + nb_place + ", id_user=" + id_user + ", id_event=" + id_event + ", id=" + id + '}';
    }

    

   
    
    
    
    
    
    
    
}
