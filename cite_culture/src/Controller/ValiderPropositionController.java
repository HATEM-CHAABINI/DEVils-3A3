/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Film;
import Entities.PropositionEvent;
import Services.FilmService;
import Services.PropositionEventService;
import static Controller.FilmController.sallouma;
import Entities.Conference;
import Entities.Galerie;
import Entities.Theatre;
import Entities.Utilisateur;
import Services.UtilisateurService;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import utilitaire.ControlesaisieJ;
import utilitaire.UploadImageFilm;


/**
 * FXML Controller class
 *
 * @author mouna dridi
 */
public class ValiderPropositionController implements Initializable {
    PropositionEvent p =new PropositionEvent();
        PropositionEvent p1 =new PropositionEvent();
String username;
    Film f=new Film();
    @FXML
    private TextField titre;
    @FXML
    private TextField description;
    @FXML
    private DatePicker datedebut;
    @FXML
    private DatePicker datefin;
    private TextField salle;
    @FXML
    private TextField prixenfant;
    @FXML
    private TextField prixadulte;
    @FXML
    private TextField prixetudiant;
    @FXML
    private TextField time;
    @FXML
    private TextField image;
    @FXML
    private TextField trailer;
    @FXML
    private TextField nbrPlace;
    @FXML
    private Button ajouterI_B;
    @FXML
    private Button ajouterT_B;
    @FXML
    private TableView<PropositionEvent> table;
    @FXML
    private TableColumn<PropositionEvent, Integer> id;
    @FXML
    private TableColumn<PropositionEvent, String> typeE;
    @FXML
    private TableColumn<PropositionEvent, String> desc;
    @FXML
    private TableColumn<PropositionEvent, String> titre1;
    @FXML
    private TableColumn<PropositionEvent, String> etat;
    @FXML
    private Button ajouter;
    @FXML
    private Button refuser;
    @FXML
    private ComboBox<String> salle1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
        PropositionEventService artc = new PropositionEventService();
            table.setItems(artc.afficherPEvent());
            id.setCellValueFactory(new PropertyValueFactory<>("idPEvent"));
            typeE.setCellValueFactory(new PropertyValueFactory<>("typeEvent"));
            desc.setCellValueFactory(new PropertyValueFactory<>("description"));
            titre1.setCellValueFactory(new PropertyValueFactory<>("titre")); 
            etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
            setCellValueFromTableToTextField();
        // TODO
    }    

    @FXML
    private void ajouterFichier(ActionEvent event) throws IOException {
         final FileChooser filechooser = new FileChooser();
        File selectedfile=filechooser.showOpenDialog(null);
        if(selectedfile != null)
        {
            image.setText(selectedfile.getAbsolutePath());
            Path source=Paths.get(selectedfile.getAbsolutePath());
            Path destination= Paths.get("C:\\wamp64\\www\\filmImage\\"+selectedfile.getName());
                        
           sallouma=destination.toString();
//            System.out.println(sallouma);
//            System.out.println(s.indexOf("\\"));                    
//            String rp = s.replace("\\","/");
//                   
            //String rp = s.replace("\\","/");    
                //String dp=rp.replace("/", "\\");
                   // System.out.println(dp);
                    
                    
            //copie
            Files.copy(source, destination,StandardCopyOption.REPLACE_EXISTING);
        }
        
    }

    @FXML
    private void ajouterVideo(ActionEvent event) throws MalformedURLException, URISyntaxException, IOException {
    Desktop.getDesktop().browse(new URL("https://www.youtube.com/").toURI());

    }

    
    
    
     private void setCellValueFromTableToTextField()
    {
            table.setOnMouseClicked(e -> {
            PropositionEvent a1 = table.getItems().get(table.getSelectionModel().getSelectedIndex());
            titre.setText(a1.getTitre());
            description.setText(a1.getDescription());
            p.setTypeEvent(a1.getTypeEvent());
             p1.setIdPEvent(a1.getIdPEvent());
             this.username=a1.getUsername();
              PropositionEventService fs;
        fs = new PropositionEventService();
        salle1.setItems(fs.affecterSalle(p.getTypeEvent()));
           
        });
    }

    @FXML
    private void ajouterP(ActionEvent event) throws ClassNotFoundException, Exception {
        ControlesaisieJ cn=new ControlesaisieJ();
        
        UtilisateurService us=new UtilisateurService();
        Utilisateur uemail=new Utilisateur();
        uemail=us.rechercheUtilisateurParUsername(this.username);
        String mail=uemail.getEmail();
       
        System.out.println(p.getTypeEvent());
        
        if(p.getTypeEvent().equals("Film")){
            if (datedebut.getValue()!=null && datefin.getValue()!=null ){
        java.sql.Date dated = java.sql.Date.valueOf(datedebut.getValue());
        java.sql.Date datef = java.sql.Date.valueOf(datefin.getValue());
        if(cn.testdateEMB_dateEXP1(dated,datef)==-1){
//            
        String titre1=this.titre.getText();
        String description1=this.description.getText();
        //String image1=this.image.getText();
        String trailer1=this.trailer.getText();
//        java.sql.Date dated = java.sql.Date.valueOf(datedebut.getValue());
//        java.sql.Date datef = java.sql.Date.valueOf(datefin.getValue());
        //String salle1=this.salle.getText();
        String salle=this.salle1.getValue();
        float prixEnfant=Integer.valueOf(this.prixenfant.getText());
        float prixAdulte=Integer.valueOf(this.prixadulte.getText());
        float prixEtudiant=Integer.valueOf(this.prixetudiant.getText());
        String time1=this.time.getText();
        int nbrplace=Integer.valueOf(this.nbrPlace.getText());
        //String rp = image1.replace('\\','/'); 
        UploadImageFilm up=new UploadImageFilm();
        String path2=up.upload(image.getText());
        Film e=new Film(trailer1,titre1,description1,dated,datef,salle,prixEnfant,prixAdulte ,prixEtudiant, time1,path2,nbrplace);
        PropositionEventService fS=new PropositionEventService();
        fS.validerPEvent(e);
        fS.setEtatV(p1);
        table.setItems(fS.afficherPEvent());
        //PropositionEventService fS=new PropositionEventService();

                try{
            String host ="smtp.gmail.com" ;
            String user = "pidevils1@gmail.com";
            String pass = "Lessimpson1997";
            String to = mail;
            String from = "pidevils1@gmail.com";
            String subject = "Cite de la culture";
            String messageText = "Votre proposition a été confirmée";
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
            javax.mail.Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(javax.mail.Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);
            
            
             MimeMultipart multipart = new MimeMultipart("related");

         

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
           
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
        }else{
        Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("date erronee");
        alert.setHeaderText("ajoutez une date valide");
        alert.showAndWait();
        }
            }}  
            
        if(p.getTypeEvent().equals("Theatre")){
            if (datedebut.getValue()!=null && datefin.getValue()!=null ){
        java.sql.Date dated = java.sql.Date.valueOf(datedebut.getValue());
        java.sql.Date datef = java.sql.Date.valueOf(datefin.getValue());
        if(cn.testdateEMB_dateEXP1(dated,datef)==-1){
        String titre1=this.titre.getText();
        String description1=this.description.getText();
        //String image1=this.image.getText();
        //String trailer1=this.trailer.getText();
//        java.sql.Date dated = java.sql.Date.valueOf(datedebut.getValue());
//        java.sql.Date datef = java.sql.Date.valueOf(datefin.getValue());
        String salle1=this.salle1.getValue();
        float prixEnfant=Integer.valueOf(this.prixenfant.getText());
        float prixAdulte=Integer.valueOf(this.prixadulte.getText());
        float prixEtudiant=Integer.valueOf(this.prixetudiant.getText());
        String time1=this.time.getText();
        int nbrplace=Integer.valueOf(this.nbrPlace.getText());
        //String rp = image1.replace('\\','/');  
        UploadImageFilm up=new UploadImageFilm();
        String path2=up.upload(image.getText());
        Theatre e=new Theatre(titre1,description1,dated,datef,salle1,prixEnfant,prixAdulte ,prixEtudiant, time1,path2,nbrplace);
        PropositionEventService fS=new PropositionEventService();
        fS.validerPEvent2(e);
        fS.setEtatV(p1);
        table.setItems(fS.afficherPEvent());
        //PropositionEventService fS=new PropositionEventService();

                try{
            String host ="smtp.gmail.com" ;
            String user = "pidevils1@gmail.com";
            String pass = "Lessimpson1997";
            String to = mail;
            String from = "pidevils1@gmail.com";
            String subject = "Cite de la culture";
            String messageText = "Votre proposition a été confirmée";
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
            javax.mail.Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(javax.mail.Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);
            
            
             MimeMultipart multipart = new MimeMultipart("related");

         

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
           
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
        }else{
        Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("date erronee");
        alert.setHeaderText("ajoutez une date valide");
        alert.showAndWait();
        }
            }}
        
        if(p.getTypeEvent().equals("Conference")){
            if (datedebut.getValue()!=null && datefin.getValue()!=null ){
        java.sql.Date dated = java.sql.Date.valueOf(datedebut.getValue());
        java.sql.Date datef = java.sql.Date.valueOf(datefin.getValue());
        if(cn.testdateEMB_dateEXP1(dated,datef)==-1){
        String titre1=this.titre.getText();
        String description1=this.description.getText();
        //String image1=this.image.getText();
        //String trailer1=this.trailer.getText();
//        java.sql.Date dated = java.sql.Date.valueOf(datedebut.getValue());
//        java.sql.Date datef = java.sql.Date.valueOf(datefin.getValue());
        String salle1=this.salle1.getValue();
        float prixEnfant=Integer.valueOf(this.prixenfant.getText());
        float prixAdulte=Integer.valueOf(this.prixadulte.getText());
        float prixEtudiant=Integer.valueOf(this.prixetudiant.getText());
        String time1=this.time.getText();
        int nbrplace=Integer.valueOf(this.nbrPlace.getText());
        //String rp = image1.replace('\\','/'); 
        UploadImageFilm up=new UploadImageFilm();
        String path2=up.upload(image.getText());
        Conference e=new Conference(titre1,description1,dated,datef,salle1,prixEnfant,prixAdulte ,prixEtudiant, time1,path2,nbrplace);
        PropositionEventService fS=new PropositionEventService();
        fS.validerPEvent3(e);
        fS.setEtatV(p1);
        table.setItems(fS.afficherPEvent());
        //PropositionEventService fS=new PropositionEventService();

                try{
            String host ="smtp.gmail.com" ;
            String user = "pidevils1@gmail.com";
            String pass = "Lessimpson1997";
            String to = mail;
            String from = "pidevils1@gmail.com";
            String subject = "Cite de la culture";
            String messageText = "Votre proposition a été confirmée";
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
            javax.mail.Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(javax.mail.Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);
            
            
             MimeMultipart multipart = new MimeMultipart("related");

         

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
           
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
        }else{
        Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("date erronee");
        alert.setHeaderText("ajoutez une date valide");
        alert.showAndWait();
        }
            }}
        if(p.getTypeEvent().equals("Galerie")){
            if (datedebut.getValue()!=null && datefin.getValue()!=null ){
        java.sql.Date dated = java.sql.Date.valueOf(datedebut.getValue());
        java.sql.Date datef = java.sql.Date.valueOf(datefin.getValue());
        if(cn.testdateEMB_dateEXP1(dated,datef)==-1){
        String titre1=this.titre.getText();
        String description1=this.description.getText();
        //String image1=this.image.getText();
        //String trailer1=this.trailer.getText();
//        java.sql.Date dated = java.sql.Date.valueOf(datedebut.getValue());
//        java.sql.Date datef = java.sql.Date.valueOf(datefin.getValue());
        String salle1=this.salle1.getValue();
        float prixEnfant=Integer.valueOf(this.prixenfant.getText());
        float prixAdulte=Integer.valueOf(this.prixadulte.getText());
        float prixEtudiant=Integer.valueOf(this.prixetudiant.getText());
        String time1=this.time.getText();
        int nbrplace=Integer.valueOf(this.nbrPlace.getText());
        //String rp = image1.replace('\\','/');  
        UploadImageFilm up=new UploadImageFilm();
        String path2=up.upload(image.getText());
        Galerie e=new Galerie(titre1,description1,dated,datef,salle1,prixEnfant,prixAdulte ,prixEtudiant, time1,path2,nbrplace);
        PropositionEventService fS=new PropositionEventService();
        fS.validerPEvent3(e);
        fS.setEtatV(p1);
        table.setItems(fS.afficherPEvent());
        //PropositionEventService fS=new PropositionEventService();

                try{
            String host ="smtp.gmail.com" ;
            String user = "pidevils1@gmail.com";
            String pass = "Lessimpson1997";
            String to = mail;
            String from = "pidevils1@gmail.com";
            String subject = "Cite de la culture";
            String messageText = "Votre proposition a été confirmée";
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
            javax.mail.Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(javax.mail.Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);
            
            
             MimeMultipart multipart = new MimeMultipart("related");

         

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
           
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
        }else{
        Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("date erronee");
        alert.setHeaderText("ajoutez une date valide");
        alert.showAndWait();
        }
            }}
    }

    @FXML
    private void refuserP(ActionEvent event) throws ClassNotFoundException {
                PropositionEventService fS=new PropositionEventService();

        fS.setEtatR(p1);
        UtilisateurService us=new UtilisateurService();
        Utilisateur uemail=new Utilisateur();
        uemail=us.rechercheUtilisateurParUsername(this.username);
        String mail=uemail.getEmail();
               try{
            String host ="smtp.gmail.com" ;
            String user = "pidevils1@gmail.com";
            String pass = "Lessimpson1997";
            String to = mail;
            String from = "pidevils1@gmail.com";
            String subject = "Cite de la culture";
            String messageText = "Votre proposition a été refusée";
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
            javax.mail.Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(javax.mail.Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);
            
            
             MimeMultipart multipart = new MimeMultipart("related");

         

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
           
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    @FXML
    private void changeplace(ActionEvent event) {
       FilmService fs=new FilmService();
       int pl= fs.NbrPlace(salle1.getValue());
       this.nbrPlace.setText(String.valueOf(pl));
    }

    
    
}
