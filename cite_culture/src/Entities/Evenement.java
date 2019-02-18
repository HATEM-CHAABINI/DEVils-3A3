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
public class Evenement {
    protected int idEvent;
    protected String titre;
    protected String description;
    protected Date dateD;
    protected Date dateF;
    protected String salle;
    protected float prixEnfant;
    protected float prixAdulte;
    protected float prixEtudiant;
    protected String time1;
    protected String typeEvent;
    protected String image;
    protected int nbrPlace;

    public Evenement() {
    }

    
    public Evenement(String titre, String description, Date dateD, Date dateF, String salle, float prixEnfant, float prixAdulte, float prixEtudiant, String time1, String typeEvent, String image, int nbrPlace) {
        this.titre = titre;
        this.description = description;
        this.dateD = dateD;
        this.dateF = dateF;
        this.salle = salle;
        this.prixEnfant = prixEnfant;
        this.prixAdulte = prixAdulte;
        this.prixEtudiant = prixEtudiant;
        this.time1 = time1;
        this.typeEvent = typeEvent;
        this.image = image;
        this.nbrPlace = nbrPlace;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateD() {
        return dateD;
    }

    public Date getDateF() {
        return dateF;
    }

    public String getSalle() {
        return salle;
    }

    public float getPrixEnfant() {
        return prixEnfant;
    }

    public float getPrixAdulte() {
        return prixAdulte;
    }

    public float getPrixEtudiant() {
        return prixEtudiant;
    }

    public String getTime1() {
        return time1;
    }

    public String getTypeEvent() {
        return typeEvent;
    }

    public String getImage() {
        return image;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateD(Date dateD) {
        this.dateD = dateD;
    }

    public void setDateF(Date dateF) {
        this.dateF = dateF;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public void setPrixEnfant(float prixEnfant) {
        this.prixEnfant = prixEnfant;
    }

    public void setPrixAdulte(float prixAdulte) {
        this.prixAdulte = prixAdulte;
    }

    public void setPrixEtudiant(float prixEtudiant) {
        this.prixEtudiant = prixEtudiant;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public void setTypeEvent(String typeEvent) {
        this.typeEvent = typeEvent;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idEvent=" + idEvent + ", titre=" + titre + ", description=" + description + ", dateD=" + dateD + ", dateF=" + dateF + ", salle=" + salle + ", prixEnfant=" + prixEnfant + ", prixAdulte=" + prixAdulte + ", prixEtudiant=" + prixEtudiant + ", time1=" + time1 + ", typeEvent=" + typeEvent + ", image=" + image + ", nbrPlace=" + nbrPlace + '}';
    }
    
}
