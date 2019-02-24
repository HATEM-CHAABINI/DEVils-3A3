/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Employe;
import Entities.Reclamation;
import Entities.Tache;
import Entities.Utilisateur;
import Services.EmployeService;
import Services.ReclamationService;
import Services.TacheService;
import Services.EmployeService;
import Services.ReclamationService;
import Services.TacheService;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Nitro
 */
public class AdminRecController implements Initializable {

    @FXML
    private JFXTextField type_r;
    @FXML
    private JFXTextField text;
    private JFXTextField etat;
    @FXML
    private TableView<Reclamation> tblR;
    @FXML
    private TableColumn<Reclamation, String> TypeR;
    @FXML
    private TableColumn<Reclamation, String> textR;
    @FXML
    private TableColumn<Reclamation, String> EtatR;
    @FXML
    private TableColumn<Reclamation, Integer> idR;
    @FXML
    private TableColumn<Reclamation, String>RR;
    @FXML
    private TableColumn<Reclamation, String> NomR;
    @FXML
    private TableColumn<Reclamation, String>PrenomR;
    @FXML
    private TableColumn<Reclamation, Integer> TelR;
    @FXML
    private TableColumn<Reclamation, String> MailR;
    @FXML
    private Button traiterR;
    @FXML
    private TableView<Utilisateur> tblE;
    @FXML
    private TableColumn<Utilisateur, String> NomE;
    @FXML
    private TableColumn<Utilisateur, String> PrenomE;
    @FXML
     private TableColumn<Utilisateur, String> cinE;
    @FXML
    private JFXTextField cin2;
    @FXML
    private JFXTextField idR2;
    @FXML
    private TableColumn<Reclamation, String> SalleR;
   
    

   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        try {
            ReclamationService sa = new ReclamationService() ;
            tblR.setItems(sa.displayallR());
            idR.setCellValueFactory(new PropertyValueFactory<>("id_reclamation") );
            TypeR.setCellValueFactory(new PropertyValueFactory<>("type") );
            textR.setCellValueFactory(new PropertyValueFactory<>("text"));
            RR.setCellValueFactory(new PropertyValueFactory<>("username_client"));
            SalleR.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> c) {
            return new SimpleStringProperty(c.getValue().getSalle().getDesignation());
        }
            });
                NomR.setCellValueFactory(new PropertyValueFactory<>("nom_client"));
                PrenomR.setCellValueFactory(new PropertyValueFactory<>("prenom_client"));
            TelR.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            
            MailR.setCellValueFactory(new PropertyValueFactory<>("email_client"));
            EtatR.setCellValueFactory(new PropertyValueFactory<>("etat"));
            
             EmployeService cs = new EmployeService();
            tblE.setItems(cs.oTousLesEmploye());
             NomE.setCellValueFactory(new PropertyValueFactory<>("nom"));
            PrenomE.setCellValueFactory(new PropertyValueFactory<>("prenom"));
             cinE.setCellValueFactory(new PropertyValueFactory<>("cin"));
        
            
                
            setCellValueFromTableToTextField();
            setCellValueFromTableToTextField2();
        } catch (ClassNotFoundException ex) {
           
        }
        
    }    
private void setCellValueFromTableToTextField()
    {   tblR.setOnMouseClicked(e -> {
        Reclamation r = tblR.getItems().get(tblR.getSelectionModel().getSelectedIndex());
        String  y=String.valueOf(r.getId_reclamation());
        idR2.setText(y);
        type_r.setText(r.getType());
        text.setText(r.getText());
        etat.setText(r.getEtat());
        
        
    });
    
    }
private void setCellValueFromTableToTextField2()
    {
        tblE.setOnMouseClicked(e -> {
           Utilisateur x = tblE.getItems().get(tblE.getSelectionModel().getSelectedIndex());
            String  y=String.valueOf(x.getCin());
           cin2.setText(y);
           
           
           
            });
    
    
    }
    @FXML
    private void traiterREC(ActionEvent event)
    {
        try {
            int id=Integer.valueOf(this.idR2.getText());
            String desc=this.text.getText();
            int CIN=Integer.valueOf(this.cin2.getText());
            Tache t = new Tache(CIN,id,desc);
            TacheService ts= new TacheService();
            ts.ajouterTache(t);
            ReclamationService  rs = new ReclamationService();
            rs.update2(id);
             ReclamationService sa = new ReclamationService() ;
            tblR.setItems(sa.displayallR());
            idR.setCellValueFactory(new PropertyValueFactory<>("id_reclamation") );
            TypeR.setCellValueFactory(new PropertyValueFactory<>("type") );
            textR.setCellValueFactory(new PropertyValueFactory<>("text"));
            RR.setCellValueFactory(new PropertyValueFactory<>("username_client"));
            
                NomR.setCellValueFactory(new PropertyValueFactory<>("nom_client"));
                PrenomR.setCellValueFactory(new PropertyValueFactory<>("prenom_client"));
            TelR.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            
            MailR.setCellValueFactory(new PropertyValueFactory<>("email_client"));
            EtatR.setCellValueFactory(new PropertyValueFactory<>("etat"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminRecController.class.getName()).log(Level.SEVERE, null, ex);
             
        }
            
    }
}

//    @FXML
//    private void addR(ActionEvent event) throws ClassNotFoundException {
//      
//       boolean isTypeEmpty=validation.TextFieldValidation.isTextFieldNotEmpty(type_r, error_type, "type is required");
//       boolean isTextEmpty=validation.TextFieldValidation.isTextFieldNotEmpty(text, error_etat, "text is required");
//      // boolean islimiteEmpty=validation.TextFieldValidation.isTextFieldNotEmpty(limite, error_limite, "limite is required");
//        //boolean islimiteNImber=validation.TextFieldValidation.isTextFieldNotNumber(limite, error_limite, "limite must be a number");
//
//        if ( isTextEmpty && isTypeEmpty) {
//            String type1=this.type_r.getText();
//         String text1=this.text.getText();
//           
//   
//        System.out.println("**********************");
//        System.out.println(type1);
//        System.out.println(text1);
//        
//        System.out.println("**********************");
//        
//            Reclamation r = new Reclamation (type1,text1);
//        ReclamationService sa =new ReclamationService();
//        sa.addR(r, c);
//       type_r.clear();
//            text.clear();
//           
//            tblR.setItems(sa.findByUsername("hatem2"));
//            
//            TypeR.setCellValueFactory(new PropertyValueFactory<>("type") );
//            textR.setCellValueFactory(new PropertyValueFactory<>("text"));
//            etatR.setCellValueFactory(new PropertyValueFactory<>("etat"));
//        }
       
//       
//        
//    }
//     @FXML
//        private void cancel(ActionEvent event) {
//        System.exit(0);
//    } 
//
//    private void reserve(ActionEvent event) { 
//           
//        try {
//            SalleService sa = new SalleService();
//            int id_salle=Integer.valueOf(this.idsalle.getText());
//            sa.modify(id_salle);
//           
//            idsalle.clear();
//            type.clear();
//            etat.clear();
//            limite.clear();
//            tblS.setItems(sa.displayall());
//            
//            id_s.setCellValueFactory(new PropertyValueFactory<>("id_salle") );
//            ts.setCellValueFactory(new PropertyValueFactory<>("type"));
//            es.setCellValueFactory(new PropertyValueFactory<>("etat"));
//            ls.setCellValueFactory(new PropertyValueFactory<>("limit"));
//       
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AdminRecController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    @FXML
//    private void supp(ActionEvent event) {
//         try {
//            SalleService sa = new SalleService();
//            int id_salle=Integer.valueOf(this.idsalle.getText());
//           sa.SupprimerSalle(id_salle);
//            idsalle.clear();
//            type.clear();
//            etat.clear();
//            limite.clear();
//           
//           
//            tblS.setItems(sa.displayall());
//            
//            id_s.setCellValueFactory(new PropertyValueFactory<>("id_salle") );
//            ts.setCellValueFactory(new PropertyValueFactory<>("type"));
//            es.setCellValueFactory(new PropertyValueFactory<>("etat"));
//            ls.setCellValueFactory(new PropertyValueFactory<>("limit"));
//       
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AdminRecController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//         
//    @FXML
//        public void search()
//        {
//         try {
//            SalleService sa = new SalleService() ;
//            int id_salle=Integer.valueOf(this.idR.getText());
//            tblS.setItems(sa.rechercheSalleParID(id_salle));
//            
//            id_s.setCellValueFactory(new PropertyValueFactory<>("id_salle") );
//            ts.setCellValueFactory(new PropertyValueFactory<>("type"));
//            es.setCellValueFactory(new PropertyValueFactory<>("etat"));
//            ls.setCellValueFactory(new PropertyValueFactory<>("limit"));
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AdminRecController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//           
//        
//        }


                 
       
        
    

   
   


