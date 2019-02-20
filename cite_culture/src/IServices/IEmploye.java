/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Employe;
import Entities.Utilisateur;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author hatem
 */
public interface IEmploye {
   public void ajouterEmploye(Utilisateur c);
 public Utilisateur rechercheEmployeParQr(String qr);
 public Utilisateur rechercheEmployeParCin(int cin);
 public Utilisateur rechercheEmployeParUsername(String username);
 public Utilisateur rechercheEmployeParEmailMdp(String email,String mdp);
 public List<Utilisateur>rechercheEmployeParNom(String nom);
 public List<Utilisateur>tousLesEmploye();
 public ObservableList <Utilisateur> oTousLesEmploye();
public void updateMail(String mail,String username );
 public void updateEmploye(String username,String email,int telephone,String ville,String adresse,int code_postale,String mdp,String path);
 public void SupprimerCompteEmploye(String username);
 
 public boolean verifUsername(String username);
 public boolean verifEmail(String Email);
 public boolean verifEmailUpdate(String Email,String username);
 public boolean verfierMotDePasse(String mdp,String username);
 public boolean verifCin(int Cin);
 
}
