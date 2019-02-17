/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.article_service;
import com.jfoenix.controls.JFXTextField;
import Entities.article;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyer_article(ActionEvent event) throws IOException, ClassNotFoundException {
        article_service artserv = new article_service();
        String s=contenu.getText();
        //String rp = s.replace("\\","/");    
        
        Path source=Paths.get(this.contenu.getText());
        
Path destination= Paths.get("C:\\wamp64\\www\\pdf_khalil\\"+"Jounaliste_"+this.namefile);
    
String rp = destination.toString().replace("\\","/");    
//String dp=rp.replace("/", "\\");
                   // System.out.println(dp);
                    
                    
//copie
Files.copy(source, destination,StandardCopyOption.REPLACE_EXISTING);
            

        article artc  = new article(titre.getText(),sujet.getText(),nomauteur.getText(),email.getText(),rp);
        artserv.ajouterarticle(artc);
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
