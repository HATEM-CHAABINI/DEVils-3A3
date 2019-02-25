/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.MyDB;
import Entities.Evenement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mouna dridi
 */
public class RatingService {
    Connection conn;
    public RatingService() {
        
        try {
            this.conn = MyDB.getInstance().getConnexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    
    public void ajouterRate(int id,int idEvent,int rate) {
        
         String sql = "INSERT INTO `rating`( `id`, `idEvent`, `rate`) VALUES ('"+id+"','"+idEvent+"','"+rate+"')";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);

                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
            System.err.println("sql: " + sql);
        }
           
    }
    
    
    public float calculer(int id)
    {
        float moy=0;
         String sql = "select AVG (`rate`) as rating FROM `rating` where `idEvent`='"+id+"'";
  
    try {
            Statement stl = conn.createStatement();
           ResultSet rs =stl.executeQuery(sql);
            
                rs.next();
                moy=rs.getFloat(1);
                rs.close();
            
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
            System.err.println("sql: " + sql);
        
                   }
    return moy;
    
    }
    
}
