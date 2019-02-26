/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Farah
 */
public class ReservationCours 
{
    private int id_reservationCours ;
    private int id_client;
    
    private int id_cours;

    public ReservationCours()
    {
        
    }
    
    public ReservationCours( int id_client,int id_cours) {
        //this.id_reservationCours = id_reservationCours;
        this.id_client = id_client;
        
        this.id_cours = id_cours;
    }

    public int getId_reservationCours() {
        return id_reservationCours;
    }

    public int getId_client() {
        return id_client;
    }

   

    public int getId_cours() {
        return id_cours;
    }

    public void setId_reservationCours(int id_reservationCours) {
        this.id_reservationCours = id_reservationCours;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

   

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    @Override
    public String toString() {
        return "ReservationCours{" + "id_reservationCours=" + id_reservationCours + ", id_client=" + id_client + ", id_cours=" + id_cours + '}';
    }
    
    
    
    
}
