/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Ticket;
import Entities.Utilisateur;
import Services.ReservationService;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import com.jfoenix.controls.JFXButton;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import utilitaire.QRCodeGenerators;
import utilitaire.UserSession;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class TicketController implements Initializable {

    @FXML
    private VBox pnl_scroll;
    @FXML
    private ScrollPane scroll;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        UserSession session=new UserSession();
        
        Utilisateur ut=new Utilisateur();
        ut=session.getUser();
        
        
        try {
            int i=0;
            
            scroll.setContent(pnl_scroll);
            pnl_scroll.getChildren().clear();
           
            
            
            
            
        
            ReservationService r = new ReservationService();
            List<Ticket> data=r.afficherReseration(ut.getId());
            
            
            Node [] nodes = new  Node[data.size()];
            for(Ticket item :data)
            {
                
                nodes[i]=(Node) FXMLLoader.load(getClass().getResource("/View/Item.fxml"));
                
                
                
               Label id= (Label) nodes[i].lookup("#id");
                Label nom=(Label) nodes[i].lookup("#nom");
                Label prenom=(Label) nodes[i].lookup("#prenom");
                // Label date=(Label) nodes[i].lookup("#date_reservation");
                Label email =(Label) nodes[i].lookup("#email");
                Label prix=(Label) nodes[i].lookup("#prix");
                Label siege=(Label) nodes[i].lookup("#siege");
               // Label qr=(Label) nodes[i].lookup("#qr");
                Label nb_place=(Label) nodes[i].lookup("#nb_place");
                Label event=(Label) nodes[i].lookup("#event");
                Label time=(Label) nodes[i].lookup("#time");
                Label date=(Label) nodes[i].lookup("#date");
                Button btn=(Button) nodes[i].lookup("#annuler");
                ImageView im=(ImageView)nodes[i].lookup("#image");
                
                Label day=(Label) nodes[i].lookup("#day");
                Label year=(Label) nodes[i].lookup("#year");
                Label month=(Label) nodes[i].lookup("#month");
                Label test=(Label) nodes[i].lookup("#test");
                
                id.setText(Integer.toString(item.getId()));
                nom.setText(item.getNom());
                prenom.setText(item.getPrenom());
                // date.setText(item.getDate_reservation());
                email.setText(item.getMail());
                prix.setText(Float.toString(item.getPrix()));
                siege.setText(item.getSiege());
                nb_place.setText(Integer.toString(item.getNb_place()));
              //  qr.setText(item.getQr());
                event.setText(item.getTitre());
                time.setText(item.getTime());
                date.setText(item.getDate().toString());
                
                
                
                
                QRCodeGenerators.generateQRCodeImage(id.getText(),id.getText());
               File file = new File("qr/"+id.getText()+".png");
               Image img = new Image(file.toURI().toString());
               ImageView a=new ImageView(img);
               im.setImage(img);
                
               
               pnl_scroll.getChildren().add(nodes[i]);
                    
                
             /*  btn.setOnAction(click->{
                   
                  nodes[i].setVisible(false);
                   
               });*/

               // vbox.getChildren().add(new ImageView(snapshot));
                //System.out.println(vbox.getChildren().size());
                 //snapthis.a.setImage(snapshot);
                 
                 
                
               
               
                i++;
            }
        } catch (java.lang.ClassNotFoundException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriterException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        
        
        
        
        
        
        
        
        
        
                    
                
        
              
                    
                
        
        
        
        
        
        
    
}
    
}
    
    
    
        
          
         
      
    
        // TODO
       
    

