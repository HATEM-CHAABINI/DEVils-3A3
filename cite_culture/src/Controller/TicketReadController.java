/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Reservation;
import Entities.Ticket;
import Services.ReservationService;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utilitaire.QRCodeReaders;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class TicketReadController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private Button btn;
   // private PieChart chart=new FXCharts().createPieChart(25, 50);
    @FXML
    private TitledPane aa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // chart=new FXCharts().createPieChart(25, 50);
         
      /*  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

Optional<ButtonType> result = alert.showAndWait();
*/
    
            try {
                ReservationService rs=new ReservationService();
                //System.out.println(this.idRES.getText());
                // System.out.println(Integer.valueOf(this.idRES.getText()));
                
                String CodeQr;
                
                    CodeQr = QRCodeReaders.ReadQRCodeImage();
                      String nq=CodeQr.replace("QR-Code:","");
                     
                      try{
                          int qr=Integer.parseInt(nq);
                      
                      
Reservation res=new Reservation();
res=rs.rechercheReservationParIdRes(qr);
Ticket t=rs.getUser(res.getId_user());
if (res.getSiege()!=null){

    System.out.println("oui");
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information");
alert.setHeaderText("VALIDE");
alert.setContentText(t.getNom()+" "+t.getPrenom()+"  nombre de place:"+res.getNb_place()+"  PRIX:"+res.getPrix()+"DT");

alert.showAndWait();
rs.supprimerReservation(qr);
//pane.setVisible(false);

    /*alert.setTitle("Confirmation");
alert.setHeaderText("Look, a Confirmation Dialog");
alert.setContentText("Are you ok with this?");*/}
else{
    System.out.println("non");
Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("ERREUR");
alert.setHeaderText("INFORMATION");
alert.setContentText("VOUS NE DISPOSEZ PAS DE RESERVATION");

alert.showAndWait();
//pane.setVisible(false);

   }

                      }catch(Exception e){
                      
                          System.out.println("non2");
Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Error Dialog");
alert.setHeaderText("Look, an Error Dialog");
alert.setContentText("Ooops, there was an error!");

alert.showAndWait();
//pane.setVisible(false);
                          
                      
                      }
                } catch (ClassNotFoundException| IOException ex) {
                    Logger.getLogger(TicketReadController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        // TODO
        
        // TODO
        
    }    

    @FXML
    private void chart(ActionEvent event) {
        
        Stage primaryStage=new Stage();
        Group root = new Group();
            Scene scene = new Scene(root,500,530);
            primaryStage.setScene(scene);
            
            
            
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
             new PieChart.Data("Sun", 7),
             new PieChart.Data("IBM", 8)
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
        
        
        
    }
    
}
