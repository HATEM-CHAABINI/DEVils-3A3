/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
import Services.UtilisateurService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author hatem
 */
public class ValiderController implements Initializable {

int n;
    @FXML
    private JFXTextField idNum;
    @FXML
    private JFXButton valid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void valider(ActionEvent event) {
        
        
    }
    
    public void setUN(Utilisateur ut,int nbra) throws ClassNotFoundException
    {
   UtilisateurService s= new UtilisateurService();
   
    this.n=nbra;
    if (nbra==Integer.valueOf(this.idNum.getText()))
    {s.ajouterUtilisateur(ut);
    }
    else{
        System.out.println("Code erroné");
    }
    }    
}
