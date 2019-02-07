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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitaire.QRCodeGenerator;

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
   String sql = "INSERT INTO `fos_user`(`username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `locked`, `expired`,  `confirmation_token`, `roles`, `credentials_expired`, `departement`, `qr`, `image`, `nom`, `prenom`, `ville`, `date_naissance`, `bio`, `domaine`, `note`, `adresse`) "
           + "VALUES ('"+c.getUsername() + "','" + c.getUsername() + "','" + c.getEmail() + "','" + c.getEmail() + "','" + c.getEnabled() + "','" + c.getSalt() + "','" + c.getPassword()  + "','" + c.getLocked() + "','" + c.getExpired()  + 
                                                                                                                    "','" + c.getConfirmation_token() + "','" + "a:1:{i:0;s:15:\"ROLE_PARTENAIRE\";}" + "','" + c.getCredentials_expired() +  "','" + c.getDepartement()+ "','" + c.getQr() + "','" + c.getImage() + "','" + c.getNom() + "','" + c.getPrenom() + "','" + c.getVille() + "','" + c.getDate_naissance() + "','" + c.getBio() + "','" + c.getDomaine() + "','" + c.getNote() + "','" + c.getAdresse()+"');";

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
    public Client rechercheClient(String qr) {
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
    
}
