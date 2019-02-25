/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Film;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author mouna dridi
 */
public interface IFilm {
     public void ajouterFilm(Film f);
     public ObservableList<Film> afficherFilm();
     public void modifierFilm(Film f);
     public void supprimerFilm(Film f);
     public int RetourIdEvent(Film f);
     public ObservableList<Film> rechercheFilmParID(int id);

    /**
     *
     * @return
     */
    public  List<Film> tousFilms();
    public  List<Film> tousFilmsParDate(java.sql.Date d);
     public ObservableList<String> affecterSalle();
    // public void modifierEtatSalle();
    
     
}
