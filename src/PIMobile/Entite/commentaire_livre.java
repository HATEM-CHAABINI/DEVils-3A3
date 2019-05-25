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
public class commentaire_livre {
        
    private int id;
    private String Commentaire;
    private Utilisateur locataire;
    private Livre livre;

    public commentaire_livre() {
    }

    public commentaire_livre(int id, String Commentaire, Utilisateur locataire, Livre livre) {
        this.id = id;
        this.Commentaire = Commentaire;
        this.locataire = locataire;
        this.livre = livre;
    }

    public commentaire_livre(String Commentaire, Utilisateur locataire, Livre livre) {
        this.Commentaire = Commentaire;
        this.locataire = locataire;
        this.livre = livre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
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

    @Override
    public String toString() {
        return "commentaire_livre{" + "id=" + id + ", Commentaire=" + Commentaire + ", locataire=" + locataire + ", livre=" + livre + '}';
    }
    
}
