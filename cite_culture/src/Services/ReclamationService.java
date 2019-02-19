/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Dao.MyDB;
import Entities.Utilisateur;
import Entities.Reclamation;
import IServices.IReclamationService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
/**
 *
 * @author Amine
 */
public class ReclamationService implements IReclamationService {

    Connection conn;
     
     public ReclamationService() throws ClassNotFoundException {
                this.conn = MyDB.getInstance().getConnexion();

    }

    @Override
    public void addR(Reclamation r,  Utilisateur c) {
         String sql = "INSERT INTO `reclamation` ( `type`, `text`, `username_client`, `nom_client`, `prenom_client`, `tel`, `mail`, `etat`)VALUES ('"+r.getType() + "','" + r.getText() + "','" + c.getUsername()+"','" + c.getNom()+"','" + c.getPrenom()+"','" + c.getTelephone()+"','" + c.getEmail()+"',+'Notifié');";
        
       try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
           
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }
        @Override
                public void update2(int i)
                { String req = "update reclamation set etat='En cours'  where id_reclamation ='"+i+"';";
                try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(req);
           
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
                }
    

    @Override
    public void update(Reclamation r) {
        String req = "update reclamation set type=?,text=?  where id_reclamation = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            
            preparedStatement.setString(1, r.getType());

            preparedStatement.setString(2, r.getText());
            preparedStatement.setInt(3, r.getId_reclamation());
          
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }


    @Override
    public void remove(Integer r) {
        String req = "delete from reclamation where id_reclamation =?";
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
     public ObservableList<Reclamation>findByUsername(String s) {
        ObservableList<Reclamation> listR = FXCollections.observableArrayList();
       
        String req = "select type,text,etat from reclamation where username_client =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
               while (resultSet.next()) {
                Reclamation r = new Reclamation( resultSet.getString("type"), resultSet.getString("text"),resultSet.getString("etat") );

                listR.add(r);

            }
        } catch (SQLException ex) {
           System.err.println("SQLException: " + ex.getMessage());
        }
        return listR;

    }
    
    @Override
    public ObservableList<Reclamation> displayallR() {
        ObservableList<Reclamation> listeuser = FXCollections.observableArrayList();
        String req = "select * from reclamation";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = conn.prepareStatement(req);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reclamation r = new Reclamation(resultSet.getInt("id_reclamation"), resultSet.getString("type"), resultSet.getString("text"),resultSet.getString("username_client"),resultSet.getString("nom_client"),resultSet.getString("prenom_client"),resultSet.getInt("tel"),resultSet.getString("mail"),resultSet.getString("etat") );

                listeuser.add(r);

            }
        } catch (SQLException ex) {
           System.err.println("SQLException: " + ex.getMessage());
        }
        return listeuser;

    }

  @Override
    public ObservableList<Reclamation> displayencours() {
        ObservableList<Reclamation> listeuser = FXCollections.observableArrayList();
        String req = "select * from reclamation where etat= 'Notifié'";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = conn.prepareStatement(req);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reclamation r = new Reclamation(resultSet.getInt("id_reclamation"), resultSet.getString("type"), resultSet.getString("text"),resultSet.getString("username_client"),resultSet.getString("nom_client"),resultSet.getString("prenom_client"),resultSet.getInt("tel"),resultSet.getString("mail"),resultSet.getString("etat") );

                listeuser.add(r);

            }
        } catch (SQLException ex) {
           System.err.println("SQLException: " + ex.getMessage());
        }
        return listeuser;

    }
     @Override
    public ObservableList<Reclamation> displayParType(String type) {
        ObservableList<Reclamation> listeuser = FXCollections.observableArrayList();
        String req = "select * from reclamation where type= ?";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = conn.prepareStatement(req);
             preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reclamation r = new Reclamation(resultSet.getInt("id_reclamation"), resultSet.getString("type"), resultSet.getString("text"),resultSet.getString("username_client"),resultSet.getString("nom_client"),resultSet.getString("prenom_client"),resultSet.getInt("tel"),resultSet.getString("mail"),resultSet.getString("etat") );

                listeuser.add(r);

            }
        } catch (SQLException ex) {
           System.err.println("SQLException: " + ex.getMessage());
        }
        return listeuser;

    }

   
  
}

//   @Override
//    public ObservableList<Reclamation> displayallR(int i) {
//        ObservableList<Reclamation> listeuser = FXCollections.observableArrayList();
//        String req = "select * from reclamation where id_P_reclame=?";
//        PreparedStatement preparedStatement;
//
//        try {
//            preparedStatement = conn.prepareStatement(req);
//            preparedStatement.setInt(1, i);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Reclamation r = new Reclamation(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), new UserService().findById(resultSet.getInt(4)), new UserService().findById(resultSet.getInt(5)));
//
//                listeuser.add(r);
//
//            }
//        } catch (SQLException ex) {
//            System.err.println("SQLException: " + ex.getMessage());
//        }
//        return listeuser;
//    }

//    @Override
//    public List<Reclamation> getAll() {
//        List<Reclamation> reclamations = new ArrayList<>();
//
//        String req = "select * from reclamation";
//        PreparedStatement preparedStatement;
//        try {
//            preparedStatement = conn.prepareStatement(req);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Reclamation reclamation = new Reclamation(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), new UserService().findById(resultSet.getInt(4)), new UserService().findById(resultSet.getInt(5)));
//
//                reclamations.add(reclamation);
//            }
//        } catch (SQLException ex) {
//           System.err.println("SQLException: " + ex.getMessage());
//        }
//        return reclamations;
//    }

   
 
//    @Override
//    public ObservableList<String> displayallclientName() {
//        IUserService ius = new UserService();
//        ObservableList<String> listeuser = FXCollections.observableArrayList();
//        String req = "select * from reclamation ";
//        PreparedStatement preparedStatement;
//
//        try {
//            preparedStatement = connection.prepareStatement(req);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Reclamation r = new Reclamation(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), new UserService().findById(resultSet.getInt(4)), new UserService().findById(resultSet.getInt(5)));
//
//                listeuser.add(r.getUserreclamant().getNom() + " " + r.getUserreclamant().getPrenom());
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BoutiqueService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return listeuser;
//    }
//
//    @Override
//    public ObservableList<String> displayallclientNameCP() {
//        IUserService ius = new UserService();
//        ObservableList<String> listeuser = FXCollections.observableArrayList();
//        String req = "select * from reclamation where id_P_reclame=?";
//        PreparedStatement preparedStatement;
//
//        try {
//            preparedStatement = connection.prepareStatement(req);
//            preparedStatement.setInt(1, LoginController.LoggedUser.getId_user());
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//
//                Reclamation r = new Reclamation(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), new UserService().findById(resultSet.getInt(4)), new UserService().findById(resultSet.getInt(5)));
//
//                listeuser.add(r.getUserreclamant().getNom() + " " + r.getUserreclamant().getPrenom());
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BoutiqueService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return listeuser;
//    }


