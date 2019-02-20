/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
import Services.JournalisteService;
import Services.UtilisateurService;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author hatem
 */
public class AdminController implements Initializable {
    //@FXML
   // private TableColumn<Utilisateur,Integer> idId;
    @FXML
    private TableColumn<Utilisateur,String> idUsername;
    @FXML
    private TableColumn<Utilisateur,String> idEmail;
    @FXML
    private TableColumn<Utilisateur,Integer> idActiver;
    @FXML
    private Button idUt;
    @FXML
    private Button idNonActiv;

    
             ObservableList<Utilisateur> ListUtilisateur = FXCollections.observableArrayList();
    @FXML
    private TableView<Utilisateur> table;
    @FXML
    private TableColumn<Utilisateur,String> idNom;
    @FXML
    private TableColumn<Utilisateur,String> idPrenom;
    @FXML
    private TableColumn<Utilisateur,String> idAdresse;
    @FXML
    private Button idJour;
    @FXML
    private Button idjourNonActiv;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            UtilisateurService cs= new UtilisateurService();
            JournalisteService js=new JournalisteService();
            ListUtilisateur=cs.oTousLesUtilisateurs();
            ListUtilisateur.addAll(js.oTousLesJournalistes());
           // idId.setCellValueFactory(new PropertyValueFactory<>("id"));
            idUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
            idEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            idNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            idPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            idAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                  idActiver.setCellValueFactory(new PropertyValueFactory<>("enabled"));
                                table.setItems(ListUtilisateur);
                                table.setEditable(true);
                                 idEmail.setCellFactory(TextFieldTableCell.forTableColumn());
                                 idActiver.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    


    @FXML
    private void afficheruti(ActionEvent event) throws ClassNotFoundException {
        UtilisateurService cs= new UtilisateurService();
            ListUtilisateur=cs.oTousLesUtilisateurs();
           
         table.setItems(ListUtilisateur);
                               
    }

    @FXML
    private void afficherNonActiver(ActionEvent event) throws ClassNotFoundException {
          UtilisateurService cs= new UtilisateurService();
            ListUtilisateur=cs.oUtilisateurNonActiver();
             table.setItems(ListUtilisateur);
                               
            
    }
    @FXML
    private void ChangeEmail(TableColumn.CellEditEvent<Utilisateur, String> event) throws ClassNotFoundException {
                    UtilisateurService cs= new UtilisateurService();

        Utilisateur client=table.getSelectionModel().getSelectedItem();
       cs.updateMail(event.getNewValue(), client.getUsername());
    }

//    private void ChangeEmail(TableColumn.CellEditEvent<S, T> event) {
//    }

    @FXML
    private void ChangeActiver(TableColumn.CellEditEvent<Utilisateur,Integer> event) throws ClassNotFoundException {

        if (event.getNewValue()==1 ||event.getNewValue()==0){
        UtilisateurService cs= new UtilisateurService();

        Utilisateur client=table.getSelectionModel().getSelectedItem();
        System.out.println(client.getUsername());
       cs.updateEnable(event.getNewValue(),client.getUsername());
    }}

    @FXML
    private void afficherjour(ActionEvent event) throws ClassNotFoundException {
          JournalisteService js= new JournalisteService();
            ListUtilisateur=js.oTousLesJournalistes();
           
         table.setItems(ListUtilisateur);
    }

    @FXML
    private void afficherjourNonActiver(ActionEvent event) throws ClassNotFoundException {
             JournalisteService js= new JournalisteService();
            ListUtilisateur=js.oJournalisteNonActiver();
             table.setItems(ListUtilisateur);
    }

}
