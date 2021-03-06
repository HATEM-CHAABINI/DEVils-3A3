/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entity.Utilisateur;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author hatem
 */
public interface IUtilisateur {

     public void ajouterUtilisateur(Utilisateur c);
 public Utilisateur rechercheUtilisateurParQr(String qr);
 public Utilisateur rechercheUtilisateurParCin(int cin);
 public Utilisateur rechercheUtilisateurParUsername(String username);
 public Utilisateur rechercheUtilisateurParUsernameMdp(String username,String mdp);
 public List<Utilisateur>rechercheUtilisateurParNom(String nom);
 public List<Utilisateur>tousLesUtilisateurs();
public List <Utilisateur> clientNonActiver();
 public ObservableList <Utilisateur> oTousLesUtilisateurs();
public ObservableList <Utilisateur> oUtilisateurNonActiver();
public void updateMail(String mail,String username );
public void updateEnable(int ena,String username );
 public void updateUtilisateur(String username,String email,int telephone,String ville,String adresse,int code_postale,String mdp,String path);
 public void SupprimerCompteUtilisateur(String username);
 
 public boolean verifUsername(String username);
 public boolean verifEmail(String Email);
 public boolean verifCin(int Cin);
 
 
}
