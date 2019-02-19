/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Dao.MyDB;
import Entities.Tache;
import IServices.ITache;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class TacheService implements ITache{
     Connection conn;
     
     public TacheService() throws ClassNotFoundException {
                this.conn = MyDB.getInstance().getConnexion();

    }

    @Override
    public void ajouterTache(Tache t) {
           
    String sql = "INSERT INTO `tache`(  `id_employé`,`id_rec`,  `description`)VALUES ('" + t.getId_employe()+ "','" + t.getId_rec()+ "','" + t.getDesc()+ "');";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
     try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
           
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }

    @Override
    public void modify(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public ObservableList<Tache> rechercheTacheParID(int id) {
        ObservableList<Tache> listeuser = FXCollections.observableArrayList();
        String req = "SELECT * FROM `tache` WHERE `id_employé` ='"+id+"';";
       // System.out.println(req);
        PreparedStatement preparedStatement;

        try {
            preparedStatement = conn.prepareStatement(req);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Tache r = new Tache(resultSet.getInt("id_tache"),resultSet.getInt("id_rec"),resultSet.getInt("id_employé"), resultSet.getString("description"));
                //System.out.println(r);
                listeuser.add(r);

            }
        } catch (SQLException ex) {
           System.err.println("SQLException: " + ex.getMessage());
        }
        return listeuser;
    }

    @Override
    public ObservableList<Tache> displayall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
     
     
     
}
