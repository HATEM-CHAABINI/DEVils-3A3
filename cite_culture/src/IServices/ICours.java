/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Cours;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

/**
 *
 * @author Farah
 */
public interface ICours
{
    public void ajouterCours(Cours r);
    public void modifierCours(Cours r,int id);
    public void supprimerCours(int id);
    public ObservableList<Cours> afficherCours();
    public ObservableList<Cours> RechercherCours(int id);
}
