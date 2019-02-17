/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Employe;
import java.util.List;

/**
 *
 * @author hatem
 */
public interface IEmploye {
    
     public void ajouterEmploye(Employe e);
 public Employe rechercheEmployeParQr(String qr);
 public Employe rechercheEmployeParCin(int cin);
 public Employe rechercheEmployeParUsername(String username);
 public Employe rechercheEmployeParUsernameMdp(String username,String mdp);
 public List<Employe>rechercheEmployeParNom(String nom);
 public List<Employe>tousLesEmployes();
 public void updateEmploye(Employe e);
 public void SupprimerCompteEmploye(int cin);
}
