/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import java.sql.Date;
import javafx.collections.ObservableList;

import Entities.Utilisateur;
import Entities.Winner;
import java.util.List;

/**
 *
 * @author bn
 */
public interface IWinnerService  {
    
      int findbydate(String date);
    Winner findbyusername(int userId);
    int winnerOfTheDay();
    Date maxwinnerdate ();
     String identifywithrole( String r);
      public void add(Winner t);
      public List<Winner> getAll();
     
      public ObservableList<Winner> displayall();
   
    
}
