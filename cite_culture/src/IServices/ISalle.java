/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Salle;
import javafx.collections.ObservableList;

/**
 *
 * @author Nitro
 */
public interface ISalle {
    public void ajouterSalle(Salle s);
    public void modify(int id);
    public Salle rechercheSalleParID2(int id);
 public ObservableList<Salle> rechercheSalleParID(int id);
 public ObservableList<Salle> displayall(); 
 public void SupprimerSalle(int id);
}
