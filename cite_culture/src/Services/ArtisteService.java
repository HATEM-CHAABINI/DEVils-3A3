/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.MyDB;
import Entities.Artiste;
import Entities.Utilisateur;
import IServices.IArtiste;
import com.google.zxing.WriterException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitaire.QRCodeGenerator;

/**
 *
 * @author hatem
 */
public class ArtisteService implements IArtiste{
        Connection conn;

    public ArtisteService() throws ClassNotFoundException {
                this.conn = MyDB.getInstance().getConnexion();

    }

    @Override
    public void ajouterArtiste(Artiste a) {
   String sql = "INSERT INTO `fos_user`(`username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `locked`, "
           + "`expired`,  `confirmation_token`, `roles`, `credentials_expired`, `departement`, `qr`, `image`, `nom`, `prenom`, `ville`,"
           + " `date_naissance`, `bio`, `domaine`, `note`, `adresse`, `code_postal`, `sexe`, `telephone`, `cin`) "
           + "VALUES ('"+a.getUsername() + "','" + a.getUsername() + "','" + a.getEmail() + "','" + a.getEmail() + "','" +
a.getEnabled() + "','" + a.getSalt() + "','" + a.getPassword()  + "','" + a.getLocked() + "','" + a.getExpired()  + 
"','" + a.getConfirmation_token() + "','" +a.getRoles()+ "','" + a.getCredentials_expired() +  "','" + a.getDepartement()+ "','" +
a.getQr() + "','" + a.getImage() + "','" + a.getNom() + "','" + a.getPrenom() + "','" + a.getVille() + "','" + a.getDate_naissance() + "','" +
           a.getBio() + "','" + a.getDomaine() + "','" + a.getNote() + "','" + a.getAdresse()+"','" + a.getCode_postal()+
           "','" + a.getSexe()+"','" + a.getTelephone()+"','" + a.getCin()+"');";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
           QRCodeGenerator.generateQRCodeImage(a.getQr(),a.getUsername(),a.getEmail());
                   } catch (SQLException |IOException|WriterException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }    }

    @Override
    public Artiste rechercheArtisteParQr(String qr) {
 Artiste a = new Artiste();
        

            String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_ARTISTE%' and qr='" + qr  +"';";

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
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return a;    }

    @Override
    public Artiste rechercheArtisteParCin(int cin) {
Artiste a = new Artiste();
        

            String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_ARTISTE%' and cin='" + cin + "';";

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
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return a;     }

    @Override
    public Artiste rechercheArtisteParUsername(String username) {
Artiste a = new Artiste();
        

            String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_ARTISTE%' and username='" + username + "';";

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
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return a;     }

    @Override
    public Artiste rechercheArtisteParUsernameMdp(String username, String mdp) {

Artiste a = new Artiste();
        

            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_ARTISTE%' and username='" + username + "'+ and password ='"+ mdp+"';";

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
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return a;        }

    @Override
    public List<Artiste> rechercheArtisteParNom(String nom) {
            List<Artiste> ListArtiste = new ArrayList<>();
            
            String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_ARTISTE%' and username='" + nom +"';";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    Artiste a =new Artiste();
                    a.setId(rs.getInt("id"));
                    a.setNom(rs.getString("nom"));
                    a.setUsername(rs.getString("username"));
                    a.setPrenom(rs.getString("prenom"));
                    a.setEmail(rs.getString("email"));
                    a.setPassword(rs.getString("password"));
                    a.setAdresse(rs.getString("adresse"));
                  a.setRoles(rs.getString("roles"));
                  ListArtiste.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ListArtiste;        }

    @Override
    public List<Artiste> tousLesArtistes() {
        List<Artiste> ListArtiste = new ArrayList<>();
            
            String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_ARTISTE%';";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    Artiste a =new Artiste();
                    a.setId(rs.getInt("id"));
                    a.setNom(rs.getString("nom"));
                    a.setUsername(rs.getString("username"));
                    a.setPrenom(rs.getString("prenom"));
                    a.setEmail(rs.getString("email"));
                    a.setPassword(rs.getString("password"));
                    a.setAdresse(rs.getString("adresse"));
                  a.setRoles(rs.getString("roles"));
                  ListArtiste.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ListArtiste;        }


    @Override
    public void updateArtiste(Artiste a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SupprimerCompteArtiste(int cin) {

    String sql = "DELETE FROM `fos_user` where (cin ='"+cin+"');";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }        }

}
