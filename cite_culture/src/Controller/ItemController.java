/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Reservation;
import Services.ReservationService;
import com.jfoenix.controls.JFXButton;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LocatorEx;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


/**
 * FXML Controller class
 *
 * @author moham
 */
public class ItemController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Button boom;
    @FXML
    private Pane pane;
    @FXML
    private Label prix;
    @FXML
    private Label siege;
    private Label idRES;
    @FXML
    private Label prenom;
    @FXML
    private Label nom_evenement;
    @FXML
    private JFXButton annuler;
    @FXML
    private Label nb_place;
    @FXML
    private Label email;
    @FXML
    private Label id;
    @FXML
    private AnchorPane anchor;
    @FXML
    private ImageView image;
    @FXML
    private Label event;
    @FXML
    private Label date;
    @FXML
    private Label time;
    
    
    
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         // boom.setGraphic(pane);
       /* try {
            
            Reservation r=new Reservation();
            
            ReservationService rs=new ReservationService();
            
           r= rs.rechercheReservationParIdClient(33);
           
            this.prix.setText(String.valueOf(r.getPrix()));
            this.siege.setText(r.getSiege());
           // this.idRES.setText(String.valueOf());
            //this.nom.sett            
            this.idRES.setText(String.valueOf(r.getId()));
            
            
            // TODO
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }    

    @FXML
    private void put(ActionEvent event) {
        
        try {
          /*   Pane receiptPane = new Pane();
            
            receiptPane.getChildren().addAll(totalL,
            tAmountL,
            dateTimeL,
            orderIDL,
            compNameL,
            compAddress1L,
            compAddress2L,
            thanksL,
            paymentType1L,
            paymentTypeAmount1L,
            dueL,
            dueAmountL,
            ordReceipts
            );*/
            PrinterJob job = PrinterJob.createPrinterJob();
            if (job != null && job.showPrintDialog(pane.getScene().getWindow())){
            boolean success = job.printPage(pane);
            if (success) {
            job.endJob();
            }
            }
            
           
           
            
            Image i=this.pane.snapshot(null,null);
            ImageIO.write(SwingFXUtils.fromFXImage(i, null),"png",new File("qr/"+this.id.getText()+".png"));
            ImageView v =new ImageView(i);
            
            
        //img.setImage(i);
        } catch (IOException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
 

        
    
    
}

    @FXML
    private void annulerReservation(ActionEvent event) throws ClassNotFoundException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Confirmation");
alert.setHeaderText("Look, a Confirmation Dialog");
alert.setContentText("Are you ok with this?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    
     ReservationService rs=new ReservationService();
        //System.out.println(this.idRES.getText());
       // System.out.println(Integer.valueOf(this.idRES.getText()));
        
       rs.supprimerReservation(Integer.valueOf(this.id.getText()));
        
       // this.test.setText("1");
       this.anchor.getChildren().removeAll(pane);
    // ... user chose OK
} else {
    //System.out.println("oooooo");
    // ... user chose CANCEL or closed the dialog
}
        //Reservation r=new Reservation();
       
       
                
    }
    
}

  /*  @FXML
    private void put(ActionEvent event) {
    }
*/