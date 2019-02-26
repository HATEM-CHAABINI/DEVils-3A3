/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
    }

    @FXML
    private void sendToTheatre(ActionEvent event) {
    }

    @FXML
    private void sendToConference(ActionEvent event) {
    }

    @FXML
    private void sendToGalerie(ActionEvent event) {
    }
    
}
