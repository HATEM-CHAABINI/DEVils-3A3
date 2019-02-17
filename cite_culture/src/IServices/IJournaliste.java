/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Journaliste;
import java.util.List;

/**
 *
 * @author hatem
 */
public interface IJournaliste {
    
     public void ajouterJournaliste(Journaliste j);
 public Journaliste rechercheJournalisteParQr(String qr);
 public Journaliste rechercheJournalisteParCin(int cin);
 public Journaliste rechercheJournalisteParUsername(String username);
 public Journaliste rechercheJournalisteParUsernameMdp(String username,String mdp);
 public List<Journaliste>rechercheJournalisteParNom(String nom);
 public List<Journaliste>tousLesJournalistes();
 public void updateJournaliste(Journaliste j);
 public void SupprimerCompteJournaliste(int cin);
}
