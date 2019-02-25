/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Conference;
import Entities.Galerie;
import Services.RatingService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author mouna dridi
 */
public class VoirGalerieController implements Initializable {

    @FXML
    private ImageView im;
    @FXML
    private Label date;
    @FXML
    private JFXButton reserver;
    @FXML
    private JFXTextField titre;
    @FXML
    private JFXTextField time;
    @FXML
    private JFXTextArea descr;
    @FXML
    private Rating rating;
    @FXML
    private Label msg;
    int idEvent;
    String imageURI=null;
    String ima=null;
    String t=null;
    String info=null;
    String heure=null;
    String dd=null;
    int i=0;
    @FXML
    private JFXTextField d;
    @FXML
    private Label moyenne;
    @FXML
    private JFXButton fb;

        void setGalerie(Galerie f){
        idEvent=f.getIdEvent();
        RatingService fS=new RatingService();
        float cal=fS.calculer(idEvent);
        rating.ratingProperty().set(cal);
        moyenne.setText(String.valueOf(cal));
        descr.setText(f.getDescription());
        titre.setText(f.getTitre());
        imageURI = new File("C:/wamp64/"+f.getImage()).toURI().toString(); 
        final Image image = new Image(imageURI);
               
        System.out.println(f.getImage());
        //titre.setTitre(f.getTitre());
        im.setImage(image);
        time.setText(f.getTime1());
        d.setText(String.valueOf(f.getDateD()));

        //date.setText(f.getDateD());
//        Date date1=f.getDateD();
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(date1);
//        date.setText(LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH)));
//       
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void ajouterProposition(ActionEvent event) {
    }

    @FXML
    private void ajouterRating(MouseEvent event) {
        
         int note;
      

          rating.ratingProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number t, Number t1) {
                
                msg.setText(t1.toString());
                System.out.println("*************");
                System.out.println(t1.toString());
                System.out.println(idEvent);
         if (i==0){
           
                RatingService fS=new RatingService();
                fS.ajouterRate(50,idEvent,t1.intValue());
                System.out.println("**************");
        i++;
         } }
            
            
        });
    }

    @FXML
    private void partager(ActionEvent event) throws MalformedURLException, FileNotFoundException {
         ima=imageURI.replace('/', '\\'); 
        String file = new URL(ima).getPath();
        System.out.println("/////////////////////////");
        System.out.println(imageURI);
        System.out.println("/////////////////////////");
        System.out.println("******************");
        System.out.println(ima);
        System.out.println("******************");
        t=titre.getText();
        dd=d.getText();
        heure=time.getText();
        info =t+"\n"+dd+"\n"+heure;
        String access="EAAfl1TLe9i8BACrnrHzhaoXQnPtZAgnyjUvyHbDDHVsLWp8U2ZBbCSMO7SlUdE0GZB91BUrZCQQ4lySTYKYxTkZCHqDZAm6IujPy6cL887CjVkFG8r2lTrlgP0rTZB4Wr4n6mi4seFQlQiZCbbpiG9BSpo5gAc5TjsjWf3ECsZChzKXZBAhZCZCGXsmySZA8AZCZCOY5hxZCDpCEbXxU8wZDZD";
        FacebookClient fbC= new DefaultFacebookClient(access);
//        User me = fbC.fetchObject("me", User.class);
        FileInputStream f= new FileInputStream(new File(ima.replace("file:\\","")));
        FacebookType r= fbC.publish("me/photos",FacebookType.class , BinaryAttachment.with(file,f),Parameter.with("message",info));
        System.out.println("fb.com/"+r.getId());
    }
    
}
