/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author mouna dridi
 */
public class Film extends Evenement{
    private int idFilm;
     private int idEvent;
    private String trailer;
   

   /* public Film(int idEvent,String trailer, String titre, String description, Date dateD, Date dateF, String salle, float prixEnfant, float prixAdulte, float prixEtudiant, String time1, String typeEvent, String image, int nbrPlace) {
        super(titre, description, dateD, dateF, salle, prixEnfant, prixAdulte, prixEtudiant, time1, typeEvent, image, nbrPlace);
        this.idEvent=idEvent;
        this.trailer = trailer;
    }*/

    public Film(){    }
    public Film(Film f){
        this.idFilm=f.getIdFilm();
        this.idEvent=f.getIdEvent();
        this.trailer=f.getTrailer();
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
    public int getIdEvent() {
        return idEvent;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
//public Film(String type,Evenement e){
// super(e.getTitre(),description, dateD, dateF, salle, prixEnfant, prixAdulte, prixEtudiant, time1,"Film", image, nbrPlace);
//        this.trailer = trailer;
//   


//}
    public Film(String trailer, String titre, String description, Date dateD, Date dateF, String salle, float prixEnfant, float prixAdulte, float prixEtudiant, String time1, String image, int nbrPlace) {
        super(titre, description, dateD, dateF, salle, prixEnfant, prixAdulte, prixEtudiant, time1,"Film", image, nbrPlace);
        this.trailer = trailer;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    @Override
    public String toString() {
        return super.toString()+"Film{" + "idFilm=" + idFilm + ", idEvent=" + idEvent + ", trailer=" + trailer + '}';
    }

    
}
