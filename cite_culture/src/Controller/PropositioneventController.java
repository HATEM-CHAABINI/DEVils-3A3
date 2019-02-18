/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.PropositionEvent;
import Services.PropositionEventService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author mouna dridi
 */
public class PropositioneventController implements Initializable {

    
    PropositionEvent p =new PropositionEvent();

    @FXML
    private ComboBox<String> type;
    @FXML
    private Button envoyer;
    @FXML
    private Button annuler;
    @FXML
    private TextField description;
    @FXML
    private TextField titre;
    @FXML
    private TableView<PropositionEvent> table;
    
    @FXML
    private TableColumn<PropositionEvent, Integer> id;
    @FXML
    private TableColumn<PropositionEvent, String> typeE;
    @FXML
    private TableColumn<PropositionEvent, String> desc;
    @FXML
    private TableColumn<PropositionEvent, String> titre1;
    @FXML
    private TableColumn<PropositionEvent, String> etat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            type.getItems().addAll("Film","Theatre","Conference","Galerie");
            PropositionEventService artc = new PropositionEventService();
            table.setItems(artc.afficherPEvent());
            id.setCellValueFactory(new PropertyValueFactory<>("idPEvent"));
            typeE.setCellValueFactory(new PropertyValueFactory<>("typeEvent"));
            desc.setCellValueFactory(new PropertyValueFactory<>("description"));
            titre1.setCellValueFactory(new PropertyValueFactory<>("titre")); 
            etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
            setCellValueFromTableToTextField();

    }    

    @FXML
    private void ajouterProposition(ActionEvent event)throws ClassNotFoundException {
        
        String type=this.type.getValue();
        String description=this.description.getText();
        String titre=this.titre.getText();
        PropositionEvent e=new PropositionEvent(type,description,titre,"mouna");
        PropositionEventService fS=new PropositionEventService();
        fS.ajouterPEvent(e);
        table.setItems(fS.afficherPEvent());


    }

    @FXML
    private void annulerProposition(ActionEvent event) {
        
            PropositionEventService fs=new PropositionEventService();
            fs.supprimerPEvent(p);
            titre.clear();
            description.clear();
            table.setItems(fs.afficherPEvent());
            id.setCellValueFactory(new PropertyValueFactory<>("idPEvent"));
            typeE.setCellValueFactory(new PropertyValueFactory<>("typeEvent"));
            desc.setCellValueFactory(new PropertyValueFactory<>("description"));
            titre1.setCellValueFactory(new PropertyValueFactory<>("titre")); 
            p=new PropositionEvent();
    }
     private void setCellValueFromTableToTextField()
    {
            table.setOnMouseClicked(e -> {
            PropositionEvent a1 = table.getItems().get(table.getSelectionModel().getSelectedIndex());
            titre.setText(a1.getTitre());
            description.setText(a1.getDescription());
            type.setValue(a1.getTypeEvent());
            p.setIdPEvent(a1.getIdPEvent()); 
        });
    }
    
}
