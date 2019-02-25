/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.publication;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class Form_publicationController implements Initializable {

    @FXML
    private Label nom_pub;
    @FXML
    private Label titre;
    @FXML
    private Label sujet;
    @FXML
    private Label auteur;
    @FXML
    private Label ref_pub;
    @FXML
    private Label contenu;
    @FXML
    private Label date_pub;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    

    

    @FXML
    private void voirDetails(ActionEvent event) throws ClassNotFoundException, ClassNotFoundException {
        publication pub =new publication();
       pub.setContenu_pub(contenu.getText());
       int ref=Integer.valueOf(ref_pub.getText());
       pub.setRef(ref);
       pub.setNom_publication(nom_pub.getText());
       pub.setNom_auteur(auteur.getText());
       pub.setTitre(titre.getText());
       pub.setSujet(sujet.getText());
  FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/details_publication.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(Form_publicationController.class.getName()).log(Level.SEVERE,null,ex);
        
        }
        Details_publicationController display=loader.getController();
        display.setpub(pub);
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();
    }
    
}
