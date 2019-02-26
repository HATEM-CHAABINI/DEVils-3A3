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
import javafx.scene.control.Label;
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
    private ComboBox<String> typeS;
    @FXML
    private JFXTextField limite;
    @FXML
    private JFXTextField des;
    
ObservableList<String> listS = FXCollections.observableArrayList("Cinema","Theatre","Gallerie","Formation");
    @FXML
    private JFXTextField idS;
    @FXML
    private Button supp;
    @FXML
    private Button addS;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          typeS.setItems(listS);
        try {
             SalleService sa = new SalleService() ;
            tblS.setItems(sa.displayall());
            
            Des.setCellValueFactory(new PropertyValueFactory<>("designation") );
            TypeS.setCellValueFactory(new PropertyValueFactory<>("type"));
            EtatS.setCellValueFactory(new PropertyValueFactory<>("etat"));
            
                LimiteS.setCellValueFactory(new PropertyValueFactory<>("limit"));
               
            
            
        
            
                
            setCellValueFromTableToTextField();
        } catch (ClassNotFoundException ex) {
           
        }
        
    }    
    private void setCellValueFromTableToTextField()
    {
        tblS.setOnMouseClicked(e -> {
           Salle s = tblS.getItems().get(tblS.getSelectionModel().getSelectedIndex());
           
            idS.setText(String.valueOf(s.getId_salle()));
            des.setText(s.getDesignation());
           limite.setText(String.valueOf(s.getLimit()));
          
            });
    
    
    }

    @FXML
    private void add(ActionEvent event) {
        boolean isDesEmpty=validation.TextFieldValidation.isTextFieldNotEmpty(des, label2, "designation is required");
        boolean isLimitEmpty=validation.TextFieldValidation.isTextFieldNotEmpty(des, label3, "designation is required");
        if(isDesEmpty && isLimitEmpty && (typeS.getSelectionModel().getSelectedIndex()!=-1)){
       try {
        String designation=this.des.getText();
        int limit=Integer.valueOf(this.limite.getText());
        
        String type=    typeS.getSelectionModel().getSelectedItem().toString();
        
        
         label1.setText("");
            label2.setText("");
        label3.setText("");
        Salle S = new Salle (type,designation,"Libre",limit);
        SalleService sa =new SalleService();
        sa.ajouterSalle(S);
        
        
            tblS.setItems(sa.displayall());
            
            Des.setCellValueFactory(new PropertyValueFactory<>("designation") );
            TypeS.setCellValueFactory(new PropertyValueFactory<>("type"));
            EtatS.setCellValueFactory(new PropertyValueFactory<>("etat"));
            
                LimiteS.setCellValueFactory(new PropertyValueFactory<>("limit"));
               
            
            
        
            
                
            //setCellValueFromTableToTextField();
        } catch (ClassNotFoundException ex) {
           
        }
        }
        else{
       
        label1.setText("Choisir un client");
        
        }
    
    
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
        try {
            SalleService sa =new SalleService();
            sa.SupprimerSalle(Integer.valueOf(idS.getText()));
            
            
            tblS.setItems(sa.displayall());
            
            Des.setCellValueFactory(new PropertyValueFactory<>("designation") );
            TypeS.setCellValueFactory(new PropertyValueFactory<>("type"));
            EtatS.setCellValueFactory(new PropertyValueFactory<>("etat"));
            
            LimiteS.setCellValueFactory(new PropertyValueFactory<>("limit"));
            idS.clear();
            limite.clear();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalleController.class.getName()).log(Level.SEVERE, null, ex);
        }
               
            
            
        
    }

   
}
