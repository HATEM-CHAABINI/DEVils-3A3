/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.MyDB;
import Entities.Employe;
import Entities.Utilisateur;
import IServices.IEmploye;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utilitaire.QRCodeGenerator;
import utilitaire.cryptpasswords;

/**
 *
 * @author hatem
 */
public class EmployeService implements IEmploye{
        Connection conn;

    public EmployeService() throws ClassNotFoundException {
                this.conn = MyDB.getInstance().getConnexion();

    }

    @Override
    public void ajouterEmploye(Utilisateur a) {
    String role=  "a:3:{i:2;s:18:\"ROLE_EMPLOYE\";}" ;

   String sql = "INSERT INTO `fos_user`(`username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `locked`, "
           + "`expired`,  `confirmation_token`, `roles`, `credentials_expired`, `departement`, `qr`, `image`, `nom`, `prenom`, `ville`,"
           + " `date_naissance`, `bio`, `domaine`, `note`, `adresse`, `code_postal`, `sexe`, `telephone`, `cin`) "
           + "VALUES ('"+a.getUsername() + "','" + a.getUsername() + "','" + a.getEmail() + "','" + a.getEmail() + "','" +
a.getEnabled() + "','" + a.getSalt() + "','" + a.getPassword()  + "','" + a.getLocked() + "','" + a.getExpired()  + 
"','" + a.getConfirmation_token() + "','" +role+ "','" + a.getCredentials_expired() +  "','" + a.getDepartement()+ "','" +
a.getQr() + "','" + a.getImage() + "','" + a.getNom() + "','" + a.getPrenom() + "','" + a.getVille() + "','" + a.getDate_naissance() + "','" +
           a.getBio() + "','" + a.getDomaine() + "','" + a.getNote() + "','" + a.getAdresse()+"','" + a.getCode_postal()+
           "','" + a.getSexe()+"','" + a.getTelephone()+"','" + a.getCin()+"');";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+a.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
          // QRCodeGenerator.generateQRCodeImage(a.getQr(),a.getUsername(),a.getEmail());
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }    }

    @Override
    public Utilisateur rechercheEmployeParQr(String qr) {
 Utilisateur a = new Utilisateur();
        

            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_EMPLOYE%' and qr='" + qr + "');";

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
    public Utilisateur rechercheEmployeParCin(int cin) {
Utilisateur a = new Utilisateur();
        

            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_EMPLOYE%' and cin='" + cin + "');";

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
    public Utilisateur rechercheEmployeParUsername(String username) {
Utilisateur a = new Utilisateur();
        

            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_EMPLOYE%' and username='" + username + "');";

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
    public Utilisateur rechercheEmployeParEmailMdp(String email, String mdp) {
                Utilisateur a = new Utilisateur();

            try {
                
                
                cryptpasswords encryption = new cryptpasswords() ; // SHA256 ENCRYPTION
                String mdpc=encryption.cryptme(mdp);
                
                String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_EMPLOYE%' and email='" + email + "'+ and password ='"+ mdpc+"');";
                
                
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
                    
                } catch (NoSuchAlgorithmException|SQLException ex) {
                    Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
                }
                return a;        }
 

    @Override
    public List<Utilisateur> rechercheEmployeParNom(String nom) {
            List<Utilisateur> ListEmploye = new ArrayList<>();
            
            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_EMPLOYE%' and username='" + nom +"');";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    Utilisateur a =new Utilisateur();
                    a.setId(rs.getInt("id"));
                    a.setNom(rs.getString("nom"));
                    a.setUsername(rs.getString("username"));
                    a.setPrenom(rs.getString("prenom"));
                    a.setEmail(rs.getString("email"));
                    a.setPassword(rs.getString("password"));
                    a.setAdresse(rs.getString("adresse"));
                  a.setRoles(rs.getString("roles"));
                  ListEmploye.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ListEmploye;        }

    @Override
 public List<Utilisateur> tousLesEmploye() {
        List<Utilisateur> ListEmploye = new ArrayList<>();
            
            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_EMPLOYE%';";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    Utilisateur a =new Utilisateur();
                    a.setId(rs.getInt("id"));
                    a.setNom(rs.getString("nom"));
                    a.setUsername(rs.getString("username"));
                    a.setPrenom(rs.getString("prenom"));
                    a.setEmail(rs.getString("email"));
                    a.setPassword(rs.getString("password"));
                    a.setAdresse(rs.getString("adresse"));
                  a.setRoles(rs.getString("roles"));
                  ListEmploye.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ListEmploye;        }

    @Override
    public void SupprimerCompteEmploye(String username) {

    String sql = "DELETE FROM `fos_user` where username ='"+username+"');";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }        }



    @Override
    public ObservableList<Utilisateur> oTousLesEmploye() {
   ObservableList<Utilisateur> ListUtilisateur = FXCollections.observableArrayList();
            
            String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_EMPLOYE%';";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    Utilisateur a =new Utilisateur();
                    a.setId(rs.getInt("id"));
                    a.setNom(rs.getString("nom"));
                    a.setUsername(rs.getString("username"));
                    a.setPrenom(rs.getString("prenom"));
                    a.setEmail(rs.getString("email"));
                    a.setPassword(rs.getString("password"));
                    a.setEnabled(rs.getInt("enabled"));
                    a.setAdresse(rs.getString("adresse"));
                  a.setRoles(rs.getString("roles"));
                  ListUtilisateur.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ListUtilisateur;        }

    @Override
    public void updateMail(String mail, String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void updateEmploye(String username, String email, int telephone, String ville, String adresse, int code_postale, String mdp, String path) {

    try {
        String sql;
        if (mdp.equals("")){
        
               sql = "UPDATE `fos_user` SET `email`='"+email+ "',`email_canonical`='"+email+ "',`image`='"+path+ "',`ville`='"+ville+ "',`adresse`='"+adresse+ "',`code_postal`='"+code_postale+ "',`telephone`='"+telephone+ "' WHERE roles like '%ROLE_EMPLOYE%' and `username` ='"+username+"';";

        }else{
        cryptpasswords encryption = new cryptpasswords() ;
        String qr=username+','+ encryption.cryptme(mdp);
       sql = "UPDATE `fos_user` SET `email`='"+email+ "',`email_canonical`='"+email+ "',`password`='"+encryption.cryptme(mdp) + "',`qr`='"+qr+ "',`image`='"+path+ "',`ville`='"+ville+ "',`adresse`='"+adresse+ "',`code_postal`='"+code_postale+ "',`telephone`='"+telephone+ "' WHERE roles like '%ROLE_EMPLOYE%' and `username` ='"+username+"';";
                  QRCodeGenerator.generateQRCodeImage(qr,username,email);

        }
        try {
            
            Statement stl = conn.createStatement();
            int rs =stl.executeUpdate(sql);
            
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }    } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (WriterException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }    }
    

    

    @Override
    public boolean verifUsername(String username) {
   boolean verif =true;
            
         //   String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_UTILISATEUR%'and username='"+ username+"';";
            String sql = "SELECT * FROM fos_user  WHERE username='"+ username+"';";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                if (rs.next()) {
                 verif=false;
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return verif;        }
    

    @Override
    public boolean verifEmail(String Email) {
 boolean verif =true;
            
         //   String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_UTILISATEUR%'and email='"+ Email+"';";
            String sql = "SELECT * FROM fos_user  WHERE  email='"+ Email+"';";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                if (rs.next()) {
                 verif=false;
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return verif;            }

    @Override
    public boolean verifEmailUpdate(String Email, String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verfierMotDePasse(String mdp, String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifCin(int Cin) {
boolean verif =true;
            
            String sql = "SELECT * FROM fos_user  WHERE cin='"+ Cin+"';";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                if (rs.next()) {
                 verif=false;
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return verif;        }



}
