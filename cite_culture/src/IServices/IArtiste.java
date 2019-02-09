/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entity.Artiste;
import java.util.List;

/**
 *
 * @author hatem
 */
public interface IArtiste {
     public void ajouterArtiste(Artiste a);
 public Artiste rechercheArtisteParQr(String qr);
 public Artiste rechercheArtisteParCin(int cin);
 public Artiste rechercheArtisteParUsername(String username);
 public Artiste rechercheArtisteParUsernameMdp(String username,String mdp);
 public List<Artiste>rechercheArtisteParNom(String nom);
 public List<Artiste>tousLesArtistes();
 public void updateArtiste(Artiste a);
 public void SupprimerCompteArtiste(int cin);
}
