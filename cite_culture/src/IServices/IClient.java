/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entity.Client;
import java.util.List;

/**
 *
 * @author hatem
 */
public interface IClient {

     public void ajouterClient(Client c);
 public Client rechercheClientParQr(String qr);
 public Client rechercheClientParCin(int cin);
 public Client rechercheClientParUsername(String username);
 public Client rechercheClientParUsernameMdp(String username,String mdp);
 public List<Client>rechercheClientParNom(String nom);
 public List<Client>tousLesClients();
 public void updateClient(Client c);
 public void SupprimerCompteClient(int cin);
}
