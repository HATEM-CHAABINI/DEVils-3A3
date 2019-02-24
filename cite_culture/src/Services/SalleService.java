/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Dao.MyDB;
import Entities.Salle;
import IServices.ISalle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Nitro
 */
public class SalleService implements ISalle{
     Connection conn;
     
     public SalleService() throws ClassNotFoundException {
                this.conn = MyDB.getInstance().getConnexion();

    }
     @Override
    public void ajouterSalle(Salle s) {
        
    String sql = "INSERT INTO `salle`( `type`, `designation`,  `etat`, `limite`)VALUES ('"+s.getType() + "','" + s.getDesignation()+ "','" + s.getEtat() + "','" + s.getLimit() +"');";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
     try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
           
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }
    
    @Override
    public ObservableList<Salle> displayall() {
          
 ObservableList<Salle> listS = FXCollections.observableArrayList();
        try {
            
                 String req4="select * FROM salle ";
          Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
               Salle S = new Salle();
                S.setId_salle(rs.getInt(1));
                S.setDesignation(rs.getString(2));
                S.setType(rs.getString(3));
                S.setEtat(rs.getString(4));
                  S.setLimit(rs.getInt(5));
                   
               
         
                listS.add(S);
            }
            listS.forEach(System.out::println);
            return listS;
        
        } catch (SQLException ex) {
            Logger.getLogger(SalleService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;}

     @Override
 public void SupprimerSalle(int id)
 {

    String sql = "DELETE FROM `salle` where (id_salle ='"+id+"');";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }        
}
     @Override
 public void modify ( int id){
String sql= "UPDATE `salle` SET `etat` = 'reservé' WHERE (id_salle ='"+id+"');";
try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }       
}
 @Override
 public ObservableList<Salle>  rechercheSalleParID(int id)
 {ObservableList<Salle> listS = FXCollections.observableArrayList();
 
        

            

           try {
            
                 String req4="SELECT * FROM salle WHERE id_salle='" + id + "';";
          Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
               Salle S = new Salle();
                S.setId_salle(rs.getInt(1));
                S.setDesignation(rs.getString(2));
                S.setType(rs.getString(3));
                
                S.setEtat(rs.getString(4));
                  S.setLimit(rs.getInt("limite"));
                   
               
         
                listS.add(S);
            }
            listS.forEach(System.out::println);
            return listS;
        
        } catch (SQLException ex) {
            Logger.getLogger(SalleService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
 }
 @Override
    public Salle rechercheSalleParID2(int id) {
          Salle S = new Salle();
             String req4="SELECT * FROM salle WHERE id_salle='" + id + "';";
         try {
             Statement stl = conn.createStatement();
             ResultSet rs = stl.executeQuery(req4);
             
             while (rs.next()) {
                
                 
                S.setId_salle(rs.getInt(1));
                S.setDesignation(rs.getString(2));
                S.setType(rs.getString(3));
                
                S.setEtat(rs.getString(4));
                  S.setLimit(rs.getInt("limite"));
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(SalleService.class.getName()).log(Level.SEVERE, null, ex);
         }

         return S;     
    }
           

}
