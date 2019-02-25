/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
import Services.JournalisteService;
import Services.UtilisateurService;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
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
    @FXML
    private Button BloquerDebloquer;
    @FXML
    private Button Banir;
                 ObservableList<Utilisateur> TousLesUtilisateur = FXCollections.observableArrayList();
    @FXML
    private JFXTextField rechercheUti;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            UtilisateurService cs= new UtilisateurService();
            JournalisteService js=new JournalisteService();
            ListUtilisateur=cs.oTousLesUtilisateurs();
            ListUtilisateur.addAll(js.oTousLesJournalistes());
            TousLesUtilisateur=ListUtilisateur;
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
/*
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
		FilteredList<Utilisateur> filteredData = new FilteredList<>(ListUtilisateur, p -> true);

rechercheUti.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (person.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} else if (person.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Utilisateur> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table.setItems(sortedData);

/*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
                                 
                                 */                                 
                                 
                                 
                                 

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    


    @FXML
    private void afficheruti(ActionEvent event) throws ClassNotFoundException {
        UtilisateurService cs= new UtilisateurService();
            ListUtilisateur=cs.oTousLesUtilisateurs();
           
         table.setItems(ListUtilisateur);
         
         /*
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
		FilteredList<Utilisateur> filteredData = new FilteredList<>(ListUtilisateur, p -> true);

rechercheUti.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (person.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} else if (person.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Utilisateur> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table.setItems(sortedData);

/*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
                                 
                                 */                                 
                                 
         
                               
    }

    @FXML
    private void afficherNonActiver(ActionEvent event) throws ClassNotFoundException {
          UtilisateurService cs= new UtilisateurService();
            ListUtilisateur=cs.oUtilisateurNonActiver();
             table.setItems(ListUtilisateur);
                               
            /*
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
		FilteredList<Utilisateur> filteredData = new FilteredList<>(ListUtilisateur, p -> true);

rechercheUti.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (person.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} else if (person.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Utilisateur> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table.setItems(sortedData);

/*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
                                 
                                 */                                 
                                 
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
         /*
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
		FilteredList<Utilisateur> filteredData = new FilteredList<>(ListUtilisateur, p -> true);

rechercheUti.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (person.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} else if (person.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Utilisateur> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table.setItems(sortedData);

/*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
                                 
                                 */                                 
                                 
    }

    @FXML
    private void afficherjourNonActiver(ActionEvent event) throws ClassNotFoundException {
             JournalisteService js= new JournalisteService();
            ListUtilisateur=js.oJournalisteNonActiver();
             table.setItems(ListUtilisateur);
             /*
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
		FilteredList<Utilisateur> filteredData = new FilteredList<>(ListUtilisateur, p -> true);

rechercheUti.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (person.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} else if (person.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Utilisateur> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table.setItems(sortedData);

/*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                 
                                 
                                 */                                 
                                 
    }


    @FXML
    private void BloquerDebloquer(ActionEvent event) throws ClassNotFoundException {
          UtilisateurService cs= new UtilisateurService();

        Utilisateur client=table.getSelectionModel().getSelectedItem();
        System.out.println(client.getEnabled());
        if (client.getEnabled()==1){
       cs.updateEnable(0,client.getUsername());}
        else{       cs.updateEnable(1,client.getUsername());}

            JournalisteService js=new JournalisteService();

            ListUtilisateur=cs.oTousLesUtilisateurs();
            ListUtilisateur.addAll(js.oTousLesJournalistes());
         
         table.setItems(ListUtilisateur);
                                   }

    @FXML
    private void Banir(ActionEvent event) throws ClassNotFoundException {

        UtilisateurService cs= new UtilisateurService();

        Utilisateur client=table.getSelectionModel().getSelectedItem();
        System.out.println(client.getUsername());
       cs.Bannir(client.getUsername());
    }
/*

    private void RechercheU(KeyEvent event) {
        
            idUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
            idEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            idNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            idPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            idAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                  idActiver.setCellValueFactory(new PropertyValueFactory<>("enabled"));
                                table.setItems(TousLesUtilisateur);
                                table.setEditable(true);
                                 idEmail.setCellFactory(TextFieldTableCell.forTableColumn());
                                 idActiver.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    }*/

}
