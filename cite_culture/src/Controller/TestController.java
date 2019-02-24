/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.CarteFidelite;
import Entities.Utilisateur;
import Services.CarteFideliteService;
import Services.UtilisateurService;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Nitro
 */
public class TestController implements Initializable {

    @FXML
    private Button addPoints;
    @FXML
    private Button CreateCard;
    @FXML
    private ComboBox<Utilisateur> cbIdclient;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            UtilisateurService iu = new UtilisateurService ();
            ObservableList<Utilisateur> ListC = FXCollections.observableArrayList(iu.tousLesUtilisateurs());
            
            cbIdclient.setItems(ListC);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void add(ActionEvent event) {
        try {
            CarteFideliteService aaa = new CarteFideliteService();
            Date date = Date.valueOf(LocalDate.now());
            CarteFidelite b = new CarteFidelite(1000,date,cbIdclient.getSelectionModel().getSelectedItem());
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("done with success");
            Optional<ButtonType> result = alert.showAndWait();        
            if (result.get() == ButtonType.OK){
                
                aaa.add(b);
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Create(ActionEvent event) {
        try {
            CarteFideliteService aaa = new CarteFideliteService();
            aaa.update("hatem1");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
