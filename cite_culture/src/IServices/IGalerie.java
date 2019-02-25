/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Galerie;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author mouna dridi
 */
public interface IGalerie {
     public void ajouterGalerie(Galerie t);
     public ObservableList<Galerie> afficherGalerie();
     public void modifierGalerie(Galerie t);
     public void supprimerGalerie(Galerie t);
     public int RetourIdEvent(Galerie t);
     public ObservableList<Galerie> rechercheGalerieParID(int id);

    /**
     *
     * @return
     */
    public  List<Galerie> tousGaleries();
    public  List<Galerie> tousGalerieParDate(java.sql.Date d);
    public ObservableList<String> affecterSalle();

    
}
