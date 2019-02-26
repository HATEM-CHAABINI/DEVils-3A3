/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Reservation;
import Entities.Ticket;
import Services.ReservationService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class FXMLController implements Initializable {

    private JFXTextField nom;
    private JFXTextField prenom;
    private JFXTextField mail;
    private DatePicker datee;
    private JFXTextField tel;
    private JFXTextField prix;
    private JFXTextField siege;
    private JFXTextField qr;
    private JFXTextField nom_evenement;
    private JFXTextField type;
    @FXML
    private TableColumn<Ticket, Integer> col_id;
    @FXML
    private TableColumn<Ticket, Date> col_date;
    @FXML
    private TableColumn<Ticket, String> col_nomev;
    @FXML
    private TableColumn<Ticket, String> col_type;
    private TableColumn<Ticket, String> col_nom;
    private TableColumn<Reservation, String> col_tel;
    private TableColumn<Reservation, String> col_siege;
    private TableColumn<Reservation, String> col_qr;
    private TableColumn<Reservation, Integer> col_nbplace;
    private TableColumn<Reservation, Integer> col_nbplaceres;
    @FXML
    private TableView<Ticket> tableReservation;
    private JFXTextField id;
    @FXML
    private Label k;
    @FXML
    private JFXTextField rech;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
        
           
        
        try {
            
            
            
            
            
            try {
                Ticket t=new Ticket();
                ReservationService r=new ReservationService();
                //System.out.println(r.afficherReseration().toString());
                
                
                
                
                tableReservation.setItems(r.afficherReseration());
                col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nomev.setCellValueFactory(new PropertyValueFactory<>("titre"));
                col_date.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("nom"));
                // col_nom.setCellValueFactory(new PropertyValueFactory<>("titre"));
//         col_nomev.setCellValueFactory(new PropertyValueFactory<>("nom_evenement"));
//         col_type.setCellValueFactory(new PropertyValueFactory<>("type_evenement"));
//         col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//         col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
//         col_tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
//         col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
//         col_siege.setCellValueFactory(new PropertyValueFactory<>("siege"));
//         col_qr.setCellValueFactory(new PropertyValueFactory<>("Qr"));
//         col_nbplace.setCellValueFactory(new PropertyValueFactory<>("nb_place"));
//         col_nbplaceres.setCellValueFactory(new PropertyValueFactory<>("nb_restant"));
//       
//        col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
//
//setCellValueFromTableToTextField();
//    }    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            
            
            
            
            Ticket t=new Ticket();
            ReservationService r=new ReservationService();
            r.afficherReseration();
            FilteredList<Ticket> filteredData = new FilteredList<>(r.afficherReseration(), p -> true);
            
            rech.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(person -> {
                    // If filter text is empty, display all persons.
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    
                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();
                    
                    if (person.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true; // Filter matches first name.
                    } else if (person.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true; // Filter matches last name.
                    }
                    return false; // Does not match.
                });
            });
            
            // 3. Wrap the FilteredList in a SortedList.
            SortedList<Ticket> sortedData = new SortedList<>(filteredData);
            
            // 4. Bind the SortedList comparator to the TableView comparator.
            // 	  Otherwise, sorting the TableView would have no effect.
            sortedData.comparatorProperty().bind(tableReservation.comparatorProperty());
            
            // 5. Add sorted (and filtered) data to the table.
            tableReservation.setItems(sortedData);
            
            
            
            
            
            
            
            
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
        
        
        
    }

    @FXML
    private void mouseClick(MouseEvent event) {
        try {
            Ticket a1 = tableReservation.getItems().get(tableReservation.getSelectionModel().getSelectedIndex());
            k.setText(String.valueOf(a1.getId()));
            
            Ticket t=new Ticket();
            ReservationService r=new ReservationService();
            t=r.getTicket(a1.getId());
            int i=r.nbplaceParEvent(a1.getId());
           /* System.out.println(t.toString());
            System.out.println(i);
            */
            
            
            
            
            
            
            
            Stage primaryStage=new Stage();
            Group root = new Group();
            Scene scene = new Scene(root,500,530);
            primaryStage.setScene(scene);
            
            
            
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("reservés("+i+")", i),
                    new PieChart.Data("nb total("+t.getNb_place()+")", t.getNb_place())
            );
            
            
            
            // StackedAreaChart stackedAreaChart = createStackedChart();
            //BarChart barChart = createBarChart();
            //LineChart lineChart = createLineChart();
            PieChart pieChart =new PieChart(pieChartData);
            // ScatterChart scatterChart = createScatterChart();
            
            //  TitledPane t1 = new TitledPane("Stacked Chart", stackedAreaChart);
            //TitledPane t2 = new TitledPane("Bar Chart", barChart);
            //TitledPane t3 = new TitledPane("Line Chart", lineChart);
            TitledPane t4 = new TitledPane("Pie Chart", pieChart);
            //TitledPane t5 = new TitledPane("Scatter Chart", scatterChart);
            
            
            Accordion accordion = new Accordion();
            //  accordion.getPanes().add(t1);
            // accordion.getPanes().add(t2);
            //accordion.getPanes().add(t3);
            accordion.getPanes().add(t4);
            //accordion.getPanes().add(t5);
            root.getChildren().add(accordion);
            accordion.setExpandedPane(t4);
            
            //  init(primaryStage);
            primaryStage.centerOnScreen();
            primaryStage.setTitle("FX Chart Demo");
            primaryStage.show();
            
            
            //  FXCharts a=new FXCharts();
            //a.createPieChart(4, 5);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
    }
}


/*
    
    
    
     
    @FXML
    private void valider(ActionEvent event) throws ClassNotFoundException {
        
    //Date date_reservation;
   
  
    
    String nomevenement=this.nom_evenement.getText();
    String mail_evenement=this.mail.getText();
    String nomT=this.nom.getText();
    String prenomT=this.prenom.getText();
    
    String telephone=this.tel.getText();
    float prixx=Integer.valueOf(this.prix.getText());
    String siegee=this.siege.getText();
    String Qr=this.qr.getText();
   java.sql.Date booom=java.sql.Date.valueOf(this.datee.getValue());
   String typee=this.type.getText();
    
   
   
   
        Date d=new java.sql.Date(1999, 02, 03);
       // Date d1=new Date(4, 12, 1997);
        
        //Reservation r=new Reservation(booom,nomevenement,typee,nomT,prenomT,mail_evenement,telephone,prixx,siegee,Qr,5,8);
        ReservationService r1=new ReservationService();
      //  r1.ajouterReservation(r);
    
    //setCellValueFromTableToTextField();
   
    
    
     
        try {
        ReservationService artc = new ReservationService();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
            
//         tableReservation.setItems(r1.afficherReseration());
         col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
         col_date.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
         col_nomev.setCellValueFactory(new PropertyValueFactory<>("nom_evenement"));
         col_type.setCellValueFactory(new PropertyValueFactory<>("type_evenement"));
         col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         col_tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
         col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
         col_siege.setCellValueFactory(new PropertyValueFactory<>("siege"));
         col_qr.setCellValueFactory(new PropertyValueFactory<>("Qr"));
         col_nbplace.setCellValueFactory(new PropertyValueFactory<>("nb_place"));
         col_nbplaceres.setCellValueFactory(new PropertyValueFactory<>("nb_restant"));
       
        col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        
       
     // setCellValueFromTableToTextField();
    
    
    
    
    
    
    }

    @FXML
    private void modifier(ActionEvent event) throws ClassNotFoundException {
        
    String nomevenement=this.nom_evenement.getText();
    String mail_evenement=this.mail.getText();
    String nomT=this.nom.getText();
    String prenomT=this.prenom.getText();
    
    String telephone=this.tel.getText();
    float prixx=Integer.valueOf(this.prix.getText());
    String siegee=this.siege.getText();
    String Qr=this.qr.getText();
   java.sql.Date booom=java.sql.Date.valueOf(this.datee.getValue());
   String typee=this.type.getText();
   
      int dd=Integer.valueOf(this.id.getText());
       // Reservation r2=new Reservation(booom,nomevenement,typee,nomT,prenomT,mail_evenement,telephone,prixx,siegee,Qr,8,9);
        //System.out.println("+++++++++++++++"+r2.toString());
       ReservationService r=new ReservationService();
      // r.modifierReservation(r2,dd);
       
       
       
       
       
       
       
        ReservationService artc = null;
        try {
            artc = new ReservationService();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
            
        
        
      //  tableReservation.setItems(r.afficherReseration());
         col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
         col_date.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
         col_nomev.setCellValueFactory(new PropertyValueFactory<>("nom_evenement"));
         col_type.setCellValueFactory(new PropertyValueFactory<>("type_evenement"));
         col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         col_tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
         col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
         col_siege.setCellValueFactory(new PropertyValueFactory<>("siege"));
         col_qr.setCellValueFactory(new PropertyValueFactory<>("Qr"));
         col_nbplace.setCellValueFactory(new PropertyValueFactory<>("nb_place"));
         col_nbplaceres.setCellValueFactory(new PropertyValueFactory<>("nb_restant"));
       
        col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
     // setCellValueFromTableToTextField();
       
        
    }
    
    */
   /* private void setCellValueFromTableToTextField()
    {
        tableReservation.setOnMouseClicked(e -> {
            Reservation a1 = tableReservation.getItems().get(tableReservation.getSelectionModel().getSelectedIndex());
          
            nom.setText(a1.getNom());
            nom_evenement.setText(a1.getNom_evenement());
            tel.setText(a1.getTelephone());
            mail.setText(a1.getMail());
            prenom.setText(a1.getPrenom());
           // id_art.setText(String.valueOf(a1.getId()));
           
           datee.setValue(LocalDate.of(a1.getDate_reservation().getYear(), a1.getDate_reservation().getMonth(), a1.getDate_reservation().getDay()));
            type.setText(a1.getType_evenement());
            prix.setText(String.valueOf(a1.getPrix()));
            qr.setText(a1.getQr());
            siege.setText(a1.getSiege());
          id.setText(String.valueOf(a1.getId()));
            
        });
        
        
        
        
    }

   

   
/*
    @FXML
    private void supprimer(ActionEvent event) throws ClassNotFoundException {
        
        
        int dd=Integer.valueOf(this.id.getText());
       // Reservation r2=new Reservation(booom,nomevenement,typee,nomT,prenomT,mail_evenement,telephone,prixx,siegee,Qr,8,9);
        //System.out.println("+++++++++++++++"+r2.toString());
       ReservationService r=new ReservationService();
      // r.supprimerReservation(dd);
       
    }
        
        
        
    }

    
    

*/