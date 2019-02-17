/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.publication;
import java.sql.Connection;
import Dao.MyDB;

/**
 *
 * @author acer
 */
public class publication_service {
    Connection conn ;
    public publication_service() throws ClassNotFoundException
    {
        this.conn=MyDB.getInstance().getConnexion();
    }
   /* public void ajouter_publication(publication p)
    {
        String sql = "INSERT INTO `publication`(`reference`, `nompub`, `titre`, `sujet`, `contenu`, `auteur`, `email`) VALUES ('"p.getRef()"','"p.getNom_publication()"','"p.getTitre()"','"p.getSujet()"'
        
        
        
    }*/
    
}
