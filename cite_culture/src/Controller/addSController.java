/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Salle;
import Services.SalleService;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javax.swing.JFrame;

/**
 * FXML Controller class
 *
 * @author Nitro
 */
public class addSController implements Initializable {
ObservableList<String> listS = FXCollections.observableArrayList("Cinema","Theatre","Gallerie","Formation");
    @FXML
    private ComboBox typeS;
    @FXML
    private JFXTextField limite;
    @FXML
    private JFXTextField des;
    @FXML
    private Button addS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeS.setItems(listS);
    }    

    @FXML
    private void add(ActionEvent event) {
        
        
    try {
        String designation=this.des.getText();
        int limit=Integer.valueOf(this.limite.getText());
        
        String type=    typeS.getSelectionModel().getSelectedItem().toString();
        
        
        System.out.println("**********************");
        System.out.println(designation);
        System.out.println(limit);
        System.out.println(type);
        System.out.println("**********************");
        
        Salle S = new Salle (type,designation,"Libre",limit);
        SalleService sa =new SalleService();
        sa.ajouterSalle(S);
        
    } catch (ClassNotFoundException ex) {
       System.err.println("SQLException: " + ex.getMessage());
    }
    
    
    
    }
    
}
