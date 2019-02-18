/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author mouna dridi
 */
public class Galerie extends Evenement{
    private int idGalerie;
     private int idEvent;


    public Galerie(String titre, String description, Date dateD, Date dateF, String salle, float prixEnfant, float prixAdulte, float prixEtudiant, String time1, String typeEvent, String image, int nbrPlace) {
        super(titre, description, dateD, dateF, salle, prixEnfant, prixAdulte, prixEtudiant, time1, typeEvent, image, nbrPlace);
    }

    public int getIdGalerie() {
        return idGalerie;
    }

    public void setIdGalerie(int idGalerie) {
        this.idGalerie = idGalerie;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
    
}
