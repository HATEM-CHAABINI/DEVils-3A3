/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.MyDB;
import Entities.Film;
import IServices.IFilm;
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
public class FilmService implements IFilm {
    
    Connection conn;
    
    public FilmService() {
        
        try {
            this.conn = MyDB.getInstance().getConnexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @Override
    public void ajouterFilm(Film f) {
        
        
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
 public  List<Film> tousFilms(){
                 List<Film> l=new ArrayList<>();
                 
        try {
            String sql="select * from evenement";
            
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Film f=new Film();
                f.setImage(rs.getString("image"));
                f.setDateD(rs.getDate("dateD"));
                f.setDateF(rs.getDate("dateF"));
                f.setPrixEnfant(rs.getFloat("prixEnfant"));
                f.setIdEvent(rs.getInt("idEvent"));
                f.setTime1(rs.getString("time"));
                f.setDescription(rs.getString("description"));
                f.setNbrPlace(rs.getInt("nbrPlace"));
                String trsql="select trailer from film where idEvent='"+f.getIdEvent()+"'";
                Statement st2=conn.createStatement();
            ResultSet rsss=st2.executeQuery(trsql);
            while(rsss.next()){
               f.setTrailer(rsss.getString("trailer"));
            }
               l.add(f);
                        }  } catch (SQLException ex) {
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return l; 
 }   
    @Override
    public ObservableList<Film> afficherFilm() {
                ObservableList<Film> listA = FXCollections.observableArrayList();

try {
            
            String req4="select * FROM film as f, evenement as e where f.idEvent=e.idEvent and e.typeEvent='Film'";
            Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
            while(rs.next()){
               Film f = new Film();
                
                f.setIdFilm(rs.getInt("idFilm"));
                f.setIdEvent(rs.getInt("idEvent"));
                f.setTrailer(rs.getString("trailer"));
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
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;    }

    
    
    @Override
    public void modifierFilm(Film f) {
 
         try {
         
            
  f.setIdEvent(RetourIdEvent(f));
             
         String sql ="UPDATE `evenement` SET `titre`='"+f.getTitre() + "',`description`='"+f.getDescription() + "',`dateD`='"+f.getDateD() + "',`dateF`='"+f.getDateF() + "',`salle`='"+f.getSalle() + "',`prixEnfant`='"+f.getPrixEnfant() + "',`prixAdulte`='"+f.getPrixAdulte() + "',`prixEtudiant`='"+f.getPrixEtudiant() + "',`time`='"+f.getTime1() + "',`typeEvent`='"+f.getTypeEvent() + "',`image`='"+f.getImage() + "',`nbrPlace`='"+f.getNbrPlace() + "' WHERE `idEvent`='"+f.getIdEvent()+"' ";
         String sql1 = "UPDATE film SET `trailer`='"+f.getTrailer()+"' WHERE `idEvent`='"+f.getIdEvent()+"'";

             Statement stl = conn.createStatement();
           int rsn =stl.executeUpdate(sql);
   Statement stl2 = conn.createStatement();
           int rsb =stl2.executeUpdate(sql1);
 
            
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
       //     System.err.println("sql: " + sql);
        }
             }

    @Override
    public void supprimerFilm(Film f) {
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  int idEvent= RetourIdEvent(f);
    try {
         String sql = "DELETE FROM `film` where (idEvent ='"+idEvent+"');";

            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
           
               String sql2 = "DELETE FROM `evenement` where (idEvent ='"+idEvent+"');";

            Statement stl2 = conn.createStatement();
           int rs1 =stl2.executeUpdate(sql2);
       
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }            }

    @Override
    public int RetourIdEvent(Film f) {
         String sql2="select idEvent from film where idFilm='"+f.getIdFilm()+"';";
 
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


 return i;
}

    @Override
    public ObservableList<Film> rechercheFilmParID(int id) {
ObservableList<Film> listF = FXCollections.observableArrayList();
 Film s = new Film();
        

            

           try {
            
            String req4="select * FROM film as f, evenement as e where f.idEvent=e.idEvent  and f.idFilm='"+id+"'";
            Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
                Film f = new Film();
                f.setIdFilm(rs.getInt("idFilm"));
                f.setIdEvent(rs.getInt("idEvent"));
                f.setTrailer(rs.getString("trailer"));
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
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;    }

    @Override
    public List<Film> tousFilmsParDate(Date d) {
       List<Film> l=new ArrayList<>();
                 
        try {
            String sql="select * from evenement where dateD ='"+d+"'";
            
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Film f=new Film();
                f.setImage(rs.getString("image"));
                f.setDateD(rs.getDate("dateD"));
                f.setDateF(rs.getDate("dateF"));
                f.setPrixEnfant(rs.getFloat("prixEnfant"));
                f.setIdEvent(rs.getInt("idEvent"));
                f.setTime1(rs.getString("time"));
                f.setDescription(rs.getString("description"));
                f.setNbrPlace(rs.getInt("nbrPlace"));
                String trsql="select trailer from film where idEvent='"+f.getIdEvent()+"'";
                Statement st2=conn.createStatement();
            ResultSet rsss=st2.executeQuery(trsql);
            while(rsss.next()){
               f.setTrailer(rsss.getString("trailer"));
            }
               l.add(f);
                        }  } catch (SQLException ex) {
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return l;     }
 }
    


