/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;


import Entities.Film;
import Entities.PropositionEvent;
import javafx.collections.ObservableList;

/**
 *
 * @author mouna dridi
 */
public interface IPFilm {
    public void ajouterPEvent(PropositionEvent f);
    public ObservableList<PropositionEvent> afficherPEvent();
    public void supprimerPEvent(PropositionEvent f);
    public void validerPEvent(Film f);
    public void setEtatV(PropositionEvent f);
    
}
