/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.article_service;
import com.jfoenix.controls.JFXTextField;
import Entities.article;
import Entities.publication;
import Services.publication_service;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class Admin_publicationController implements Initializable {
   article a= new article();
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
    @FXML
    private TableView<publication> table_pub;
    @FXML
    private TableColumn<publication, Integer> col_ref_pub;
    
    @FXML
    private TableColumn<publication, String> titre_col_pub;
    @FXML
    private TableColumn<publication, String> sujet_col_pub;
    @FXML
    private TableColumn<publication, String> contenu_col_pub;
    @FXML
    private TableColumn<publication, String> auteur_col_pub;
    @FXML
    private TableColumn<publication, Date> date_col_pub;
    @FXML
    private TableColumn<publication, String> nom_col_pub;

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
        
       try {
           publication_service pserv=new publication_service();
           table_pub.setItems(pserv.afficher_publication());
           col_ref_pub.setCellValueFactory(new PropertyValueFactory<>("ref"));
           nom_col_pub.setCellValueFactory(new PropertyValueFactory<>("nom_publication"));
           titre_col_pub.setCellValueFactory(new PropertyValueFactory<>("titre"));
           sujet_col_pub.setCellValueFactory(new PropertyValueFactory<>("sujet"));
           contenu_col_pub.setCellValueFactory(new PropertyValueFactory<>("contenu_pub"));
           auteur_col_pub.setCellValueFactory(new PropertyValueFactory<>("nom_auteur"));
           date_col_pub.setCellValueFactory(new PropertyValueFactory<>("date_publication"));
           setCellValueFromTableToText2();
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
            ref_pub.setText(String.valueOf(a1.getId()));
            //id_art.setText(String.valueOf(a1.getId()));
        });}
        
      private void setCellValueFromTableToText2()
    {
        table_pub.setOnMouseClicked(e -> {
            publication p1 = table_pub.getItems().get(table_pub.getSelectionModel().getSelectedIndex());
            titre_art.setText(p1.getTitre());
            sujet_art.setText(p1.getSujet());
            nomauteur.setText(p1.getNom_auteur());
            
            contenu.setText(p1.getContenu_pub());
            ref_pub.setText(String.valueOf(p1.getRef()));
            nom_publication.setText(p1.getNom_publication());
            //id_art.setText(String.valueOf(a1.getId()));
        });  
        
        
    }

    @FXML
    private void valider(ActionEvent event) throws ClassNotFoundException {
        int id=Integer.valueOf(ref_pub.getText());
        publication_service ps = new publication_service();
        publication pub = new publication(titre_art.getText(),sujet_art.getText(),nom_publication.getText(),nomauteur.getText(),contenu.getText(),email.getText());
        ps.ajouter_publication(pub);
        article_service artsv = new article_service();
       // article aa = new article(ref_pub.getText());
        artsv.modifier2(id);
        table_article.setItems(artsv.afficher_article());
        table_pub.setItems(ps.afficher_publication());
          
        
        
        try{
            String host ="smtp.gmail.com" ;
            String user = "pidevils1@gmail.com";
            String pass = "Lessimpson1997";
            String to = email.getText();
            String from = "pidevils1@gmail.com";
            String subject = "votre article";
            String messageText = "Mr "+nomauteur.getText()+" votre article est validé "+sujet_art.getText()+"nous avons l'honneur de le publier dans notre application";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
         titre_art.clear();
         ref_pub.clear();
         sujet_art.clear();
         nom_publication.clear();
         nomauteur.clear();
         contenu.clear();
         email.clear();
        

    
    }

    @FXML
    private void modifier_publication(ActionEvent event) throws ClassNotFoundException {
         publication_service ps = new publication_service();
         publication pub=new publication(titre_art.getText(), sujet_art.getText(), nom_publication.getText(), nomauteur.getText(), contenu.getText(), email.getText());
         
         int ref=Integer.valueOf(ref_pub.getText());
         pub.setRef(ref);
         ps.modifier_publication(pub);
          table_pub.setItems(ps.afficher_publication());
          
         titre_art.clear();
         ref_pub.clear();
         sujet_art.clear();
         nom_publication.clear();
         nomauteur.clear();
         contenu.clear();
         email.clear();
         
    }

    @FXML
    private void non_valider(ActionEvent event) throws ClassNotFoundException {
        int id=Integer.valueOf(ref_pub.getText());
         article_service artsv = new article_service();
       // article aa = new article(ref_pub.getText());
        artsv.supprimerarticle(id);
        table_article.setItems(artsv.afficher_article());
       // table_pub.setItems(ps.afficher_publication());
          
        
        try{
            String host ="smtp.gmail.com" ;
            String user = "pidevils1@gmail.com";
            String pass = "Lessimpson1997";
            String to = email.getText();
            String from = "pidevils1@gmail.com";
            String subject = "votre article";
            String messageText = "Mr "+nomauteur.getText()+" votre article n'est pas validé "+sujet_art.getText()+" et nous avons le regret de decliner votre demande ";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
         titre_art.clear();
         ref_pub.clear();
         sujet_art.clear();
         nom_publication.clear();
         nomauteur.clear();
         contenu.clear();
         email.clear();
        
    }

    @FXML
    private void ouvrir_fichier(ActionEvent event) throws IOException {
        
        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"C:/wamp64/"+contenu.getText());
        
    }

    @FXML
    private void supprimer_publication(ActionEvent event) throws ClassNotFoundException {
        int id=Integer.valueOf(ref_pub.getText());
         publication_service pub = new publication_service();
         pub.supprimer_note(id);
         pub.supprimer_comm(id);
         pub.supprimer_publication(id);
          table_pub.setItems(pub.afficher_publication());
          
         titre_art.clear();
         ref_pub.clear();
         sujet_art.clear();
         nom_publication.clear();
         nomauteur.clear();
         contenu.clear();
         email.clear();
         
        
    }
    
}
