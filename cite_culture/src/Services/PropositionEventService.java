/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.MyDB;
import Entities.Conference;
import Entities.Film;
import Entities.Evenement;
import Entities.Galerie;
import Entities.PropositionEvent;
import Entities.Theatre;
import IServices.IPFilm;
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
 * @author mouna dridi
 */
public class PropositionEventService implements IPFilm {
        Connection conn;
        
        
        public PropositionEventService() {
        
        try {
            this.conn = MyDB.getInstance().getConnexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @Override
    public void ajouterPEvent(PropositionEvent f) {
         String sql = "INSERT INTO `propositionevent`(`typeEvent`, `description`, `titre`, `etat`, `username`) VALUES  ('"+f.getTypeEvent()+"','"+f.getDescription()+"','"+f.getTitre()+"','"+f.getEtat()+"','"+f.getUsername()+"')";
  
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
    public ObservableList<String> affecterSalle(String type) {
    ObservableList<String> listS = FXCollections.observableArrayList();
    String salle ="";
     String sql="select designation from salle where type ='"+type+"' ";
     try{
         Statement st1 = conn.createStatement();
         ResultSet rs=st1.executeQuery(sql);
         while(rs.next()){
             salle=rs.getString(1);
             listS.add(salle);
         }
         rs.close();
     }catch(SQLException ex)
     {
         System.err.println("SQLException"+ex.getMessage());
     }
    return listS;
    }

    @Override
    public ObservableList<PropositionEvent> afficherPEvent() {
          ObservableList<PropositionEvent> listA = FXCollections.observableArrayList();

try {
            
        String req4="select * FROM propositionevent WHERE etat='non validé'";
            Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
            while(rs.next()){
               PropositionEvent f = new PropositionEvent();
                
                f.setIdPEvent(rs.getInt("idPEvent"));
                f.setTypeEvent(rs.getString("typeEvent"));
                f.setDescription(rs.getString("description"));
                f.setTitre(rs.getString("titre"));
                f.setEtat(rs.getString("etat"));
                f.setUsername(rs.getString("username"));
              
                listA.add(f);
            }
            listA.forEach(System.out::println);
            return listA;
        
        } catch (SQLException ex) {
            Logger.getLogger(PropositionEventService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
    }

    @Override
    public void supprimerPEvent(PropositionEvent f) {
        try {
         String sql = "DELETE FROM `propositionevent` where (idPEvent ='"+f.getIdPEvent()+"');";

            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
           
              
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        } 
        
    }
    

    

    @Override
    public void validerPEvent(Film f) {
      
        
         String sql = "INSERT INTO `evenement`(`titre`, `description`, `dateD`, `dateF`, `salle`, `prixEnfant`, `prixAdulte`, `prixEtudiant`, `time`,`typeEvent`,`image`,`nbrPlace`) VALUES ('"+f.getTitre()+"','"+f.getDescription()+"','"+f.getDateD()+"','"+f.getDateF()+"','"+f.getSalle()+"','"+f.getPrixEnfant()+"','"+f.getPrixAdulte()+"','"+f.getPrixEtudiant()+"','"+f.getTime1()+"','"+f.getTypeEvent()+"','"+f.getImage()+"','"+f.getNbrPlace()+"')";
  
    try {
           PreparedStatement ptl = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ptl.executeUpdate();
            ResultSet generatedKeys = ptl.getGeneratedKeys();
                 generatedKeys.next();
                 
            System.out.println(generatedKeys.getInt(1));

                   
       
    String sql1 = "INSERT INTO `film`(`idEvent`, `trailer`) VALUES ('"+generatedKeys.getInt(1)+"','"+f.getTrailer()+"')";
    
    
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql1);

                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
            System.err.println("sql: " + sql);
        }
    
        
    }

    @Override
    public void setEtatV(PropositionEvent f) {
         String sql1 = "UPDATE propositionevent SET `etat`='validé' WHERE `idPEvent`='"+f.getIdPEvent()+"'";
         
          try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql1);

                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
            System.err.println("sql: " + sql1);
        }
           
    }

    @Override
    public void validerPEvent2(Theatre t) {
String sql = "INSERT INTO `evenement`(`titre`, `description`, `dateD`, `dateF`, `salle`, `prixEnfant`, `prixAdulte`, `prixEtudiant`, `time`,`typeEvent`,`image`,`nbrPlace`) VALUES ('"+t.getTitre()+"','"+t.getDescription()+"','"+t.getDateD()+"','"+t.getDateF()+"','"+t.getSalle()+"','"+t.getPrixEnfant()+"','"+t.getPrixAdulte()+"','"+t.getPrixEtudiant()+"','"+t.getTime1()+"','"+t.getTypeEvent()+"','"+t.getImage()+"','"+t.getNbrPlace()+"')";
  
    try {
           PreparedStatement ptl = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ptl.executeUpdate();
            ResultSet generatedKeys = ptl.getGeneratedKeys();
                 generatedKeys.next();
                 
            System.out.println(generatedKeys.getInt(1));

                   
       
    String sql1 = "INSERT INTO `theatre`(`idEvent`) VALUES ('"+generatedKeys.getInt(1)+"')";
  
    
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql1);

                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
            System.err.println("sql: " + sql);
        }    }

    @Override
    public void validerPEvent3(Conference c) {
String sql = "INSERT INTO `evenement`(`titre`, `description`, `dateD`, `dateF`, `salle`, `prixEnfant`, `prixAdulte`, `prixEtudiant`, `time`,`typeEvent`,`image`,`nbrPlace`) VALUES ('"+c.getTitre()+"','"+c.getDescription()+"','"+c.getDateD()+"','"+c.getDateF()+"','"+c.getSalle()+"','"+c.getPrixEnfant()+"','"+c.getPrixAdulte()+"','"+c.getPrixEtudiant()+"','"+c.getTime1()+"','"+c.getTypeEvent()+"','"+c.getImage()+"','"+c.getNbrPlace()+"')";
  
    try {
           PreparedStatement ptl = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ptl.executeUpdate();
            ResultSet generatedKeys = ptl.getGeneratedKeys();
                 generatedKeys.next();
                 
            System.out.println(generatedKeys.getInt(1));

                   
       
    String sql1 = "INSERT INTO `conference`(`idEvent`) VALUES ('"+generatedKeys.getInt(1)+"')";
  
    
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql1);

                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
            System.err.println("sql: " + sql);
        }     }
    

    

 public void validerPEvent3(Galerie c) {
String sql = "INSERT INTO `evenement`(`titre`, `description`, `dateD`, `dateF`, `salle`, `prixEnfant`, `prixAdulte`, `prixEtudiant`, `time`,`typeEvent`,`image`,`nbrPlace`) VALUES ('"+c.getTitre()+"','"+c.getDescription()+"','"+c.getDateD()+"','"+c.getDateF()+"','"+c.getSalle()+"','"+c.getPrixEnfant()+"','"+c.getPrixAdulte()+"','"+c.getPrixEtudiant()+"','"+c.getTime1()+"','"+c.getTypeEvent()+"','"+c.getImage()+"','"+c.getNbrPlace()+"')";
  
    try {
           PreparedStatement ptl = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ptl.executeUpdate();
            ResultSet generatedKeys = ptl.getGeneratedKeys();
                 generatedKeys.next();
                 
            System.out.println(generatedKeys.getInt(1));

                   
       
    String sql1 = "INSERT INTO `galerie`(`idEvent`) VALUES ('"+generatedKeys.getInt(1)+"')";
  
    
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql1);

                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
            System.err.println("sql: " + sql);
        }     }
    




}
