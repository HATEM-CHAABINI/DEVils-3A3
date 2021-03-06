/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
import Entities.Reclamation;
import Entities.Salle;
import Services.CarteFideliteService;
import Services.ReclamationService;
import Services.SalleService;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import org.controlsfx.control.Notifications;
import utilitaire.ConnectedUser;
import utilitaire.UserSession;
import validation.TextFieldValidation;
/**
 * FXML Controller class
 *
 * @author Nitro
 */
public class GestionRecCController implements Initializable {

   
   
    @FXML
    private TextField TextR;
   
   
    @FXML
    private ComboBox<String> typeR;
    
    ObservableList<String> listS = FXCollections.observableArrayList("Sanitaire","Equipement","Autre");
    @FXML
    private AnchorPane tbIRec;
    @FXML
    private ToggleGroup menu;
    @FXML
    private ComboBox<String> SalleRec;
    @FXML
    private Text SR;
   
    @FXML
    private Pagination pagination;
    
    private final static int rowsPerPage = 3;    

    private final TableView<Reclamation> table = createTable();
     private final List<Reclamation> data = createData();   
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    private TableView<Reclamation> createTable() {

       TableView<Reclamation> table = new TableView<>();

        TableColumn<Reclamation, String> TypeR = new TableColumn<>("type");
       TypeR.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> c) {
            return new SimpleStringProperty(c.getValue().getType());
        }
            });

        TableColumn<Reclamation, String> textR = new TableColumn<>("Text");
        textR.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> c) {
            return new SimpleStringProperty(c.getValue().getText());
        }
            });
        TableColumn<Reclamation, String> EtatR = new TableColumn<>("Etat");
        EtatR.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> c) {
            return new SimpleStringProperty(c.getValue().getEtat());
        }
            });
        
         TableColumn<Reclamation, String> SalleRR = new TableColumn<>("Salle");
        SalleRR.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> c) {
            return new SimpleStringProperty(c.getValue().getSalle().getDesignation());
        }
            });
        table.getColumns().addAll(TypeR, textR,EtatR,SalleRR);
        return table;       
    }
    
    
      private List<Reclamation> createData() {
                ReclamationService SS = null;
        try {
            SS = new ReclamationService();
        } catch (ClassNotFoundException ex) {
           
        }
        
        ReclamationService sa = null ;
        try {
            sa = new ReclamationService();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionRecCController.class.getName()).log(Level.SEVERE, null, ex);
        }
             UserSession session=new UserSession();
        Utilisateur u= new Utilisateur();
            u=session.getUser();
          
                 ObservableList<Reclamation> li =  sa.findByUsername(u.getUsername());
                    
    
        
            
      List<Reclamation> data = new ArrayList<>();
     
       
        
            data.addAll(li);
       

        return data;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         pagination.setPageFactory(this::createPage);   
         typeR.setItems(listS);
         SalleService SS = null;
        try {
            SS = new SalleService();
        } catch (ClassNotFoundException ex) {
           
        }
        
              ObservableList<Salle> listSalle =FXCollections.observableArrayList(SS.displayall());
                            ObservableList<String> listSalle2 =FXCollections.observableArrayList();
int index=0;
          while (  index < listSalle.size()) {
            listSalle2.add(listSalle.get(index).getDesignation());

            index++;
        }
            SalleRec.setItems(listSalle2);
        try {
            java.sql.Date d=new java.sql.Date(2018, 01, 16);
            
            ReclamationService sa = new ReclamationService() ;
             UserSession session=new UserSession();
    
            Utilisateur u= new Utilisateur();
            u=session.getUser();
            table.setItems(sa.findByUsername(u.getUsername()));
          
          
           
                    
        } catch (ClassNotFoundException ex) {
          
        }
           
    }    

    private Node createPage(int pageIndex) {
        int fromIndex = pageIndex * rowsPerPage;
        int toIndex = Math.min(fromIndex + rowsPerPage, data.size());
        table.setItems(FXCollections.observableArrayList(data.subList(fromIndex, toIndex)));
        return table;
    }

    @FXML
    private void ajouter(ActionEvent event) {
         boolean isTypeEmpty=validation.TextFieldValidation.isTextFieldNotEmpty(TextR, label2, "Message is required");
        if(isTypeEmpty && (typeR.getSelectionModel().getSelectedIndex()!=-1)){
        try {
             java.sql.Date d=new java.sql.Date(2018, 01, 16);
           UserSession session=new UserSession();
    
            Utilisateur u= new Utilisateur();
            u=session.getUser();
            SalleService SS = null;
        try {
            SS = new SalleService();
        } catch (ClassNotFoundException ex) {
           
        } 
       
            String t=typeR.getSelectionModel().getSelectedItem();
            String txtrr=this.TextR.getText();
          //  String x = SS.rechercheSalleParID(SalleRec.getSelectionModel().getSelectedItem();)
            Salle  s= SS.rechercheSalleParID(SalleRec.getSelectionModel().getSelectedItem());
            Reclamation r;
            r = new Reclamation (t,txtrr,s);
          
            ReclamationService sa =new ReclamationService();
            sa.addR(r, u);
            CarteFideliteService aaa = new CarteFideliteService();
            aaa.update(u.getUsername());
            TextR.clear();
            label1.setText("");
            label3.setText("");
            table.setItems(sa.findByUsername(u.getUsername()));
            System.out.println(u.getUsername());
            Notifications.create()
                    .title("Notification ")
                    .text("Votre réclamation a ete ajoute avec succes").darkStyle()
                    .showWarning();
        } catch (ClassNotFoundException ex) {
           
        }
        }
        else{
       
        label1.setText("Choisir un type");
        label3.setText("Choisir une salle");
        }
           
           
         
    }


    @FXML
    private void supprimerRec(ActionEvent event) {
         if (!table.getSelectionModel().isEmpty()) {
    
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("suppression d'une salle");
                alert.setHeaderText("etes-vous sur que vous voulez supprimer cette Salle :  "
                        + table.getSelectionModel().getSelectedItem().getId_reclamation());
                Optional<ButtonType> result = alert.showAndWait();
            
                if (result.get() == ButtonType.OK) {
                    try {
                        java.sql.Date d=new java.sql.Date(2018, 01, 16);
                         Utilisateur c3=new Utilisateur("hatem4", "Hatem4@gmail.com", "aa", "AA", "Chaabini","Hatem", "Tunis", d,"Rades Foret",2040, "Homme",50459936,40009484);
                        ReclamationService abc =new ReclamationService();
                        abc.remove(table.getSelectionModel().getSelectedItem().getId_reclamation());
                          table.setItems(abc.findByUsername(c3.getUsername()));
             Notifications.create()
                    .title("Notification ")
                    .text("Votre réclamation a ete Supprimé avec succes").darkStyle()
                    .showWarning();
                            } catch (ClassNotFoundException ex) {
                        Logger.getLogger(GestionRecCController.class.getName()).log(Level.SEVERE, null, ex);
                 
                }   catch (NoSuchAlgorithmException ex) {
                       
                    }

            }
       
    }
    
    }}
