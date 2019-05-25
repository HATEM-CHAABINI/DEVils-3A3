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
public class Livre {
    private int id;
    private String titre;
    private String auteur;
    private String genre;
    private double prix;
    private int quantite;
    private String description;
    private String image;

    public Livre(String titre, String auteur, String genre, double prix, int quantite, String description, String image) {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.prix = prix;
        this.quantite = quantite;
        this.description = description;
        this.image = image;
    }

    public Livre(int id, String titre, String auteur, String genre, double prix, int quantite, String description, String image) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.prix = prix;
        this.quantite = quantite;
        this.description = description;
        this.image = image;
    }
    

    public Livre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Livre{" + "id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", genre=" + genre + ", prix=" + prix + ", quantite=" + quantite + ", description=" + description + ", image=" + image + '}';
    }
    
}
