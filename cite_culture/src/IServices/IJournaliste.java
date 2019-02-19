/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Utilisateur;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author hatem
 */
public interface IJournaliste {
  
     public void ajouterJournaliste(Utilisateur c);
 public Utilisateur rechercheJournalisteParQr(String qr);
 public Utilisateur rechercheJournalisteParCin(int cin);
 public Utilisateur rechercheJournalisteParUsername(String username);
 public Utilisateur rechercheJournalisteParUsernameMdp(String username,String mdp);
 public List<Utilisateur>rechercheJournalisteParNom(String nom);
 public List<Utilisateur>tousLesJournalistes();
public List <Utilisateur> clientNonActiver();
 public ObservableList <Utilisateur> oTousLesJournalistes();
public ObservableList <Utilisateur> oJournalisteNonActiver();
public void updateMail(String mail,String username );
public void updateEnable(int ena,String username );
 public void updateJournaliste(String username,String email,int telephone,String ville,String adresse,int code_postale,String mdp,String path);
 public void SupprimerCompteJournaliste(String username);
 
 public boolean verifUsername(String username);
 public boolean verifEmail(String Email);
 public boolean verifEmailUpdate(String Email,String username);
 public boolean verfierMotDePasse(String mdp,String username);
 public boolean verifCin(int Cin);
}
