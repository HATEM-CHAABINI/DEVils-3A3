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
public class Conference extends Evenement {
    private int idConference;
    private int idEvent;

    public Conference(String titre, String description, Date dateD, Date dateF, String salle, float prixEnfant, float prixAdulte, float prixEtudiant, String time1, String image, int nbrPlace) {
        super(titre, description, dateD, dateF, salle, prixEnfant, prixAdulte, prixEtudiant, time1, "Conference", image, nbrPlace);
    }
     public Conference() {
    }
     public Conference(Conference f){
        this.idConference=f.getIdConference();
        this.idEvent=f.getIdEvent();
        this.titre=f.getTitre();
        this.description=f.getDescription();
        this.dateD=f.getDateD();
        this.dateF=f.getDateF();
        this.salle=f.getSalle();
        this.prixEnfant=f.getPrixEnfant();
        this.prixAdulte=f.getPrixAdulte();
        this.prixEtudiant=f.getPrixEtudiant();
        this.time1=f.getTime1();
        this.image=f.getImage();
        this.nbrPlace=f.getNbrPlace();
        this.typeEvent=f.getTypeEvent();
     }

    public int getIdConference() {
        return idConference;
    }

    public void setIdConference(int idConference) {
        this.idConference = idConference;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
    
    
}
