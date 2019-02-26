/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import javafx.collections.ObservableList;
import Entities.CarteFidelite;

/**
 *
 * @author Nitro
 */
public interface ICarteFideliteService {
    public void add(CarteFidelite c);
        public void update(String username) ;
        public void remove(Integer r);
        public ObservableList<CarteFidelite> displayall();
        public CarteFidelite findCartebyID(String search);
//    public ObservableList<CarteFidelite> displayall();
//    public ObservableList<CarteFidelite> findCartebyID(Integer search);
    
}
