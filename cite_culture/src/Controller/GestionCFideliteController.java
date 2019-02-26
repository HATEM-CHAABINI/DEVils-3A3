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
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Nitro
 */
public class GestionCFideliteController implements Initializable {

    @FXML
    private AnchorPane tbIDcarte;
    @FXML
    private TableView<CarteFidelite> TableCarteF;
    @FXML
    private TableColumn<CarteFidelite, String> tbnomclient;
    @FXML
    private TableColumn<CarteFidelite, String> tbprenomclient;
    @FXML
    private TableColumn<CarteFidelite, String> tbnbrpoint;
    @FXML
    private TableColumn<CarteFidelite, Date> tbdatecreation;
    @FXML
    private Label lbTitulo1;
    @FXML
    private ToggleGroup menu;
    @FXML
    private Button TGB;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            UtilisateurService iu = new UtilisateurService ();
            ObservableList<Utilisateur> ListC = FXCollections.observableArrayList(iu.tousLesUtilisateurs());
            
        
            
            TableCarteF.getSelectionModel().selectedItemProperty().
                    addListener((observable, oldValue, newValue) -> {
                    });
            
            afficher();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionCFideliteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    

//    @FXML
//    private void rechercherB(ActionEvent event) {
//      
//       
//        try {
//            CarteFideliteService aaa = new CarteFideliteService();
//            
//            TableCarteF.setItems(aaa.findCartebyID(txtPesquisar.getText()));
//            
//            tbnbrpoint.setCellValueFactory(new PropertyValueFactory<>("nb_point"));
//            tbdatecreation.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
//            
//           
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(GestionCFideliteController.class.getName()).log(Level.SEVERE, null, ex);
//        }}

    

   
    @FXML
    private void supprimerCarte(ActionEvent event) {
        try {

            if (!TableCarteF.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("suppression de carte de fidelité");
                alert.setHeaderText("etes-vous sur que vous voulez supprimer cette carte :  "
                        + TableCarteF.getSelectionModel().getSelectedItem().getId_carte_fidelite());
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    CarteFideliteService abc = new CarteFideliteService();
                    abc.remove(TableCarteF.getSelectionModel().getSelectedItem().getId_carte_fidelite());
                    afficher();
                }

            }
        } catch (Exception ex) {
            System.out.println("erreur lors du chargement des forums " + ex.getMessage());

        }
    }
 void afficher(){try {
            CarteFideliteService aaa = new CarteFideliteService();
            ///   User aea = new User();
            
            TableCarteF.setItems(aaa.displayall());
           
            tbnomclient.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CarteFidelite, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<CarteFidelite, String> param) {
                    return new SimpleStringProperty(param.getValue().getUser().getNom());
                }
            });
            
            tbprenomclient.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CarteFidelite, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<CarteFidelite, String> param) {
                    return new SimpleStringProperty(param.getValue().getUser().getPrenom());
                }
            });
            
            tbnbrpoint.setCellValueFactory(new PropertyValueFactory<>("nb_point"));
            tbdatecreation.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionCFideliteController.class.getName()).log(Level.SEVERE, null, ex);
        }} 

    @FXML
    private void TG(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/Winner.fxml"));
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
