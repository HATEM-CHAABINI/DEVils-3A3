/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.MesReservations;
import Entities.Utilisateur;
import Services.CoursService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import utilitaire.UserSession;

/**
 * FXML Controller class
 *
 * @author Farah
 */
public class MesReservationsController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox vbox;
Utilisateur u = new Utilisateur();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          UserSession session=new UserSession();
    
            u=session.getUser();
 
        
        try {
            int i=0;
            
            scroll.setContent(vbox);
            vbox.getChildren().clear();
           
            
            
            
            
        
            CoursService r = new CoursService();
            List<MesReservations> data=r.afficherMesReservations(u.getId());
            
            
            Node [] nodes = new  Node[data.size()];
            for(MesReservations item :data)
            {
                
                nodes[i]=(Node) FXMLLoader.load(getClass().getResource("/View/CoursReserves.fxml"));
                
                
                
               Label id= (Label) nodes[i].lookup("#id");
                Label nomC=(Label) nodes[i].lookup("#nom_client");
                Label prenomC=(Label) nodes[i].lookup("#prenom_client");
                // Label date=(Label) nodes[i].lookup("#date_reservation");
                Label email =(Label) nodes[i].lookup("#email");
                Label nomP=(Label) nodes[i].lookup("#nom_prof");
                Label prenomP=(Label) nodes[i].lookup("#prenom_prof");
                Label prix=(Label) nodes[i].lookup("#prix");
                Label salle=(Label) nodes[i].lookup("#salle");
               // Label qr=(Label) nodes[i].lookup("#qr");
               // Label nb_place=(Label) nodes[i].lookup("#nb_place");
                Label type=(Label) nodes[i].lookup("#type");
                Label time=(Label) nodes[i].lookup("#heure_d");
                Label date=(Label) nodes[i].lookup("#date");
                Button btn=(Button) nodes[i].lookup("#annuler");
               // ImageView im=(ImageView)nodes[i].lookup("#image");
                
//                Label day=(Label) nodes[i].lookup("#day");
//                Label year=(Label) nodes[i].lookup("#year");
//                Label month=(Label) nodes[i].lookup("#month");
//                Label test=(Label) nodes[i].lookup("#test");
                
                id.setText(Integer.toString(item.getId()));
                nomC.setText(item.getNomC());
                prenomC.setText(item.getPrenomC());
                // date.setText(item.getDate_reservation());
                email.setText(item.getMail());
                nomP.setText(item.getNomP());
                prenomP.setText(item.getPrenomP());
                prix.setText(Float.toString(item.getPrix())+" dt");
                salle.setText(item.getSalle());
               // nb_place.setText(Integer.toString(item.getNb_place()));
              //  qr.setText(item.getQr());
                type.setText("Cours de "+item.getType());
                time.setText(item.getTime()+" h");
               date.setText(item.getDate_cours().toString());
                
                
                
                
                
                
               
               vbox.getChildren().add(nodes[i]);
                    
                
             /*  btn.setOnAction(click->{
                   
                  nodes[i].setVisible(false);
                   
               });*/

               // vbox.getChildren().add(new ImageView(snapshot));
                //System.out.println(vbox.getChildren().size());
                 //snapthis.a.setImage(snapshot);
                 
                 
                
               
               
                i++;
            }
        } catch (java.lang.ClassNotFoundException ex) {
            Logger.getLogger(MesReservationsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MesReservationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        
        
        
        
        
        
        
        
        
        
                    
                
        
              
                    
                
        
        
        
        
        
        
    
}
        // TODO
    }    
    

