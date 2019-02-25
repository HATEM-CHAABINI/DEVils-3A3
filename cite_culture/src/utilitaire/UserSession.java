/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import Entities.Utilisateur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hatem
 */
public class UserSession  {
  
  static  Utilisateur u =new Utilisateur();
    //private static UserSession instance=null;
    public UserSession(){}
    private UserSession (Utilisateur uu) throws ClassNotFoundException {
    
         

            u = uu;
        

       
    }
    public void setUser(Utilisateur uti){
        u=uti;
    
    }
    public void resetUser(){
    
        u=new Utilisateur();
    }
    
   /* public static UserSession getInstance(Utilisateur uu) throws ClassNotFoundException{
        if( instance == null)
            instance = new UserSession(uu);
        
        return instance;
    }*/
    
    public Utilisateur getUser() {
        return u;
    
    } 
    
    
}
    