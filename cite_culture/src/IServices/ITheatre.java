/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Theatre;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author mouna dridi
 */
public interface ITheatre {
     public void ajouterTheatre(Theatre t);
     public ObservableList<Theatre> afficherTheatre();
     public void modifierTheatre(Theatre t);
     public void supprimerTheatre(Theatre t);
     public int RetourIdEvent(Theatre t);
     public ObservableList<Theatre> rechercheTheatreParID(int id);

    /**
     *
     * @return
     */
    public  List<Theatre> tousTheatres();
    public  List<Theatre> tousTheatresParDate(java.sql.Date d);
    public ObservableList<String> affecterSalle();
     
    
}
