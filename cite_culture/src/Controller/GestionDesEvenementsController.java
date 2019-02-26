/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khalil
 */
public class GestionDesEvenementsController implements Initializable {
     @FXML
    private JFXButton film;
    @FXML
    private JFXButton theatre;
    @FXML
    private JFXButton conference;
    @FXML
    private JFXButton galerie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    private void sendToFilm(ActionEvent event) {
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/film.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE,null,ex);
        
        }
       
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();
             
       
    }

    @FXML
    private void sendToTheatre(ActionEvent event) {
         FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/theatre.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE,null,ex);
        
        }
       
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();
    }

    @FXML
    private void sendToConference(ActionEvent event) {
         FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/conference.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE,null,ex);
        
        }
       
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();
    }

    @FXML
    private void sendToGalerie(ActionEvent event) {
         FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/galerie.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE,null,ex);
        
        }
       
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();
    }
    
}
