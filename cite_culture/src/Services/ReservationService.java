/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;



import Dao.MyDB;
import Entities.Reservation;
import Entities.Ticket;
import IServices.IReservation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utilitaire.mailReservation;
//import utilitaire.QRCodeGenerator;



/**
 *
 * @author moham
 */
public class ReservationService implements IReservation{
    Connection conn;

    public ReservationService() throws ClassNotFoundException{
        this.conn = MyDB.getInstance().getConnexion();
}
    @Override
    public void ajouterReservation(Reservation r) {
   String sql = "INSERT INTO `reservation`(`id_event`, `id_user`, `date_reservation`, `prix`, `siege`, `QR`, `nb_place`) VALUES ('"+r.getId_event()+ "','" + r.getId_user()+ "',SYSDATE(),'" + r.getPrix()+ "','" + r.getSiege()+ "','" + r.getQr()+ "','" + r.getNb_place()+ "')";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
        /*mailReservation a=new mailReservation();
        a.send("a","d");*/
          // QRCodeGenerator(r.getQr(),r.getId());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
           
    }
    
   /* @Override
    public void modifierReservation(Reservation r,int id) {
   String sql = "UPDATE `reservation` SET `date_reservation`='"+r.getDate_reservation() + "',`nom_evenement`='"+r.getNom_evenement() + "',`type_evenement`='"+r.getType_evenement() + "',`nom`='"+r.getNom() + "',`prenom`='"+r.getPrenom() + "',`mail`='"+r.getMail() + "',`telephone`='"+r.getTelephone() + "',`prix`='"+r.getPrix() + "',`siege`='"+r.getSiege() + "',`QR`='"+r.getQr() + "',`nb_place`='" + r.getNb_place()+ "',`nb_place_restant`='" + r.getNb_restant()+ "' WHERE `id_reservation`='"+id+"'";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
         //  QRCodeGenerator.generateQRCodeImage(r.getQr(),c.getUsername());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
           
    }
    
    */
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
    
    
    
     

     public ObservableList<Ticket>  afficherReseration()
    {
        ObservableList<Ticket> listA = FXCollections.observableArrayList();
        try {
            
            
          String req4="SELECT idEvent,titre,typeEvent,dateD FROM `evenement`";
               //  int id, String nom, String prenom, String mail, Date date_reservation, float prix, String siege, String Qr, int nb_place
          Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
                       Ticket a = new Ticket();

                a.setId(rs.getInt(1));
                a.setTitre(rs.getString(2));
                
                a.setNom(rs.getString(3));
              a.setDate_reservation(rs.getDate(4));
                
                 
                
                  
               
         
                listA.add(a);
            }
            listA.forEach(System.out::println);
            return listA;
        
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
    }
     
     public List<String> rechercheReservationParId(int id) {
            List<String> ListPlace = new ArrayList<>();
            
            String sql = "SELECT * FROM reservation WHERE id_event='" + id +"';";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                 
                  ListPlace.add(rs.getString("siege"));
                 
                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ListPlace;     
     }
    
     
     
      public Reservation rechercheReservationParIdClient(int id) {

          Reservation r=new Reservation();
            String sql = "SELECT * FROM reservation WHERE id_user='" + id +"';";
            

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                 
                  r.setSiege(rs.getString("siege"));
                  r.setQr(rs.getString("QR"));
                  r.setPrix(rs.getFloat("prix"));
                  r.setId(rs.getInt("id_reservation"));
                  
                 
                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return r;     
     }
      
      
      public Reservation rechercheReservationParIdRes(int id) {

          Reservation r=new Reservation();
            String sql = "SELECT * FROM reservation WHERE id_reservation='" + id +"';";
            

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                 
                  r.setSiege(rs.getString("siege"));
                  r.setQr(rs.getString("QR"));
                  r.setPrix(rs.getFloat("prix"));
                  r.setId(rs.getInt("id_reservation"));
                  r.setNb_place(rs.getInt("nb_place"));
                  r.setId_user(rs.getInt("id_user"));
                  
                 
                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return r;     
     }
    
     
     
     
     
      
       public ObservableList<Ticket>  afficherReserations(int idUser,int idEvent)
    {
        ObservableList<Ticket> listA = FXCollections.observableArrayList();
        try {
            
            
          String req4="SELECT id_reservation,nom,prenom,email,date_reservation,prix,siege,r.QR,nb_place,e.titre,e.time,e.dateD FROM reservation as r, fos_user as f,evenement as e WHERE r.id_user='"+idUser+"' and f.id=r.id_user  and r.id_event='"+idEvent+"' and e.idEvent=r.id_event";
               //  int id, String nom, String prenom, String mail, Date date_reservation, float prix, String siege, String Qr, int nb_place
          Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
                       Ticket a = new Ticket();

                a.setId(rs.getInt("id_reservation"));
                a.setDate_reservation(rs.getDate(5));
                a.setNom(rs.getString(2));
                a.setPrenom(rs.getString(3)); 
                a.setMail(rs.getString(4)); 
                a.setPrix(rs.getFloat(6)); 
                a.setSiege(rs.getString(7)); 
                a.setQr(rs.getString(8)); 
                a.setNb_place(rs.getInt(9)); 
                a.setTitre(rs.getString(10));
                a.setTime(rs.getString(11));
                a.setDate(rs.getDate(12));
                
                 
                
                  
               
         
                listA.add(a);
            }
            listA.forEach(System.out::println);
            return listA;
        
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
    }
      
      
      
      
       public float prixEvent(int id) {

          Reservation r=new Reservation();
            String sql = "SELECT prixAdulte FROM reservation as r , evenement as e WHERE e.idEvent='" + id +"';";
            float prix=0;

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                 
                  prix=rs.getInt("prixAdulte");
                  
                 
                  
                 
                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return prix;     
     }
       
       
       
        public int nbplace(int id) {

          Reservation r=new Reservation();
            String sql = "SELECT e.nbrPlace FROM reservation as r , evenement as e WHERE e.idEvent='" + id +"';";
            int prix=0;

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                 
                  prix=rs.getInt("nbrPlace");
                  
                 
                  
                 
                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return prix;     
     }
      
        
         public int nbplaceParEvent(int id) {

          Reservation r=new Reservation();
            String sql = "SELECT nb_place FROM reservation WHERE id_event='" + id +"';";
            int prix=0;

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                 
                  prix+=rs.getInt("nb_place");
                  
                   // System.out.println(prix);
                  
                 
                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
            }
         //System.out.println(prix);
        return prix;     
     }
      
         
         
         
         
         
         
         public Ticket getTicket(int id) {

          Ticket r=new Ticket();
            String sql = "SELECT * FROM evenement WHERE idEvent='" + id +"';";
            

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                 
                  /*r.setSiege(rs.getString("siege"));
                  r.setQr(rs.getString("QR"));
                  r.setPrix(rs.getFloat("prix"));
                  r.setId(rs.getInt("id_reservation"));
                  r.setNb_place(rs.getInt("nb_place"));*/
                  r.setTitre(rs.getString("titre"));
                  r.setDate(rs.getDate("dateD"));
                  r.setNb_place(rs.getInt("nbrPlace"));
                  r.setTime(rs.getString("time"));
                  
                 
                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return r;     
     }
         
         
         public Ticket getUser(int id) {

          Ticket r=new Ticket();
            String sql = "SELECT * FROM fos_user WHERE id='" + id +"';";
            

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                 
                  /*r.setSiege(rs.getString("siege"));
                  r.setQr(rs.getString("QR"));
                  r.setPrix(rs.getFloat("prix"));
                  r.setId(rs.getInt("id_reservation"));
                  r.setNb_place(rs.getInt("nb_place"));*/
                  r.setNom(rs.getString("nom"));
                  r.setPrenom(rs.getString("prenom"));
                 // r.setMail(rs.getString("mail"));
                  
                 
                }

            } catch (SQLException ex) {
                Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return r;     
     }
      
     
         
         
         
         
         
          public ObservableList<Ticket>  afficherReseration(int idUser)
    {
        ObservableList<Ticket> listA = FXCollections.observableArrayList();
        try {
            
            
          String req4="SELECT id_reservation,nom,prenom,email,date_reservation,prix,siege,r.QR,nb_place,e.titre,e.time,e.dateD FROM reservation as r, fos_user as f,evenement as e WHERE r.id_user='"+idUser+"' and f.id=r.id_user  and  e.idEvent=r.id_event";
               //  int id, String nom, String prenom, String mail, Date date_reservation, float prix, String siege, String Qr, int nb_place
          Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
                       Ticket a = new Ticket();

                a.setId(rs.getInt("id_reservation"));
                a.setDate_reservation(rs.getDate(5));
                a.setNom(rs.getString(2));
                a.setPrenom(rs.getString(3)); 
                a.setMail(rs.getString(4)); 
                a.setPrix(rs.getFloat(6)); 
                a.setSiege(rs.getString(7)); 
                a.setQr(rs.getString(8)); 
                a.setNb_place(rs.getInt(9)); 
                a.setTitre(rs.getString(10));
                a.setTime(rs.getString(11));
                a.setDate(rs.getDate(12));
                
                 
                
                  
               
         
                listA.add(a);
            }
            listA.forEach(System.out::println);
            return listA;
        
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
    }
      
         
         
         
         
         
         
}
