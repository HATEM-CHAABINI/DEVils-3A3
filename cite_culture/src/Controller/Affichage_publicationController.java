/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
import Entities.publication;
import Services.publication_service;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utilitaire.UserSession;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class Affichage_publicationController implements Initializable {


    @FXML
    private ScrollPane scroll_pub;
    @FXML
    private VBox v;
    @FXML
    private Button env_art;
    
//Utilisateur journaliste= new Utilisateur();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
      
            
        int i =0 ;
        scroll_pub.setContent(v);
        v.getChildren().clear();
        try {
            publication_service ps= new publication_service();
             List <publication> data= ps.afficher_publication();
             
             Node[] nodes = new Node[data.size()];
             
            for(publication item : data)
         {
             try {
                 nodes[i]=(Node) FXMLLoader.load(getClass().getResource("/View/form_publication.fxml"));
                 Label ref =(Label) nodes[i].lookup("#ref_pub");
                 Label nom_pub= (Label) nodes[i].lookup("#nom_pub");
                 Label titre=(Label) nodes[i].lookup("#titre");
                 Label sujet=(Label) nodes[i].lookup("#sujet");
                 Label nomauteur=(Label) nodes[i].lookup("#auteur");
                 Label date_pub=(Label) nodes[i].lookup("#date_pub");
                 //Label email =(Label) nodes[i].lookup("#email");
                 Label contenu=(Label) nodes[i].lookup("#contenu");
                 ref.setText(String.valueOf(item.getRef()));
                 
                 nom_pub.setText(item.getNom_publication());
                 sujet.setText(item.getSujet());
                 titre.setText(item.getTitre());
                 nomauteur.setText(item.getNom_auteur());
                 date_pub.setText(item.getDate_publication());
                 contenu.setText(item.getContenu_pub());
                 
                  v.getChildren().add(nodes[i]);
         
                  i++;

 
  

 
             } catch (Exception e) {
             }
         }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Affichage_publicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void envoyer_article(ActionEvent event) throws IOException, ClassNotFoundException {
        //UserSession.getInstance(journaliste).getUser().getNom();
       FXMLLoader loader=new FXMLLoader();
              loader.setLocation(getClass().getResource("/View/deposer_article.fxml"));
              Parent root=loader.load();
              Scene scene = new Scene(root);
              Stage stage=new Stage();              
              stage.setScene(scene);
              stage.show();
    }
    
}
