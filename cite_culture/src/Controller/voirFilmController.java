/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author mouna dridi
 */
import Entities.Film;
import Entities.Ticket;
import Entities.Utilisateur;
import Services.RatingService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import utilitaire.UserSession;

public class voirFilmController implements Initializable{
   

    @FXML
    private ImageView im;

    @FXML
    private JFXTextField titre;


    @FXML
    private JFXTextField time;

    @FXML
    private Button trailer;

    @FXML
    private Button reserver;
    @FXML
    private Label date;
    @FXML
    private JFXTextArea descr;
    @FXML
    private Rating rating;
    @FXML
    private Label msg;
    int idEvent;
    @FXML
    private JFXButton fb;
    String imageURI=null;
    String ima=null;
    String t=null;
    String info=null;
    String heure=null;
    @FXML
    private JFXTextField d;
    String dd=null;
    @FXML
    private Label moyenne;
    int i=0;
Utilisateur u = new Utilisateur();
    
    void setFilm(Film f){
        
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
        trailer.setOnAction((event) -> {
            try {
                Desktop.getDesktop().browse(new URL(f.getTrailer()).toURI());
            } catch (URISyntaxException ex) {
                Logger.getLogger(voirFilmController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(voirFilmController.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     UserSession session=new UserSession();
    
            u=session.getUser();
             
        /*    rating.ratingProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number t, Number t1) {
                msg.setText(t1.toString());
                System.out.println("*************");
                System.out.println(t1.toString());
                System.out.println(idEvent);
        
                RatingService fS=new RatingService();
                fS.ajouterRate(50,idEvent,t1.intValue());
                System.out.println("**************");

            }
            
            
        });
  */

            
           }
    

    @FXML
    private void ajouterProposition(ActionEvent event) {
      /*  System.out.println(idEvent);
        Ticket t=new Ticket();*/
        
    }

    @FXML
    private void ajouterRating(MouseEvent event) throws IOException {
         int note;
         if(u.getNom()!=null){
          rating.ratingProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number t, Number t1) {
                
                msg.setText(t1.toString());
                System.out.println("*************");
                System.out.println(t1.toString());
                System.out.println(idEvent);
         if (i==0){
           
                RatingService fS=new RatingService();
                fS.ajouterRate(u.getId(),idEvent,t1.intValue());
                System.out.println("**************");
        i++;
         } }
            
            
        });
         }
         else{
        Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("vous n'etes pas connecté");
        alert.setHeaderText("veuillez vous connecter");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
  Stage primaryStage= new Stage();
      
         Parent root = FXMLLoader.load(getClass().getResource("/View/connection.fxml"));
        Scene scene = new Scene(root);
       
FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/connection.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE,null,ex);
        
        }
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
              
        
               

         final Node source =(Node) event.getSource();
        final Stage stage2= (Stage)source.getScene().getWindow();
        

        stage2.close();
                 stage.show();
    }
        //alert.showAndWait();
        }
    }

    @FXML
    private void partager(ActionEvent event) throws FileNotFoundException, MalformedURLException, IOException {
        if(u.getNom()!=null){
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
        String access="EAAfl1TLe9i8BAI49LvYnKpZCVNDdoVf6de4s39HzfPrhJ19kwH1NVgKqps3VSoAOZA4nkFlK8f7XZBa5vJfbyxLQ3ZBrryNlNR9hOtOa6MKuOKRE6MeFV8m0rGn4yBi2ZB555jC6ZAdeMxi35MTPPcshJOnU5Ri2hvB6uu3TZCBZCRISIXem1NA0IVX8JghNWklcie0x6dlKlAZDZD";
        FacebookClient fbC= new DefaultFacebookClient(access);
//        User me = fbC.fetchObject("me", User.class);
        FileInputStream f= new FileInputStream(new File(ima.replace("file:\\","")));
        FacebookType r= fbC.publish("me/photos",FacebookType.class , BinaryAttachment.with(file,f),Parameter.with("message",info));
        System.out.println("fb.com/"+r.getId());
   
    }else{
        Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("vous n'etes pas connecté");
        alert.setHeaderText("veuillez vous connecter");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
  Stage primaryStage= new Stage();
      
         Parent root = FXMLLoader.load(getClass().getResource("/View/connection.fxml"));
        Scene scene = new Scene(root);
       
FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/connection.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE,null,ex);
        
        }
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
              
        
               

         final Node source =(Node) event.getSource();
        final Stage stage2= (Stage)source.getScene().getWindow();
        

        stage2.close();
                 stage.show();
    }
    
    
    
    
    }
}



}

