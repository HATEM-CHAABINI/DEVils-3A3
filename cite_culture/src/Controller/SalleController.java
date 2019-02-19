/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Salle;
import Services.SalleService;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nitro
 */
public class SalleController implements Initializable {

    @FXML
    private TableView<Salle> tblS;
    @FXML
    private TableColumn<Salle, ?> Des;
    @FXML
    private TableColumn<Salle, ?> TypeS;
    @FXML
    private TableColumn<Salle, ?> EtatS;
    @FXML
    private TableColumn<Salle, ?> LimiteS;
    @FXML
    private Button add;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             SalleService sa = new SalleService() ;
            tblS.setItems(sa.displayall());
            
            Des.setCellValueFactory(new PropertyValueFactory<>("designation") );
            TypeS.setCellValueFactory(new PropertyValueFactory<>("type"));
            EtatS.setCellValueFactory(new PropertyValueFactory<>("etat"));
            
                LimiteS.setCellValueFactory(new PropertyValueFactory<>("limit"));
               
            
            
        
            
                
            //setCellValueFromTableToTextField();
        } catch (ClassNotFoundException ex) {
           
        }
        
    }    
//    private void setCellValueFromTableToTextField()
//    {
//        tblS.setOnMouseClicked(e -> {
//           Salle s = tblS.getItems().get(tblS.getSelectionModel().getSelectedIndex());
//           
//            type_r.setText(r.getType());
//            text.setText(r.getText());
//            etat.setText(r.getEtat());
//           
//            });
//    
//    
//    }

    @FXML
    private void add(ActionEvent event) {
        
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/addS.fxml"));
        
        
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AdminRecController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            Parent p =loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.showAndWait();
            stage.close();
        
    }
}
