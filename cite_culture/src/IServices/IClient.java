/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entity.Client;

/**
 *
 * @author hatem
 */
public interface IClient {
 public void ajouterClient(Client c);
 public Client rechercheClient(String qr);
}
