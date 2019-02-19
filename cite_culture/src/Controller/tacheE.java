/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Tache;
import Services.TacheService;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Nitro
 */
public class tacheE implements Initializable {

    @FXML
    private TableView<Tache> tbleT;
    @FXML
    private TableColumn<Tache, String> TypeT;
    @FXML
    private TableColumn<Tache, String> TextE;
    @FXML
    private TableColumn<Tache, Integer> idT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            TacheService ts= new TacheService();
            tbleT.setItems(ts.rechercheTacheParID(10009484));
         
            TextE.setCellValueFactory(new PropertyValueFactory<>("desc") );
            idT.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(tacheE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    
}
