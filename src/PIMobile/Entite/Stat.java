/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.Entite;

/**
 *
 * @author hatem
 */
public class Stat {
    private int nbLocation;
    private String titre;

    public Stat() {
    }

    public Stat(int nbLocation, String titre) {
        this.nbLocation = nbLocation;
        this.titre = titre;
    }

    public int getNbLocation() {
        return nbLocation;
    }

    public void setNbLocation(int nbLocation) {
        this.nbLocation = nbLocation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Stat{" + "nbLocation=" + nbLocation + ", titre=" + titre + '}';
    }
    
}
