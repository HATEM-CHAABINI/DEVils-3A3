/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.publication;
import java.sql.Connection;
import Dao.MyDB;
import Entities.article;

import Entities.commentaireP;
import Entities.note_publication;
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
 * @author acer
 */
public class publication_service {
    Connection conn ;
    public publication_service() throws ClassNotFoundException
    {
        this.conn=MyDB.getInstance().getConnexion();
    }
   public void ajouter_publication(publication p)
    {
        String sql = "INSERT INTO `publication`( `nompub`, `titre`, `sujet`, `contenu`, `auteur`, `email`,`date`) VALUES ('"+p.getNom_publication()+"','"+p.getTitre()+"','"+p.getSujet()+"','"+p.getContenu_pub()+"','"+p.getNom_auteur()+"','"+p.getEmail()+"',SYSDATE())"; 
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            
        } catch (SQLException ex ) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
           
        }
        
        
        
    }
   public ObservableList<publication>  afficher_publication()
    {
        ObservableList<publication> listP = FXCollections.observableArrayList();
        try {
            
                 String req4="select * FROM publication  ";
          Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
               publication p = new publication();
               //p.getTitre(rs.getString(2));
                p.setRef(rs.getInt(1));
                p.setNom_publication(rs.getString(2));
                p.setTitre(rs.getString(3));
                p.setSujet(rs.getString(4));
                 p.setContenu_pub(rs.getString(5));
                  p.setNom_auteur(rs.getString(6));
               //p.setEmail(rs.getString(7));
               p.setDate_publication(rs.getString(8));
         
                listP.add(p);
            }
            listP.forEach(System.out::println);
            return listP;
        
        } catch (SQLException ex) {
            Logger.getLogger(article_service.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;}
   public void modifier_publication(publication p)
   {
       String sql="UPDATE `publication` SET `nompub`= '"+p.getNom_publication()+"' WHERE `reference` ='"+p.getRef()+"'";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            
        } catch (SQLException ex ) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
           
        }
        
   }
        public void supprimer_publication(int ref)
        {
            String sql="DELETE FROM `publication` WHERE `reference` ='"+ref+"'";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            
        } catch (SQLException ex ) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
           
        }
        }
        public void supprimer_note(int ref)
        {
            String sql="DELETE FROM `notep` WHERE `ref_pub` ='"+ref+"'";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            
        } catch (SQLException ex ) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
           
        }
        }
         public void supprimer_comm(int ref)
        {
            String sql="DELETE FROM `commentairep` WHERE `ref_pub` ='"+ref+"'";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            
        } catch (SQLException ex ) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
           
        }
        }
         public List<publication>  afficher_details_publication()
    {
        List<publication> listP = new ArrayList<>();
        try {
            
                 String req4="select * FROM publication  ";
          Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
               publication p = new publication();
               //p.getTitre(rs.getString(2));
                p.setRef(rs.getInt(1));
                p.setNom_publication(rs.getString(2));
                p.setTitre(rs.getString(3));
                p.setSujet(rs.getString(4));
                 p.setContenu_pub(rs.getString(5));
                  p.setNom_auteur(rs.getString(6));
               //p.setEmail(rs.getString(7));
               p.setDate_publication(rs.getString(8));
         
                listP.add(p);
            }
            listP.forEach(System.out::println);
           
        
        } catch (SQLException ex) {
            Logger.getLogger(article_service.class.getName()).log(Level.SEVERE, null, ex);
        } 
     return listP;
     }
         public void ajout_commentaire(commentaireP cp)
         {
            String sql = "INSERT INTO `commentairep`( `ref_pub`, `username`, `commentaire`) VALUES ('"+cp.getRefp()+"','"+cp.getNom_utilisateur()+"','"+cp.getComment()+"')";
             try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            
        } catch (SQLException ex ) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
           
        }
         }
         
          public ObservableList<commentaireP>afficher_commentaire(int ref)
    {
        List<commentaireP> listC = FXCollections.observableArrayList();
        try {
            
                 String req4="select * FROM commentairep as c,publication as p  where c.ref_pub ='"+ref+"' and c.ref_pub=p.reference ";
          Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
               commentaireP cp =new commentaireP();
               //p.getTitre(rs.getString(2));
                cp.setNom_utilisateur(rs.getString(3));
                cp.setComment(rs.getString(4));
         
                listC.add(cp);
            }
            listC.forEach(System.out::println);
            return (ObservableList<commentaireP>) listC;
        
        } catch (SQLException ex) {
            Logger.getLogger(article_service.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;}
          public List<String> badwordss() throws SQLException
          {
              try{
              List<String> listb = new ArrayList<>();
              String req4 = "select `badword` from badwords";
              Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
            while(rs.next())
            {
               // badwords bd = new badwords();
                listb.add(rs.getString("badword").toUpperCase());
               
               
            }
 return listb ;
              }catch(SQLException ex){
                  
              }
            return null;
            
          }
          public void noter(note_publication n)
          {
              String sql ="INSERT INTO `notep`( `ref_pub`, `username`, `note`) VALUES ('"+n.getRef_pub()+"','"+n.getNomutilisateur()+"',1)";
               try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            
        } catch (SQLException ex ) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
           
        }
          }
          public int affiche_note(int id )
          {
              int i=0;
              String sql="SELECT COUNT(*) FROM `notep` WHERE note=1 and ref_pub='"+id+"'";
               try {
            Statement stl = conn.createStatement();
            stl.executeQuery(sql);
             ResultSet rs = stl.executeQuery(sql);
            while(rs.next())
            {
                i=rs.getInt(1);
            }
           
        } catch (SQLException ex ) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
           
        }
               
               return i ;
          }
                
}
         
    

