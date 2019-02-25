/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.MyDB;
import Entities.Conference;
import Entities.Theatre;
import IServices.IConference;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mouna dridi
 */
public class ConferenceService implements IConference{
    Connection conn;
    
    public ConferenceService() {
        
        try {
            this.conn = MyDB.getInstance().getConnexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConferenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @Override
    public void ajouterConference(Conference t) {
String sql = "INSERT INTO `evenement`(`titre`, `description`, `dateD`, `dateF`, `salle`, `prixEnfant`, `prixAdulte`, `prixEtudiant`, `time`,`typeEvent`,`image`,`nbrPlace`) VALUES ('"+t.getTitre()+"','"+t.getDescription()+"','"+t.getDateD()+"','"+t.getDateF()+"','"+t.getSalle()+"','"+t.getPrixEnfant()+"','"+t.getPrixAdulte()+"','"+t.getPrixEtudiant()+"','"+t.getTime1()+"','"+t.getTypeEvent()+"','"+t.getImage()+"','"+t.getNbrPlace()+"')";
  
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
        }    }

    @Override
    public ObservableList<Conference> afficherConference() {
ObservableList<Conference> listA = FXCollections.observableArrayList();

try {
            
            String req4="select * FROM conference as t, evenement as e where t.idEvent=e.idEvent and e.typeEvent='Conference'";
            Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
            while(rs.next()){
               Conference f = new Conference();
                
                f.setIdConference(rs.getInt("idConference"));
                f.setIdEvent(rs.getInt("idEvent"));
                f.setTitre(rs.getString("titre"));
                f.setDescription(rs.getString("description"));
                f.setDateD(rs.getDate("dateD")); 
                f.setDateF(rs.getDate("dateF"));
                f.setSalle(rs.getString("salle"));
                f.setPrixEnfant(rs.getFloat("prixEnfant"));
                f.setPrixAdulte(rs.getFloat("prixAdulte"));
                f.setPrixEtudiant(rs.getFloat("prixEtudiant"));
                f.setTime1(rs.getString("time"));
                f.setTypeEvent(rs.getString("typeEvent"));
                f.setImage(rs.getString("image"));
                f.setNbrPlace(rs.getInt("nbrPlace"));
         
                listA.add(f);
            }
            listA.forEach(System.out::println);
            return listA;
        
        } catch (SQLException ex) {
            Logger.getLogger(ConferenceService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;    }

    @Override
    public void modifierConference(Conference t) {
try {
         
            
  t.setIdEvent(RetourIdEvent(t));
             
         String sql ="UPDATE `evenement` SET `titre`='"+t.getTitre() + "',`description`='"+t.getDescription() + "',`dateD`='"+t.getDateD() + "',`dateF`='"+t.getDateF() + "',`salle`='"+t.getSalle() + "',`prixEnfant`='"+t.getPrixEnfant() + "',`prixAdulte`='"+t.getPrixAdulte() + "',`prixEtudiant`='"+t.getPrixEtudiant() + "',`time`='"+t.getTime1() + "',`typeEvent`='"+t.getTypeEvent() + "',`image`='"+t.getImage() + "',`nbrPlace`='"+t.getNbrPlace() + "' WHERE `idEvent`='"+t.getIdEvent()+"' ";
         //String sql1 = "UPDATE `theatre` WHERE idEvent='"+t.getIdEvent()+"'";

             Statement stl = conn.createStatement();
           int rsn =stl.executeUpdate(sql);
//   Statement stl2 = conn.createStatement();
//           int rsb =stl2.executeUpdate(sql1);
 
            
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
       //     System.err.println("sql: " + sql);
        }    }

    @Override
    public void supprimerConference(Conference t) {
int idEvent= RetourIdEvent(t);
    try {
         String sql = "DELETE FROM `conference` where (idEvent ='"+idEvent+"');";

            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
           
               String sql2 = "DELETE FROM `evenement` where (idEvent ='"+idEvent+"');";

            Statement stl2 = conn.createStatement();
           int rs1 =stl2.executeUpdate(sql2);
       
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
                }    }

    @Override
    public int RetourIdEvent(Conference t) {
String sql2="select idEvent from conference where idConference='"+t.getIdConference()+"';";
 
         int i = 0;
         try {
            Statement st = conn.createStatement();
            st.executeQuery(sql2);
            ResultSet rs = st.executeQuery(sql2);
                      while(rs.next()){

            i= (rs.getInt("idEvent"));
                      }
    }   
         catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
       //     System.err.println("sql: " + sql);
        }


 return i;    }

    @Override
    public ObservableList<Conference> rechercheConferenceParID(int id) {
ObservableList<Conference> listF = FXCollections.observableArrayList();
 Conference s = new Conference();
        

            

           try {
            
            String req4="select * FROM conference as t, evenement as e where t.idEvent=e.idEvent  and t.idConference='"+id+"'";
            Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
                Conference f = new Conference();
                f.setIdConference(rs.getInt("idConference"));
                f.setIdEvent(rs.getInt("idEvent"));
                f.setTitre(rs.getString("titre"));
                f.setDescription(rs.getString("description"));
                f.setDateD(rs.getDate("dateD")); 
                f.setDateF(rs.getDate("dateF"));
                f.setSalle(rs.getString("salle"));
                f.setPrixEnfant(rs.getFloat("prixEnfant"));
                f.setPrixAdulte(rs.getFloat("prixAdulte"));
                f.setPrixEtudiant(rs.getFloat("prixEtudiant"));
                f.setTime1(rs.getString("time"));
                f.setTypeEvent(rs.getString("typeEvent"));
                f.setImage(rs.getString("image"));
                f.setNbrPlace(rs.getInt("nbrPlace"));
                listF.add(f);
            }
            listF.forEach(System.out::println);
            return listF;
        
        } catch (SQLException ex) {
            Logger.getLogger(ConferenceService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;         }

    @Override
    public List<Conference> tousConferences() {
List<Conference> l=new ArrayList<>();
                 
        try {
            String sql="SELECT * FROM `evenement` WHERE `typeEvent` ='Conference'  ";
            
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Conference f=new Conference();
                f.setTitre(rs.getString("titre"));
                f.setImage(rs.getString("image"));
                f.setDateD(rs.getDate("dateD"));
                f.setDateF(rs.getDate("dateF"));
                f.setPrixEnfant(rs.getFloat("prixEnfant"));
                f.setIdEvent(rs.getInt("idEvent"));
                f.setTime1(rs.getString("time"));
                f.setDescription(rs.getString("description"));
                f.setNbrPlace(rs.getInt("nbrPlace"));
//                Statement st2=conn.createStatement();
//            ResultSet rsss=st2.executeQuery(trsql);
//            while(rsss.next()){
//               f.setTrailer(rsss.getString("trailer"));
//            }
               l.add(f);
                        }  } catch (SQLException ex) {
            Logger.getLogger(ConferenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return l;        }

    @Override
    public List<Conference> tousConferencesParDate(Date d) {
List<Conference> l=new ArrayList<>();
                 
        try {
            String sql="select * from evenement where dateD ='"+d+"' and typeEvent='Conference'";
            
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Conference f=new Conference();
                f.setImage(rs.getString("image"));
                f.setTitre(rs.getString("titre"));
                f.setDateD(rs.getDate("dateD"));
                f.setDateF(rs.getDate("dateF"));
                f.setPrixEnfant(rs.getFloat("prixEnfant"));
                f.setIdEvent(rs.getInt("idEvent"));
                f.setTime1(rs.getString("time"));
                f.setDescription(rs.getString("description"));
                f.setNbrPlace(rs.getInt("nbrPlace"));
               
               l.add(f);
                        }  } catch (SQLException ex) {
            Logger.getLogger(ConferenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return l;    }

    @Override
    public ObservableList<String> affecterSalle() {
ObservableList<String> listS = FXCollections.observableArrayList();
    String salle ="";
     String sql="select designation from salle where type ='Conference' and etat='Libre' ";
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
    return listS;    }
    
    
    public int NbrPlace(String designation){
    int place=0;
    String sql="select limite from salle where designation='"+designation+"'";
     try{
         Statement st1 = conn.createStatement();
         ResultSet rs=st1.executeQuery(sql);
         while(rs.next()){
            place=rs.getInt("limite");
          
         }
         rs.close();
     }catch(SQLException ex)
     {
         System.err.println("SQLException"+ex.getMessage());
     }
    return place;
    }
    
}
