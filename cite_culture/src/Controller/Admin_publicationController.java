/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.article_service;
import com.jfoenix.controls.JFXTextField;
import Entities.article;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class Admin_publicationController implements Initializable {

    @FXML
    private JFXTextField ref_pub;
    @FXML
    private JFXTextField nom_publication;
    @FXML
    private JFXTextField titre_art;
    @FXML
    private JFXTextField sujet_art;
    @FXML
    private JFXTextField contenu;
    @FXML
    private JFXTextField nomauteur;
    @FXML
    private TableView<article> table_article;
    @FXML
    private TableColumn<article, Integer> id_col;
    @FXML
    private TableColumn<article, String> titre_col;
    @FXML
    private TableColumn<article, String> sujet_article;
    @FXML
    private TableColumn<article, String> auteur_col;
    @FXML
    private TableColumn<article, String> contenu_col;
    @FXML
    private TableColumn<article, Date> date_col;
    @FXML
    private TableColumn<article, String> email_auteur;
    @FXML
    private JFXTextField email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            article_service artc = new article_service();
            table_article.setItems(artc.afficher_article());
            id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
            titre_col.setCellValueFactory(new PropertyValueFactory<>("titre_article"));
            sujet_article.setCellValueFactory(new PropertyValueFactory<>("sujet_article"));
            auteur_col.setCellValueFactory(new PropertyValueFactory<>("nom_auteur"));
            contenu_col.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            email_auteur.setCellValueFactory(new PropertyValueFactory<>("adresse_mail"));
            date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
            
            setCellValueFromTableToTextField();
            // TODO
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin_publicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    private void setCellValueFromTableToTextField()
    {
        table_article.setOnMouseClicked(e -> {
            article a1 = table_article.getItems().get(table_article.getSelectionModel().getSelectedIndex());
            titre_art.setText(a1.getTitre_article());
            sujet_art.setText(a1.getSujet_article());
            nomauteur.setText(a1.getNom_auteur());
            email.setText(a1.getAdresse_mail());
            contenu.setText(a1.getContenu());
            //id_art.setText(String.valueOf(a1.getId()));
        });
        
        
        
        
    }

    @FXML
    private void valider(ActionEvent event) {
        
    }

    @FXML
    private void modifier_publication(ActionEvent event) {
    }

    @FXML
    private void non_valider(ActionEvent event) {
    }
    
}
