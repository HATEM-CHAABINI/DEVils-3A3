/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author acer
 */
public class commentaireP {
    private int refp ;
    private String nom_utilisateur ;
    private String comment ;

    public commentaireP() {
    }
    
    

    public commentaireP(int refp, String nom_utilisateur, String comment) {
        this.refp = refp;
        this.nom_utilisateur = nom_utilisateur;
        this.comment = comment;
    }

    public int getRefp() {
        return refp;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public String getComment() {
        return comment;
    }

    public void setRefp(int refp) {
        this.refp = refp;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final commentaireP other = (commentaireP) obj;
        if (this.refp != other.refp) {
            return false;
        }
        if (!Objects.equals(this.nom_utilisateur, other.nom_utilisateur)) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        return true;
    }
    
    
}
