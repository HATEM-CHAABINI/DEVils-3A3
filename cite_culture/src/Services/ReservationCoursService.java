/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.MyDB;
import Entities.ReservationCours;
import IServices.IReservationCours;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Farah
 */
public class ReservationCoursService implements IReservationCours
{
    Connection conn;

    public ReservationCoursService() throws ClassNotFoundException{
        this.conn = MyDB.getInstance().getConnexion();
}

    @Override
    public void ajouterReservationCours(ReservationCours r) {
String sql = "INSERT INTO reservation_cours (id_client, id_cours) SELECT '"+r.getId_client()+"','"+r.getId_cours()+"' WHERE NOT EXISTS ( SELECT id_client,id_cours FROM reservation_cours WHERE id_client ='"+r.getId_client()+"' AND id_cours = '"+r.getId_cours()+"' )";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }

    @Override
    public void modifierReservationCours(ReservationCours r, int id)
    {
         String sql = "UPDATE `reservation_cours` SET `id_client`='"+r.getId_client()+"'`id_cours`='"+r.getId_cours()+"' WHERE `id_reservationCours`='"+id+"'";

        
        try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }

    @Override
    public void supprimerReservationCours(int id) {
         String sql="DELETE FROM `reservation_cours` WHERE  `id_reservationCours`='"+id+"' ";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }

    @Override
    public List<ReservationCours> afficherReservationCours() {
        
        List<ReservationCours> List = new ArrayList<>();
            
            String sql = "SELECT * FROM `reservation_cours`";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    ReservationCours a =new ReservationCours();
                    a.setId_reservationCours(rs.getInt("id_reservationCours"));
                    a.setId_client(rs.getInt("id_client"));
                   
                    a.setId_cours(rs.getInt("id_cours"));
                    
                  List.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservationCoursService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return List;        
    }
   
    public int getIdCours(int id) throws SQLException
    { 
        int pr=0;
         String sql = "SELECT id_cours from reservation_cours WHERE id_reservationCours='"+id+"'";

        
       Statement stl = conn.createStatement();
           ResultSet rs =stl.executeQuery(sql);
           rs.next();
           pr= rs.getInt(1);
         // pr2= rs.getString(2);
          rs.close();
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
        
        
                  
            
        
                   return pr;
    }
    
    
    public void modifierNb_Places(int id)
    {
         String sql = "UPDATE `cours` SET `nb_places`=`nb_places`+1 WHERE `id_cours`='"+id+"'";

        
        try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }
   /* public boolean RechercherRes (int id_client,int id_cours)
    {
        String sql = "SELECT * FROM `reservation_cours` WHERE id_client='"+id_client+"' and id_cours='"+id_cours+"'";
        try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    ReservationCours a =new ReservationCours();
                    a.setId_reservationCours(rs.getInt("id_reservationCours"));
                    a.setId_client(rs.getInt("id_client"));
                   
                    a.setId_cours(rs.getInt("id_cours"));
                    
                  List.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservationCoursService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return false;
    }*/
    
    
     
    public void noter(int id_client,int id_cours,int note) {
String sql = "INSERT INTO notecours (id_client, id_cours,note)SELECT '"+id_client+"','"+id_cours+"','"+note+"' WHERE NOT EXISTS ( SELECT id_client,id_cours FROM notecours WHERE id_client ='"+id_client+"' AND id_cours = '"+id_cours+"' )";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }
    
    
    
    
    
}