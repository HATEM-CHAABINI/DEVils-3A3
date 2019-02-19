/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Utilisateur;
import Entities.Reclamation;
import javafx.collections.ObservableList;

/**
 *
 * @author Amine
 */
public interface IReclamationService {
    public void addR(Reclamation r ,Utilisateur c);
     public void update(Reclamation r);
      public void update2(int i);
     
      public void remove(Integer r);
    public ObservableList<Reclamation>findByUsername(String s);
  public ObservableList<Reclamation> displayallR();
 public ObservableList<Reclamation> displayencours() ;
 public ObservableList<Reclamation> displayParType(String Type);
    //public ObservableList<Reclamation> displayallR(int i);

    //public ObservableList<String> displayallclientName();

    //public ObservableList<String> displayallclientNameCP();
}
