/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;

import Entities.commentaireP;
import Entities.note_publication;
import Entities.publication;
import Services.publication_service;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import utilitaire.UserSession;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class Details_publicationController implements Initializable {

   
    @FXML
    private Label titre;
    @FXML
    private Label sujet;
    @FXML
    private Label nomauteur;
    private Label contenu;
    
    @FXML
    private Label cont_pub;
    @FXML
    private ScrollPane comment_pane;
    @FXML
    private JFXTextField comment;
    @FXML
    private Label nomutil;
    @FXML
    private VBox v;
Utilisateur journaliste= new Utilisateur();
    @FXML
    private JFXTextField referencep;
    @FXML
    private Label npub;
    @FXML
    private Label nb_likes;
    @FXML
    private Label nb_jaime;
    /**
     * Initializes the controller class.
     */
    
    void setpub(publication p) throws ClassNotFoundException
    {
       cont_pub.setText(p.getContenu_pub());
       // System.out.println(p.getRef());
        referencep.setText(String.valueOf(p.getRef()));
     npub.setText(p.getNom_publication());
      titre.setText(p.getTitre());
      sujet.setText(p.getSujet());
      nomauteur.setText(p.getNom_auteur());
      //date_publication.setText(p.getDate_publication());
     //System.out.println(referencep.getText());
     
     
       publication_service psss=new publication_service();
            int id=Integer.valueOf(referencep.getText());
            nb_jaime.setText(String.valueOf(psss.affiche_note(id)));
     
     
     int i =0;
        comment_pane.setContent(v);
        v.getChildren().clear();
        publication_service pubs = null;
        try {
            pubs = new publication_service();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Details_publicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("***************************");
        System.out.println(referencep.getText());
        System.out.println("***************************");
        int idc=Integer.valueOf(referencep.getText());
       // System.out.println(idc);
        //commentaireP ccp =new commentaireP();
        
             List <commentaireP> data= pubs.afficher_commentaire(idc);
             Node[] nodes = new Node[data.size()];
             for(commentaireP item : data)
             {
            try {
                nodes[i]=(Node) FXMLLoader.load(getClass().getResource("/View/form_commentaire_pub.fxml"));
                Label ut =(Label) nodes[i].lookup("#utils");
                 Label ct =(Label) nodes[i].lookup("#commentaire");
                 ut.setText(item.getNom_utilisateur());
                 ct.setText(item.getComment());
                  v.getChildren().add(nodes[i]);
         
                  i++;
            } catch (IOException ex) {
                Logger.getLogger(Details_publicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
             }
     
     
     
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
          
      /*  try {
            UserSession.getInstance(journaliste).getUser();
            
            
            this.nomutil.setText(UserSession.getInstance(journaliste).getUser().getNom());
            
            // TODO
            
          
            //affichage des commentaires
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Details_publicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
            */
            
            
        } 
        
        
        
       

    

    @FXML
    private void add_comment(ActionEvent event) throws ClassNotFoundException, SQLException {
         Boolean b =false;
                String Commentaire =comment.getText();
                  List<String>ls=new ArrayList<>();
                publication_service p =new publication_service();
               ls= p.badwordss();
                  
                String[] result = Commentaire.toUpperCase().split(" ");
     for (int x=0; x<result.length; x++){
                      for (int i=0;i<ls.size();i++){
                          if (ls.get(i).equals(result[x])){
                          b=true;
                          break;
                          }}}
     
        System.out.println(b);
        
        if (b==false){
        
        publication_service pubserv =new publication_service();
        int id=Integer.valueOf(referencep.getText());
        
        commentaireP cp = new commentaireP(id,nomutil.getText(),comment.getText());
        pubserv.ajout_commentaire(cp);
        comment.clear();
        int i =0;
        comment_pane.setContent(v);
        v.getChildren().clear();
        publication_service pubs = null;
        try {
            pubs = new publication_service();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Details_publicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("***************************");
        System.out.println(referencep.getText());
        System.out.println("***************************");
        int idc=Integer.valueOf(referencep.getText());
       // System.out.println(idc);
        //commentaireP ccp =new commentaireP();
        
             List <commentaireP> data= pubs.afficher_commentaire(idc);
             Node[] nodes = new Node[data.size()];
             for(commentaireP item : data)
             {
            try {
                nodes[i]=(Node) FXMLLoader.load(getClass().getResource("/View/form_commentaire_pub.fxml"));
                Label ut =(Label) nodes[i].lookup("#utils");
                 Label ct =(Label) nodes[i].lookup("#commentaire");
                 ut.setText(item.getNom_utilisateur());
                 ct.setText(item.getComment());
                  v.getChildren().add(nodes[i]);
         
                  i++;
            } catch (IOException ex) {
                Logger.getLogger(Details_publicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
             }
        
    }
    
    else{
               Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("gros mot !! ");
                alert.setHeaderText("SVP faites attention a votre language!");
                alert.showAndWait();
          
}
    }

    @FXML
    private void lire_artcl(ActionEvent event) throws IOException {
        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"C:/wamp64/"+cont_pub.getText());
    }

    @FXML
    private void like(ActionEvent event) throws ClassNotFoundException {
        publication_service p = new publication_service();
         int id=Integer.valueOf(referencep.getText());
        note_publication np =new note_publication(id,nomutil.getText());
        p.noter(np);
        nb_jaime.setText(String.valueOf(p.affiche_note(id)));
       
        
    }

    
    
}
