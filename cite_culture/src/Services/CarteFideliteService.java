/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.CarteFidelite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import Technique.DataSource;
import IServices.ICarteFideliteService;
import Dao.MyDB;
import Entities.Utilisateur;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;




/**
 *
 * @author Nitro
 */
public class CarteFideliteService implements ICarteFideliteService {
   Connection conn;
     
     public CarteFideliteService() throws ClassNotFoundException {
                this.conn = MyDB.getInstance().getConnexion();

    }

    @Override
    public void add(CarteFidelite c) {
         String req = "insert into carte_fidelite (nb_point,date_creation,id_user) values (?,SYSDATE(),?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1,c.getNb_point());
            
        
            
            preparedStatement.setString(2, c.getUser().getUsername());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
           System.err.println("SQLException: " + ex.getMessage());
       
        }
    }
     @Override
    public void remove(Integer r) {
           String req = "delete from carte_fidelite where id_carte_fidelite =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
    @Override
    public ObservableList<CarteFidelite> displayall() {
        ObservableList<CarteFidelite> listeCarte=FXCollections.observableArrayList();
        String req= "select * from carte_fidelite";
        PreparedStatement preparedStatement;
        
        try {
            preparedStatement=conn.prepareStatement(req);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
             CarteFidelite carteFidelite = null;
                try {
                    
                    Utilisateur cl =new UtilisateurService().rechercheUtilisateurParUsername(resultSet.getString(4));
                    System.out.println(cl);
                 
                    carteFidelite = new CarteFidelite(resultSet.getInt(1),resultSet.getInt(2),resultSet.getDate(3), cl);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CarteFideliteService.class.getName()).log(Level.SEVERE, null, ex);
                }
                boolean add = listeCarte.add(carteFidelite);
                
            }
        } catch (SQLException ex) {
           System.err.println("SQLException: " + ex.getMessage());
        }
        return listeCarte;
    }
    
    @Override
    public CarteFidelite findCartebyID(String search) {
                 ObservableList<CarteFidelite> listeCarte=FXCollections.observableArrayList();
        String req= "select * from carte_fidelite where id_user =? ";
        PreparedStatement preparedStatement;
        CarteFidelite c = null;
        try {
            preparedStatement=conn.prepareStatement(req);
            preparedStatement.setString(1, search);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
             
                try {
                     Utilisateur cl =new UtilisateurService().rechercheUtilisateurParUsername(resultSet.getString(4));
                    c = new CarteFidelite(resultSet.getInt(1),resultSet.getInt(2),resultSet.getDate(3), cl);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CarteFideliteService.class.getName()).log(Level.SEVERE, null, ex);
                }
              
                
            }
        } catch (SQLException ex) {
           System.err.println("SQLException: " + ex.getMessage());
        }
        return c;
    }

    @Override
    public void update(String username) {
        
       String req= "UPDATE `carte_fidelite` SET `nb_point`=`nb_point` + 50 where `id_user` = '"+username+"';";
        System.out.println(req);
           PreparedStatement preparedStatement = null;
           try {
           
           
          preparedStatement = conn.prepareStatement(req);
          
             
            preparedStatement.executeUpdate();
       } catch (SQLException ex) {
           System.err.println("SQLException: " + ex.getMessage());
       }
        
    }

}

    
    
