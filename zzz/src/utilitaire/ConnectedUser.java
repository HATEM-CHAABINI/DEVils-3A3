/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import Entity.Utilisateur;

/**
 *
 * @author hatem
 */
public class ConnectedUser {
    
    private static Utilisateur utilisateur=null;
    
    
    public static void setConnectedUser(Utilisateur c){
    
    utilisateur = c;
    }
    
    public static Utilisateur getConnectedUser(){
     return utilisateur;
    }
    
}
