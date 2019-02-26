/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.MyDB;
import Entities.Cours;
import Entities.MesReservations;
import IServices.ICours;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;

/**
 *
 * @author Farah
 */
public class CoursService implements ICours
{

    Connection conn;

    public CoursService() throws ClassNotFoundException{
        this.conn = MyDB.getInstance().getConnexion();
}
    @Override
    public void ajouterCours(Cours r) {
   String sql = "INSERT INTO `cours`(`type`, `id_prof`, `nb_places`, `id_salle`, `date`, `heureDebut`, `heureFin`, `prix`, `image`) VALUES ('"+r.getType()+ "','" + r.getId_prof()+ "','" + r.getNb_places() + "','" + r.getId_salle() + "','" + r.getDate()+ "','" + r.getHeure_debut()+ "','" + r.getHeure_fin()+ "','" + r.getPrix()+ "','" + r.getImage()+ "')";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
           
    }/*
    
    @Override
    public void modifierReservation(Reservation r,int id) {
   String sql = "UPDATE `reservation` SET `date_reservation`='"+r.getDate_reservation() + "',`nom_evenement`='"+r.getNom_evenement() + "',`type_evenement`='"+r.getType_evenement() + "',`nom`='"+r.getNom() + "',`prenom`='"+r.getPrenom() + "',`mail`='"+r.getMail() + "',`telephone`='"+r.getTelephone() + "',`prix`='"+r.getPrix() + "',`siege`='"+r.getSiege() + "',`QR`='"+r.getQr() + "' WHERE `id_reservation`='"+id+"'";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
           
    }
    
    
    public void supprimerReservation(int id) {
String sql="DELETE FROM `reservation` WHERE  `id_reservation`='"+id+"' ";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
           
    }
    
    
    
     public List<Reservation> afficherReservation() {

        List<Reservation> list = new ArrayList<>();
        try {
            Statement stl = conn.createStatement();
            
            String req = "SELECT * from reservation";
            ResultSet res;
            res = stl.executeQuery(req);
            while (res.next()) {
                Reservation v1 = new Reservation(res.getDate("date_reservation"), res.getString ("nom_evenement"), res.getString ("type_evenement"), res.getString("nom") , res.getString("prenom"), res.getString ("mail"), res.getString("telephone"), res.getFloat("prix"), res.getString("siege"),res.getString("QR"));
                list.add(v1);
              
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    */

    @Override
    public void modifierCours(Cours r, int id) {
        
      
           String sql = "UPDATE `cours` SET `type`='"+r.getType() +"',`id_prof`='"+r.getId_prof() +"',`nb_places`='"+r.getNb_places() +"',`id_salle`='"+r.getId_salle()+"',`date`='"+r.getDate()+"',`heureDebut`='"+r.getHeure_debut()+"',`heureFin`='"+r.getHeure_fin()+"',`prix`='"+r.getPrix()+"',`image`='"+r.getImage()+"' WHERE `id_cours`='"+id+"'";

        
        try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }

    @Override
    public void supprimerCours(int id) {
        String sql="DELETE FROM `cours` WHERE  `id_cours`='"+id+"' ";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }
    public void supprimerNote(int id) {
        String sql="DELETE FROM `notecours` WHERE  `id_cours`='"+id+"' ";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }
    public void supprimerReservation(int id) {
        String sql="DELETE FROM `reservation_cours` WHERE  `id_cours`='"+id+"' ";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }

   /* @Override
    public List<Cours> afficherCours() {
         List<Cours> list = new ArrayList<>();
        try {
            Statement stl = conn.createStatement();
            
            String req = "SELECT * from cours";
            ResultSet res;
            res = stl.executeQuery(req);
            while (res.next()) {
                Cours v1 = new Cours(res.getInt("id_cours"), res.getString ("type"), res.getInt("id_prof"), res.getInt("nb_places") , res.getInt("nb_places_reserve"), res.getInt("id_salle"), res.getDate("date"), res.getString("heureDebut"), res.getString("heureFin"),res.getInt("prix"));
                list.add(v1);
              
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }*/
    
    public ObservableList<Cours> afficherCours() {
           // List<Cours> List = new ArrayList<>();
            ObservableList<Cours> list = FXCollections.observableArrayList();
            
           // String sql = "SELECT * FROM cours ";

            try {
                 String sql = "SELECT * FROM cours ";
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    Cours a =new Cours();
                    a.setId_cours(rs.getInt("id_cours"));
                    a.setType(rs.getString("type"));
                    a.setId_prof(rs.getInt("id_prof"));
                    a.setNb_places(rs.getInt("nb_places"));
                   // a.setNb_places_res(rs.getInt(5));
                    a.setId_salle(rs.getInt("id_salle"));
                    a.setDate(rs.getDate("date"));
                  a.setHeure_debut(rs.getString("heureDebut"));
                  a.setHeure_fin(rs.getString("heureFin"));
                  a.setPrix(rs.getFloat("prix"));
                  a.setImage(rs.getString("image"));
                  list.add(a);
                }
                list.forEach(System.out::println);
                return list; 

            } catch (SQLException ex) {
                Logger.getLogger(CoursService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;        }
    
    public ObservableList<Cours> RechercherCours(int id) {
           // List<Cours> List = new ArrayList<>();
            ObservableList<Cours> list = FXCollections.observableArrayList();
            
           // String sql = "SELECT * FROM cours ";

            try {
                 String sql = "SELECT * FROM cours WHERE  `id_cours`='"+id+"' ";
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    Cours a =new Cours();
                    a.setId_cours(rs.getInt("id_cours"));
                    a.setType(rs.getString("type"));
                    a.setId_prof(rs.getInt("id_prof"));
                    a.setNb_places(rs.getInt("nb_places"));
                   // a.setNb_places_res(rs.getInt(5));
                    a.setId_salle(rs.getInt("id_salle"));
                    a.setDate(rs.getDate("date"));
                  a.setHeure_debut(rs.getString("heureDebut"));
                  a.setHeure_fin(rs.getString("heureFin"));
                  a.setPrix(rs.getFloat("prix"));
                  a.setImage(rs.getString("image"));
                  list.add(a);
                }
                list.forEach(System.out::println);
                return list; 

            } catch (SQLException ex) {
                Logger.getLogger(CoursService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;        }
    
    
    
    public String NomProf(Cours c) {
        
      String pr="";
      String pr1="";
      String pr2="";
      String sql = "SELECT nom,prenom FROM fos_user as p,cours as c WHERE c.id_prof='"+c.getId_prof()+"' and p.id=c.id_prof";
        
        try {
            

            Statement stl = conn.createStatement();
           ResultSet rs =stl.executeQuery(sql);
           rs.next();
          pr1= rs.getString(1);
          pr2= rs.getString(2);
          rs.close();
            
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
           
        }
       
        return pr=pr1+" "+pr2;
    }
    
    
    public ObservableList<String> getNomPrenom() {
        ObservableList<String> a=FXCollections.observableArrayList();
      String pr="";
      String pr1="";
      String pr2="";
      String sql = "SELECT nom,prenom FROM fos_user WHERE departement='proffeseurs'";
        
        try {
            

            Statement stl = conn.createStatement();
           ResultSet rs =stl.executeQuery(sql);
           while (rs.next()) {
          pr1= rs.getString(1);
          pr2= rs.getString(2);
          pr=pr1+" "+pr2;
          a.add(pr);
           }
          
          
          rs.close();
            
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
           
        }
       
        return a;
    }
    
     public int getIdProf(String nom,String prenom) {
        
      int pr=0;
     /* String pr1="";
      String pr2="";*/
      String sql = "SELECT id FROM fos_user WHERE nom='"+nom+"' and prenom='"+prenom+"' and departement='proffeseurs'";
        
        try {
            

            Statement stl = conn.createStatement();
           ResultSet rs =stl.executeQuery(sql);
           rs.next();
           pr= rs.getInt(1);
         // pr2= rs.getString(2);
          rs.close();
            
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
           
        }
       
        return pr;
    }
     
    public void DiminuerPlaces(int id) {
        
      
           String sql = "UPDATE `cours` SET `nb_places`=`nb_places`-1 WHERE `id_cours`='"+id+"'";

        
        try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }
    public String NomClient(int id) {
        
      String pr="";
      String pr1="";
      String pr2="";
      String sql = "SELECT nom,prenom FROM fos_user WHERE id='"+id+"' AND roles LIKE'%ROLE_UTILISATEUR%' ";
        
        try {
            

            Statement stl = conn.createStatement();
           ResultSet rs =stl.executeQuery(sql);
           rs.next();
          pr1= rs.getString(1);
          pr2= rs.getString(2);
          rs.close();
            
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
           
        }
       
        return pr=pr1+" "+pr2;
    }
     public String MailClient(int id) {
        
      String pr="";
      
      String sql = "SELECT email FROM fos_user WHERE id='"+id+"' AND roles LIKE'%ROLE_UTILISATEUR%' ";
        
        try {
            

            Statement stl = conn.createStatement();
           ResultSet rs =stl.executeQuery(sql);
           rs.next();
          pr= rs.getString(1);
          
          rs.close();
            
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
           
        }
       
        return pr;
    }
     public ObservableList<MesReservations>  afficherMesReservations(int id)
    {
        ObservableList<MesReservations> listA = FXCollections.observableArrayList();
        try {
            
            
          String req4="SELECT rc.id_reservationCours,fos.nom,fos.prenom,fos.email,fos2.nom,fos2.prenom,c.type,s.designation,c.date,c.heureDebut,c.prix FROM reservation_cours as rc , cours as c, salle as s, fos_user as fos, fos_user as fos2 where fos.id='"+id+"' and fos.id=rc.id_client AND rc.id_cours=c.id_cours and fos2.id=c.id_prof and c.id_salle=s.id_salle";
               //  int id, String nom, String prenom, String mail, Date date_reservation, float prix, String siege, String Qr, int nb_place
          Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
                       MesReservations a = new MesReservations();

                a.setId(rs.getInt("id_reservationCours"));
                a.setNomC(rs.getString(2));
                a.setPrenomC(rs.getString(3));
                a.setMail(rs.getString(4)); 
                a.setNomP(rs.getString(5)); 
                a.setPrenomP(rs.getString(6)); 
                a.setType(rs.getString(7)); 
                 a.setSalle(rs.getString(8)); 
                a.setDate_cours(rs.getDate(9)); 
               
                a.setTime(rs.getString(10));
                a.setPrix(rs.getFloat(11));
                
                 
                
                  
               
         
                listA.add(a);
            }
            listA.forEach(System.out::println);
            return listA;
        
        } catch (SQLException ex) {
            Logger.getLogger(CoursService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
    }
      public ObservableList<String> getDesignationSalle() {
        ObservableList<String> a=FXCollections.observableArrayList();
      String pr="";
      
      String sql = "SELECT designation FROM `salle` WHERE type='Formation' and etat='Libre'";
        
        try {
            

            Statement stl = conn.createStatement();
           ResultSet rs =stl.executeQuery(sql);
           while (rs.next()) {
          pr= rs.getString(1);
          
          a.add(pr);
           }
          
          
          rs.close();
            
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
           
        }
       
        return a;
    }
    public void modifierEtatSalle(String des) {
        
      
           String sql = "UPDATE `salle` SET `etat`='Non Libre' WHERE `designation`='"+des+"'";

        
        try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }
    public int getIdSalle(String des) {
        
      int pr=0;
     /* String pr1="";
      String pr2="";*/
      String sql = "SELECT id_salle FROM salle WHERE designation='"+des+"'";
        
        try {
            

            Statement stl = conn.createStatement();
           ResultSet rs =stl.executeQuery(sql);
           rs.next();
           pr= rs.getInt(1);
         // pr2= rs.getString(2);
          rs.close();
            
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
           
        }
       
        return pr;
    }
    public int getNbPlaces(String des) {
        
      int pr=0;
     /* String pr1="";
      String pr2="";*/
      String sql = "SELECT limite FROM salle WHERE designation='"+des+"'";
        
        try {
            

            Statement stl = conn.createStatement();
           ResultSet rs =stl.executeQuery(sql);
           rs.next();
           pr= rs.getInt(1);
         // pr2= rs.getString(2);
          rs.close();
            
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
           
        }
       
        return pr;
    }
    
     public void modifierEtatSalleNL(String des) {
        
      
           String sql = "UPDATE `salle` SET `etat`='Libre' WHERE `designation`='"+des+"'";

        
        try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
    }
     public String getDes_Salle(int id) {
        
      String pr="";
      
      String sql = "SELECT designation FROM salle WHERE id_salle='"+id+"'";
        
        try {
            

            Statement stl = conn.createStatement();
           ResultSet rs =stl.executeQuery(sql);
           rs.next();
          pr= rs.getString(1);
          
          rs.close();
            
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
           
        }
       
        return pr;
    }
     
     
     
     
      public int getIdCours(int id) {
        
      
            int a=0;
      
      String sql = "SELECT id_cours FROM `reservation_cours` WHERE id_client='"+id+"'";
        
        try {
            //int a[];

            Statement stl = conn.createStatement();
           ResultSet rs =stl.executeQuery(sql);
           while(rs.next())
           {
          a= rs.getInt("id_cours");
           }
          rs.close();
            
           //QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
           
        }
       
        return a ;
    }

public int compter(int id) {
        
      int pr=0;
     /* String pr1="";
      String pr2="";*/
      String sql = "SELECT COUNT(note) FROM `notecours` WHERE id_cours='"+id+"'";
        
        try {
            

            Statement stl = conn.createStatement();
           ResultSet rs =stl.executeQuery(sql);
           rs.next();
           pr= rs.getInt(1);
         // pr2= rs.getString(2);
          rs.close();
            
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
           
        }
       
        return pr;
    }

public ObservableList<Cours> RechercherCourspartype(String type) {
           // List<Cours> List = new ArrayList<>();
            ObservableList<Cours> list = FXCollections.observableArrayList();
            
           // String sql = "SELECT * FROM cours ";

            try {
                 String sql = "SELECT * FROM cours WHERE  `type`='"+type+"' ";
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    Cours a =new Cours();
                    a.setId_cours(rs.getInt("id_cours"));
                    a.setType(rs.getString("type"));
                    a.setId_prof(rs.getInt("id_prof"));
                    a.setNb_places(rs.getInt("nb_places"));
                   // a.setNb_places_res(rs.getInt(5));
                    a.setId_salle(rs.getInt("id_salle"));
                    a.setDate(rs.getDate("date"));
                  a.setHeure_debut(rs.getString("heureDebut"));
                  a.setHeure_fin(rs.getString("heureFin"));
                  a.setPrix(rs.getFloat("prix"));
                  a.setImage(rs.getString("image"));
                  list.add(a);
                }
                list.forEach(System.out::println);
                return list; 

            } catch (SQLException ex) {
                Logger.getLogger(CoursService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;        }

}
