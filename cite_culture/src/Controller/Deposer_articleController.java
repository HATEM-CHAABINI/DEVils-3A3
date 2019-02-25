/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Journaliste;
import Entities.Utilisateur;
import Services.article_service;
import com.jfoenix.controls.JFXTextField;
import Entities.article;
import Services.UtilisateurService;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

import sun.net.www.http.HttpClient;
import utilitaire.UserSession;
import utilitaire.upload_pdf_khalil;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class Deposer_articleController implements Initializable {

    //private JFXTextField titre;
    @FXML
    private JFXTextField sujet;
    @FXML
    private JFXTextField nomauteur;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField contenu;
private String namefile;
    
    @FXML
    private JFXTextField titre;
Utilisateur journaliste= new Utilisateur();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
         /*   try {         
                
                
            UserSession.getInstance(journaliste).getUser();
            this.nomauteur.setText(UserSession.getInstance(journaliste).getUser().getNom());
            this.email.setText(UserSession.getInstance(journaliste).getUser().getEmail());
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Deposer_articleController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }    

    @FXML
    private void envoyer_article(ActionEvent event) throws IOException, ClassNotFoundException, Exception {
        article_service artserv = new article_service();
        String s=contenu.getText();
       String ss = "";
       if((titre.getText().isEmpty())||(sujet.getText().isEmpty())|| (contenu.getText().isEmpty()))
       {
          Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("champs vide ");
                alert.setHeaderText("verifiez les champs ");
                alert.showAndWait(); 
       }
       else{
       upload_pdf_khalil pipi = new upload_pdf_khalil();
          ss=pipi.upload(s);

        article artc  = new article(titre.getText(),sujet.getText(),nomauteur.getText(),email.getText(),ss);
        artserv.ajouterarticle(artc);
       }
        titre.clear();
        sujet.clear();
        nomauteur.clear();
        email.clear();
        contenu.clear();
    }
    

    @FXML
    private void choisir_fichier(ActionEvent event) {
         final FileChooser filechooser = new FileChooser();
        File selectedfile=filechooser.showOpenDialog(null);
        if(selectedfile != null)
        {
            contenu.setText(selectedfile.getAbsolutePath());
            Path source=Paths.get(selectedfile.getAbsolutePath());
            this.namefile=selectedfile.getName();
    }
    }
    
    
}
