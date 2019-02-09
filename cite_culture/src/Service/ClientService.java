/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.MyDB;
import Entity.Client;
import IServices.IClient;
import com.google.zxing.WriterException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitaire.QRCodeGenerator;
import utilitaire.cryptpasswords;

/**
 *
 * @author hatem
 */
public class ClientService implements IClient{
    Connection conn;

    public ClientService() throws ClassNotFoundException{
        this.conn = MyDB.getInstance().getConnexion();
}
    @Override
    public void ajouterClient(Client c) {
   String sql = "INSERT INTO `fos_user`(`username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `locked`, "
           + "`expired`,  `confirmation_token`, `roles`, `credentials_expired`, `departement`, `qr`, `image`, `nom`, `prenom`, `ville`,"
           + " `date_naissance`, `bio`, `domaine`, `note`, `adresse`, `code_postal`, `sexe`, `telephone`, `cin`) "
           + "VALUES ('"+c.getUsername() + "','" + c.getUsername() + "','" + c.getEmail() + "','" + c.getEmail() + "','" +
c.getEnabled() + "','" + c.getSalt() + "','" + c.getPassword()  + "','" + c.getLocked() + "','" + c.getExpired()  + 
"','" + c.getConfirmation_token() + "','" +c.getRoles()+ "','" + c.getCredentials_expired() +  "','" + c.getDepartement()+ "','" +
c.getQr() + "','" + c.getImage() + "','" + c.getNom() + "','" + c.getPrenom() + "','" + c.getVille() + "','" + c.getDate_naissance() + "','" +
           c.getBio() + "','" + c.getDomaine() + "','" + c.getNote() + "','" + c.getAdresse()+"','" + c.getCode_postal()+
           "','" + c.getSexe()+"','" + c.getTelephone()+"','" + c.getCin()+"');";

   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
           QRCodeGenerator.generateQRCodeImage(c.getQr(),c.getUsername());
                   } catch (SQLException |IOException|WriterException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }
           
    }

    @Override
    public Client rechercheClientParQr(String qr) {
         Client c = new Client();
        

            String sql = "SELECT * FROM fos_user WHERE (qr='" + qr + "');";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    c.setId(rs.getInt("id"));
                    c.setNom(rs.getString("nom"));
                    c.setUsername(rs.getString("username"));
                    c.setPrenom(rs.getString("prenom"));
                    c.setEmail(rs.getString("email"));
                    c.setPassword(rs.getString("password"));
                    c.setAdresse(rs.getString("adresse"));
                  c.setRoles(rs.getString("roles"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return c;
    }

    @Override
    public Client rechercheClientParCin(int cin) {
Client a = new Client();
        
//SELECT * FROM fos_user WHERE (roles like "%ROLE_CLIENT%" and cin= 10009484 )

            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_CLIENT%'  and cin='" + cin + "';";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    a.setId(rs.getInt("id"));
                    a.setNom(rs.getString("nom"));
                    a.setUsername(rs.getString("username"));
                    a.setPrenom(rs.getString("prenom"));
                    a.setEmail(rs.getString("email"));
                    a.setPassword(rs.getString("password"));
                    a.setAdresse(rs.getString("adresse"));
                  a.setRoles(rs.getString("roles"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return a;     }

    @Override
    public Client rechercheClientParUsername(String username) {
Client a = new Client();
        

            String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_CLIENT%' and username='" + username + "';";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    a.setId(rs.getInt("id"));
                    a.setNom(rs.getString("nom"));
                    a.setUsername(rs.getString("username"));
                    a.setPrenom(rs.getString("prenom"));
                    a.setEmail(rs.getString("email"));
                    a.setPassword(rs.getString("password"));
                    a.setAdresse(rs.getString("adresse"));
                  a.setRoles(rs.getString("roles"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return a;     }

    @Override
    public Client rechercheClientParUsernameMdp(String username, String mdp) {

Client a = new Client();
        cryptpasswords encryption = new cryptpasswords() ; // SHA256 ENCRYPTION
        try {
            String mdpc=encryption.cryptme(mdp);
        

            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_CLIENT%' and username ='" + username + "' and password like '"+ mdpc+"';";
            System.out.println("///////////////////////");
            System.out.println(mdpc);
            System.out.println("///////////////////////");
           
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    a.setId(rs.getInt("id"));
                    a.setNom(rs.getString("nom"));
                    a.setUsername(rs.getString("username"));
                    a.setPrenom(rs.getString("prenom"));
                    a.setEmail(rs.getString("email"));
                    a.setPassword(rs.getString("password"));
                    a.setAdresse(rs.getString("adresse"));
                  a.setRoles(rs.getString("roles"));
                }
            
            } catch (SQLException |NoSuchAlgorithmException ex) {
                Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return a;        }

    @Override
    public List<Client> rechercheClientParNom(String nom) {
            List<Client> ListClient = new ArrayList<>();
            
            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_CLIENT%' and username='" + nom +"';";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    Client a =new Client();
                    a.setId(rs.getInt("id"));
                    a.setNom(rs.getString("nom"));
                    a.setUsername(rs.getString("username"));
                    a.setPrenom(rs.getString("prenom"));
                    a.setEmail(rs.getString("email"));
                    a.setPassword(rs.getString("password"));
                    a.setAdresse(rs.getString("adresse"));
                  a.setRoles(rs.getString("roles"));
                  ListClient.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ListClient;        }

    @Override
    public List<Client> tousLesClients() {
        List<Client> ListClient = new ArrayList<>();
            
            String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_CLIENT%';";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    Client a =new Client();
                    a.setId(rs.getInt("id"));
                    a.setNom(rs.getString("nom"));
                    a.setUsername(rs.getString("username"));
                    a.setPrenom(rs.getString("prenom"));
                    a.setEmail(rs.getString("email"));
                    a.setPassword(rs.getString("password"));
                    a.setAdresse(rs.getString("adresse"));
                  a.setRoles(rs.getString("roles"));
                  ListClient.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ListClient;        }


    @Override
    public void updateClient(Client a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SupprimerCompteClient(int cin) {

    String sql = "DELETE FROM `fos_user` WHERE roles like '%ROLE_CLIENT%' and cin ='"+cin+"';";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }        }
    
}
