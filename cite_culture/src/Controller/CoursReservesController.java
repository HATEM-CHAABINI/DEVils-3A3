/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.ReservationCoursService;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Farah
 */
public class CoursReservesController implements Initializable {

    @FXML
    private Label type;
    @FXML
    private Label heure_d;
    @FXML
    private Label date;
    @FXML
    private Label email;
    @FXML
    private Label salle;
    @FXML
    private Label prix;
    @FXML
    private Button annuler;
    @FXML
    private Label id;
    @FXML
    private Label nom_client;
    @FXML
    private Label nom_prof;
    @FXML
    private Label prenom_client;
    @FXML
    private Label prenom_prof;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Pane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void annulerReservation(ActionEvent event) throws ClassNotFoundException, SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Confirmation");
alert.setHeaderText("Vous êtes sur le point d'annuler votre réservation");
alert.setContentText("Etes-vous sur de vouloir le faire ?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    
     ReservationCoursService rs=new ReservationCoursService();
       
       int id= rs.getIdCours(Integer.valueOf(this.id.getText()));
       
        rs.modifierNb_Places(id);
       rs.supprimerReservationCours(Integer.valueOf(this.id.getText()));
        
       // this.test.setText("1");
       this.anchor.getChildren().removeAll(pane);
    // ... user chose OK
} else {
    //System.out.println("oooooo");
    // ... user chose CANCEL or closed the dialog
}
        //Reservation r=new Reservation();
       
       
                
    }
}
