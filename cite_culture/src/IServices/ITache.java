/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Tache;
import javafx.collections.ObservableList;

/**
 *
 * @author Nitro
 */
public interface ITache {
    public void ajouterTache(Tache t);
    public void modify(int id);
 public ObservableList<Tache> rechercheTacheParID(int id);
   // public ObservableList<Tache> rechercheSalleParID(int id);
    public ObservableList<Tache> displayall(); 
    //public void SupprimerSalle(int id);
}
