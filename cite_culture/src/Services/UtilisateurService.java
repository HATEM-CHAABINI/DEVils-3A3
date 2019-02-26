/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.MyDB;
import Entities.Utilisateur;
import IServices.IUtilisateur;
import com.google.zxing.WriterException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class UtilisateurService implements IUtilisateur{
    Connection conn;

    public UtilisateurService() throws ClassNotFoundException{
        this.conn = MyDB.getInstance().getConnexion();
}
    @Override
    public void ajouterUtilisateur(Utilisateur c) {
    String role=  "a:1:{i:0;s:15:\"ROLE_UTILISATEUR\";}" ;

        String sql = "INSERT INTO `fos_user`(`username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `locked`, "
           + "`expired`,  `confirmation_token`, `roles`, `credentials_expired`, `departement`, `qr`, `image`, `nom`, `prenom`, `ville`,"
           + " `date_naissance`, `bio`, `domaine`, `note`, `adresse`, `code_postal`, `sexe`, `telephone`, `cin`) "
           + "VALUES ('"+c.getUsername() + "','" + c.getUsername() + "','" + c.getEmail() + "','" + c.getEmail() + "','" +
c.getEnabled() + "','" + c.getSalt() + "','" + c.getPassword()  + "','" + c.getLocked() + "','" + c.getExpired()  + 
"','" + c.getConfirmation_token() + "','"+ role+"','" + c.getCredentials_expired() +  "','" + c.getDepartement()+ "','" +
c.getQr() + "','" + c.getImage() + "','" + c.getNom() + "','" + c.getPrenom() + "','" + c.getVille() + "','"+ c.getDate_naissance() +"','" +
           c.getBio() + "','" + c.getDomaine() + "','" + c.getNote() + "','" + c.getAdresse()+"','" + c.getCode_postal()+
           "','" + c.getSexe()+"','" + c.getTelephone()+"','" + c.getCin()+"');";

   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
      Statement stl = conn.createStatement();
//             PreparedStatement ptl = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
//            ptl.executeUpdate();
//            ResultSet generatedKeys = ptl.getGeneratedKeys();
//                 generatedKeys.next();
//                 
//            System.out.println(generatedKeys.getInt(1));
          int rs =stl.executeUpdate(sql);
           QRCodeGenerator.generateQRCodeImage(c.getQr(),c.getUsername(),c.getEmail());
                   } catch (SQLException |IOException|WriterException ex) {
            System.err.println("SQLException: " + ex.getMessage());
           
        } catch (Exception ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

    @Override
    public Utilisateur rechercheUtilisateurParQr(String qr) {
         Utilisateur c = new Utilisateur();
        

            String sql = "SELECT * FROM fos_user WHERE (qr='" + qr + "');";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    c.setId(rs.getInt("id"));
                    c.setNom(rs.getString("nom"));
                    c.setImage(rs.getString("image"));
                    c.setAdresse(rs.getString("adresse"));
                    c.setUsername(rs.getString("username"));
                    c.setVille(rs.getString("ville"));
                    c.setCode_postal(rs.getInt("code_postal"));
                    c.setTelephone(rs.getInt("telephone"));
                    c.setPrenom(rs.getString("prenom"));
                    c.setEmail(rs.getString("email"));
                    c.setPassword(rs.getString("password"));
                    c.setAdresse(rs.getString("adresse"));
                    c.setEnabled(rs.getInt("enabled"));
                  c.setRoles(rs.getString("roles"));
                  
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return c;
    }

    @Override
    public Utilisateur rechercheUtilisateurParCin(int cin) {
Utilisateur a = new Utilisateur();
        
//SELECT * FROM fos_user WHERE (roles like "%ROLE_UTILISATEUR%" and cin= 10009484 )

            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_UTILISATEUR%'  and cin='" + cin + "';";

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
                  a.setImage(rs.getString("image"));
                  a.setVille(rs.getString("ville"));
                  a.setTelephone(rs.getInt("telephone"));
                  a.setCode_postal(rs.getInt("code_postal"));
                a.setDate_naissance(rs.getDate("date_naissance"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return a;     }

    @Override
    public Utilisateur rechercheUtilisateurParUsername(String username) {
Utilisateur a = new Utilisateur();
        

            String sql = "SELECT * FROM fos_user  WHERE  (roles like '%ROLE_JOURNALISTE%' or roles like '%ROLE_UTILISATEUR%') and username='" + username + "';";

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
                  a.setTelephone(rs.getInt("telephone"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return a;     }

    @Override
    public Utilisateur rechercheUtilisateurParUsernameMdp(String username, String mdp) {
//d
Utilisateur c = new Utilisateur();
        cryptpasswords encryption = new cryptpasswords() ; // SHA256 ENCRYPTION
        try {
            String mdpc=encryption.cryptme(mdp);
        
//roles like '%ROLE_UTILISATEUR%' and
            String sql = "SELECT * FROM fos_user WHERE  username ='" + username + "' and password like '"+ mdpc+"';";
            System.out.println("///////////////////////");
            System.out.println(mdpc);
            System.out.println("///////////////////////");
           
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    c.setLocked(rs.getInt("locked"));
                   c.setId(rs.getInt("id"));
                    c.setNom(rs.getString("nom"));
                    c.setImage(rs.getString("image"));
                    c.setAdresse(rs.getString("adresse"));
                    c.setUsername(rs.getString("username"));
                    c.setVille(rs.getString("ville"));
                    c.setCode_postal(rs.getInt("code_postal"));
                    c.setTelephone(rs.getInt("telephone"));
                    c.setPrenom(rs.getString("prenom"));
                    c.setEmail(rs.getString("email"));
                    c.setPassword(rs.getString("password"));
                                        c.setEnabled(rs.getInt("enabled"));

                    c.setAdresse(rs.getString("adresse"));
                  c.setRoles(rs.getString("roles"));
                  c.setDepartement(rs.getString("departement"));
                  c.setDomaine(rs.getString("domaine"));
                }
            
            } catch (SQLException |NoSuchAlgorithmException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return c;        }

    @Override
    public List<Utilisateur> rechercheUtilisateurParNom(String nom) {
            List<Utilisateur> ListUtilisateur = new ArrayList<>();
            
            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_UTILISATEUR%' and username='" + nom +"';";

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
                  ListUtilisateur.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ListUtilisateur;        }

    @Override
    public List<Utilisateur> tousLesUtilisateurs() {
        List<Utilisateur> ListUtilisateur = new ArrayList<>();
            
            String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_UTILISATEUR%';";

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
                  ListUtilisateur.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ListUtilisateur;        }


    @Override
    public void updateUtilisateur(String username,String email,int telephone,String ville,String adresse,int code_postale,String mdp,String path){
  
    try {
        String sql;
        if (mdp.equals("")){
        
               sql = "UPDATE `fos_user` SET `email`='"+email+ "',`email_canonical`='"+email+ "',`image`='"+path+ "',`ville`='"+ville+ "',`adresse`='"+adresse+ "',`code_postal`='"+code_postale+ "',`telephone`='"+telephone+ "' WHERE roles like '%ROLE_UTILISATEUR%' and `username` ='"+username+"';";

        }else{
        cryptpasswords encryption = new cryptpasswords() ;
        String qr=username+','+ encryption.cryptme(mdp);
       sql = "UPDATE `fos_user` SET `email`='"+email+ "',`email_canonical`='"+email+ "',`password`='"+encryption.cryptme(mdp) + "',`qr`='"+qr+ "',`image`='"+path+ "',`ville`='"+ville+ "',`adresse`='"+adresse+ "',`code_postal`='"+code_postale+ "',`telephone`='"+telephone+ "' WHERE roles like '%ROLE_UTILISATEUR%' and `username` ='"+username+"';";
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
    public void updateUtilisateurSansImage(String username,String email,int telephone,String ville,String adresse,int code_postale,String mdp){
  
    try {
        String sql;
        if (mdp.equals("")){
        
               sql = "UPDATE `fos_user` SET `email`='"+email+ "',`email_canonical`='"+email+ "',`ville`='"+ville+ "',`adresse`='"+adresse+ "',`code_postal`='"+code_postale+ "',`telephone`='"+telephone+ "' WHERE roles like '%ROLE_UTILISATEUR%' and `username` ='"+username+"';";

        }else{
        cryptpasswords encryption = new cryptpasswords() ;
        String qr=username+','+ encryption.cryptme(mdp);
       sql = "UPDATE `fos_user` SET `email`='"+email+ "',`email_canonical`='"+email+ "',`password`='"+encryption.cryptme(mdp) + "',`qr`='"+qr+ "',`ville`='"+ville+ "',`adresse`='"+adresse+ "',`code_postal`='"+code_postale+ "',`telephone`='"+telephone+ "' WHERE `username` ='"+username+"';";
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
    public void SupprimerCompteUtilisateur(String username) {

    String sql = "DELETE FROM `fos_user` WHERE roles like '%ROLE_UTILISATEUR%' and username ='"+username+"';";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = conn.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
        }        }

    @Override
    public List<Utilisateur> clientNonActiver() {
    List<Utilisateur> ListUtilisateur = new ArrayList<>();
            
            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_UTILISATEUR%' and enabled='" + 0 +"';";

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
                  ListUtilisateur.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ListUtilisateur;            }

    @Override
    public void updateEnable(int ena,String username) {
        try{  
        String sql = "UPDATE `fos_user` SET `enabled`='"+ena+ "' WHERE `username` ='"+username+"';";
       Statement stl = conn.createStatement();
            int rs =stl.executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
    }
    }
    @Override
    public void updateMail(String mail,String username) {
        try{  
        String sql = "UPDATE `fos_user` SET `email`='"+mail+ "' WHERE `username` ='"+username+"';";
       Statement stl = conn.createStatement();
            int rs =stl.executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
    }
    }

    @Override
    public ObservableList<Utilisateur> oTousLesUtilisateurs() {
         ObservableList<Utilisateur> ListUtilisateur = FXCollections.observableArrayList();
            
            String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_UTILISATEUR%';";

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
    public ObservableList<Utilisateur> oUtilisateurNonActiver() {
         ObservableList<Utilisateur> ListUtilisateur = FXCollections.observableArrayList();
            
            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_UTILISATEUR%' and enabled='" + 0 +"';";

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
                  ListUtilisateur.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ListUtilisateur;            }

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
            String sql = "SELECT * FROM fos_user  WHERE email='"+ Email+"';";

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
    public boolean verifCin(int Cin) {
   boolean verif =true;
            
            String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_UTILISATEUR%'and cin='"+ Cin+"';";

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
boolean verif =true;
            
            String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_UTILISATEUR%'and email='"+ Email+"'and username NOT LIKE '"+username+"';";

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
    public boolean verfierMotDePasse(String mdp, String username) {
boolean verif =false;

        cryptpasswords encryption = new cryptpasswords() ; // SHA256 ENCRYPTION
        try {
            String mdpc=encryption.cryptme(mdp);
        

            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_UTILISATEUR%' and username ='" + username + "' and password like '"+ mdpc+"';";
            System.out.println("///////////////////////");
            System.out.println(mdpc);
            System.out.println("///////////////////////");
           
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                if (rs.next()) {
                 verif=true;
                }
            
            } catch (SQLException |NoSuchAlgorithmException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return verif;         }

    @Override
    public void updateMdpUtilisateur(String username, String mdp,String email) {
        try {
            cryptpasswords encryption = new cryptpasswords() ;
            String qr=username+','+ encryption.cryptme(mdp);
            System.out.println(encryption.cryptme(mdp));
            String sql = "UPDATE `fos_user` SET `password`='"+encryption.cryptme(mdp) + "',`qr`='"+qr+ "' WHERE `username` ='"+username+"';";
            QRCodeGenerator.generateQRCodeImage(qr,username,email);
        

        
   
            
            Statement stl = conn.createStatement();
            int rs =stl.executeUpdate(sql);
            
        } catch (SQLException |IOException| WriterException |NoSuchAlgorithmException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
}

    @Override
    public void Bannir(String username) {
  try{  
        String sql = "UPDATE `fos_user` SET `locked`='"+0+ "' WHERE `username` ='"+username+"';";
       Statement stl = conn.createStatement();
            int rs =stl.executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            
    }    }
}

