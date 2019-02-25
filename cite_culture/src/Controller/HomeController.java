/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Reclamation;
//import Entity.Ticket;
import Services.ReclamationService;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
//import utilitaire.QRCodeReaders;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {
    
    
    @FXML
    private VBox pnl_scroll;
    @FXML
    private JFXButton stat;
    
    private void handleButtonAction(MouseEvent event) {        
       refreshNodes();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         //refreshNodes();
    }    
    
    private void refreshNodes()
    {
        pnl_scroll.getChildren().clear();
        
        Node [] nodes = new  Node[15];
        
        for(int i = 0; i<10; i++)
        {
            try {
                nodes[i] = (Node)FXMLLoader.load(getClass().getResource("View/AdminRec.fxml"));
               pnl_scroll.getChildren().add(nodes[i]);
                
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }  
    }

//    @FXML
//    private void scan(ActionEvent event) {
//        
//        
//        try {
//                ReservationService rs=new ReservationService();
//                //System.out.println(this.idRES.getText());
//                // System.out.println(Integer.valueOf(this.idRES.getText()));
//                
//                String CodeQr;
//                
//                    CodeQr = QRCodeReaders.ReadQRCodeImage();
//                      String nq=CodeQr.replace("QR-Code:","");
//                     
//                      try{
//                          int qr=Integer.parseInt(nq);
//                      
//                      
//Reservation res=new Reservation();
//res=rs.rechercheReservationParIdRes(qr);
//Ticket t=rs.getUser(res.getId_user());
//if (res.getSiege()!=null){
//
//    System.out.println("oui");
//Alert alert = new Alert(Alert.AlertType.INFORMATION);
//alert.setTitle("Information");
//alert.setHeaderText("VALIDE");
//alert.setContentText(t.getNom()+" "+t.getPrenom()+"  nombre de place:"+res.getNb_place()+"  PRIX:"+res.getPrix()+"DT");
//
//alert.showAndWait();
//rs.supprimerReservation(qr);
////pane.setVisible(false);
//
//    /*alert.setTitle("Confirmation");
//alert.setHeaderText("Look, a Confirmation Dialog");
//alert.setContentText("Are you ok with this?");*/}
//else{
//    System.out.println("non");
//Alert alert = new Alert(Alert.AlertType.ERROR);
//alert.setTitle("ERREUR");
//alert.setHeaderText("INFORMATION");
//alert.setContentText("VOUS NE DISPOSEZ PAS DE RESERVATION");
//
//alert.showAndWait();
////pane.setVisible(false);
//
//   }
//
//                      }catch(Exception e){
//                      
//                          System.out.println("non2");
//Alert alert = new Alert(Alert.AlertType.ERROR);
//alert.setTitle("Error Dialog");
//alert.setHeaderText("Look, an Error Dialog");
//alert.setContentText("Ooops, there was an error!");
//
//alert.showAndWait();
////pane.setVisible(false);
//                          
//                      
//                      }
//                } catch (ClassNotFoundException| IOException ex) {
//                    Logger.getLogger(TicketReadController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//        
//        // TODO
//        
//        
//        
//        
//        
//        
//        
//        
//    }

    private void stat(ActionEvent event) {
         
        }  

    @FXML
    private void Adminreclamation(ActionEvent event) {
         try {
              pnl_scroll.getChildren().clear();
              
              
              
              FXMLLoader.load(getClass().getResource("/View/AdminRec.fxml"));
              pnl_scroll.getChildren().add(FXMLLoader.load(getClass().getResource("/View/AdminRec.fxml")));
          } catch (IOException ex) {
              Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @FXML
    private void AdminGestionSalle (ActionEvent event) {
    
         try {
              pnl_scroll.getChildren().clear();
              
              
              
              FXMLLoader.load(getClass().getResource("/View/SalleInterface.fxml"));
              pnl_scroll.getChildren().add(FXMLLoader.load(getClass().getResource("/View/SalleInterface.fxml")));
          } catch (IOException ex) {
              Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
          }
       } 

    }
    

