/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.Entite;

import com.codename1.l10n.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hatem
 */
public class Location {
    private int id;
    private Date date_location;
    private Date date_retour;
    private Utilisateur locataire;
    private Livre livre;
    private String etat;

    public Location() {
    }

    public Location(Date date_location, Date date_retour, Utilisateur locataire, Livre livre, String etat) {
        this.date_location = date_location;
        this.date_retour = date_retour;
        this.locataire = locataire;
        this.livre = livre;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_location() {
        return date_location;
    }

    public void setDate_location(Date date_location) {
        this.date_location = date_location;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }

    public Utilisateur getLocataire() {
        return locataire;
    }

    public void setLocataire(Utilisateur locataire) {
        this.locataire = locataire;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
         SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy");

        
        return "Location{" + "date_location=" + sfd.format(date_location) + ", date_retour=" + sfd.format(date_retour) + ", livre=" + livre.getTitre() + " Prix= " +livre.getPrix()+'}';
    }
    
}
