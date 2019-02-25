/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.article;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Dao.MyDB;

/**
 *
 * @author acer
 */
public class article_service {
    Connection conn ;
    public article_service() throws ClassNotFoundException
    {
        this.conn=MyDB.getInstance().getConnexion();
    }
    
    public void ajouterarticle(article a )
    {
   String sql =   "INSERT INTO `article`(`titre`, `sujet`, `nomauteur`, `mail`, `contenu`, `date`,`etat`) VALUES ('"+a.getTitre_article()+"','"+a.getSujet_article()+"','"+a.getNom_auteur()+"','"+a.getAdresse_mail()+"','"+a.getContenu()+"', SYSDATE(),'non valide');";
 
           //"INSERT INTO `article`(`titre`, `sujet`, `nomauteur`, `mail`, `contenu`, `date`) VALUES("+a.getTitre_article()+ "','" +a.getSujet_article()+"','"+a.getNom_auteur()+"','"+a.getAdresse_mail()+"','"+a.getContenu()+"',SYSDATE());";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            
        } catch (SQLException ex ) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
           
        }
         
    }
    public ObservableList<article>  afficher_article()
    {
        ObservableList<article> listA = FXCollections.observableArrayList();
        try {
            
                 String req4="select * FROM article WHERE etat='non valide' ";
          Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
               article a = new article();
                a.setTitre_article(rs.getString(2));
                a.setSujet_article(rs.getString(3));
                a.setNom_auteur(rs.getString(4));
                  a.setContenu(rs.getString(6));
                   a.setAdresse_mail(rs.getString(5)); 
                   a.setId(rs.getInt(1));
               a.setDate(rs.getDate(7));
         
                listA.add(a);
            }
            listA.forEach(System.out::println);
            return listA;
        
        } catch (SQLException ex) {
            Logger.getLogger(article_service.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;}
    
    public void modifier2(int id )
    {
        String sql="UPDATE `article` SET `etat`= 'valide' WHERE `id` ='"+id+"'";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            
        } catch (SQLException ex ) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
           
        }
    }
    public void supprimerarticle(int id )
    {
        String sql="DELETE FROM `article` WHERE `id` ='"+id+"'";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            
        } catch (SQLException ex ) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
           
        }
    }
    
}
