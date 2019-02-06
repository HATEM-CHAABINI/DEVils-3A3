/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.MyDB;
import Entity.Client;
import IServices.IClient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
            System.err.println("sql: " + sql);
        }
           
    }
    
}
