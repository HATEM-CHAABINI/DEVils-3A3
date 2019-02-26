/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Cours;
import Entities.ReservationCours;
import Entities.Utilisateur;
import Services.CoursService;
import Services.ReservationCoursService;
import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utilitaire.UserSession;

/**
 * FXML Controller class
 *
 * @author Farah
 */
public class DetailsCoursController implements Initializable {

    @FXML
    private Label prof;
    @FXML
    private Label salle;
    @FXML
    private Label date;
    @FXML
    private Label heure_d;
    @FXML
    private Label heure_f;
    @FXML
    private Label type;
    @FXML
    private Label prix;
    @FXML
    private Button reserver;
    @FXML
    private ImageView img;
    @FXML
    private Label idC;
   /* @FXML
    private Tooltip complet;*/
    @FXML
    private Button partage;
    
  String imageURI=null;
  String  image=null;
  String t=null;
  String dd=null;
  String heure=null;
  String info=null;
    @FXML
    private Label note;
    @FXML
    private Button like;
  Utilisateur u = new Utilisateur();
     void setCours(Cours c) throws ClassNotFoundException{
          
         
         CoursService cs= new CoursService();
        
         String pr=cs.NomProf(c);
         String sall=cs.getDes_Salle(c.getId_salle());
         idC.setText(String.valueOf(c.getId_cours()));
        type.setText("Cours de "+c.getType());
        prof.setText(pr);
        salle.setText(sall);
        date.setText(String.valueOf(c.getDate()));
        heure_d.setText("De "+c.getHeure_debut()+" h jusqu'à "+c.getHeure_fin()+" h");
       // heure_f.setText();
        prix.setText(String.valueOf(c.getPrix())+" dt");
         
         //String k="C:/wamp64/"+maList.get(i).getImage();              
                imageURI = new File("D:/wamp64/"+c.getImage()).toURI().toString(); 
        
        //imageURI = new File(c.getImage()).toURI().toString(); 
         Image image = new Image(imageURI);
               
System.out.println(c.getImage());
        img.setImage(image);
        
if (cs.getIdCours(u.getId())==c.getId_cours())
{
             reserver.setDisable(true);
            reserver.setText("réservé");
}
       
       
    
        
        if(c.getNb_places()==0)
        {
            reserver.setDisable(true);
            reserver.setText("complet");
            
        }
        int somme=cs.compter(Integer.valueOf(this.idC.getText()));
        note.setText(String.valueOf(somme)+" personnes aime ça");
       
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserSession session=new UserSession();
    
            u=session.getUser();
        
        // TODO
    }    
     @FXML
    private void ajouter(ActionEvent event) throws ClassNotFoundException {
        
//        int idC=Integer.valueOf(this.id.getText());
        
        ReservationCours e=new ReservationCours(u.getId(),Integer.valueOf(this.idC.getText()));
        ReservationCoursService cS=new ReservationCoursService();
        cS.ajouterReservationCours(e);
        
        CoursService cs= new CoursService();
            cs.DiminuerPlaces(Integer.valueOf(this.idC.getText()));
           
          this.reserver.setDisable(true);
          this.reserver.setText("réservé");
       
        
        
    }
     @FXML
    private void noter(ActionEvent event) throws ClassNotFoundException {
        
//        int idC=Integer.valueOf(this.id.getText());
        
       // ReservationCours e=new ReservationCours(3,Integer.valueOf(this.idC.getText()));
        ReservationCoursService cS=new ReservationCoursService();
        cS.noter(u.getId(),Integer.valueOf(this.idC.getText()),1);
        
        like.setDisable(true);
        like.setText("aime ça");
        
        
        
        
    }
    @FXML
    private void partager(ActionEvent event) throws FileNotFoundException, MalformedURLException {
     
        image =imageURI.replace('/', '\\'); 
        String file = new URL(image).getPath();
        System.out.println("/////////////////////////");
        System.out.println(imageURI);
        System.out.println("/////////////////////////");
        System.out.println("****************");
        System.out.println(image);
        System.out.println("****************");
         t=type.getText();
        dd=date.getText();
        heure=heure_d.getText();
         info =t+"\n"+dd+"\n"+heure;
        String access="EAAkfZBZBMHZAJEBAFCZBLScn0iIZBqPnm6InqTt10yQDN8Vws9FaKkkqn2ohHHNhdl9u0tScsPLmD7hu0SRnXwjD878MKy8ebQ5IKNQSiKzMdI4C3LCL9ZCWSFLMlClJynFRaYDP6CFDJtZBe1odkWnVEpjAUwGnZArDm2N6EcmdKZAGSBReLkDRHqtppg6D95EAu6ZB9Sf9f9pQZDZD";
        FacebookClient fbC= new DefaultFacebookClient(access);
//        User me = fbC.fetchObject("me", User.class);
        FileInputStream f= new FileInputStream(new File(image.replace("file:\\","")));
        FacebookType r= fbC.publish("me/photos",FacebookType.class ,BinaryAttachment.with(file, f),Parameter.with("message",info));
        System.out.println("fb.com/"+r.getId());
   
    }
}
