/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.MyDB;
import Entities.Evenement;
import IServices.IEvenement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mouna dridi
 */
public class EvenementService implements IEvenement{
    Connection conn;
    
    public EvenementService() throws ClassNotFoundException{
        this.conn = MyDB.getInstance().getConnexion();
}

    @Override
    public void ajouterEvenement(Evenement e) {
        
         String sql = "INSERT INTO `evenement`( `titre`, `description`, `dateD`, `dateF`, `salle`, `prixEnfant`, `prixAdulte`, `prixEtudiant`, `time`,`typeEvent`,`image`,`nbrPlace`) VALUES ('"+e.getTitre()+"','"+e.getDescription()+"','"+e.getDateD()+"','"+e.getDateF()+"','"+e.getSalle()+"','"+e.getPrixEnfant()+"','"+e.getPrixAdulte()+"','"+e.getPrixEtudiant()+"','"+e.getTime1()+"','"+e.getTypeEvent()+"','"+e.getImage()+"','"+e.getNbrPlace()+"')";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);

                   } catch (SQLException ex) {
            /*System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
            System.err.println("sql: " + sql);*/
        }
           
    }
    
    
    
    
    
}
